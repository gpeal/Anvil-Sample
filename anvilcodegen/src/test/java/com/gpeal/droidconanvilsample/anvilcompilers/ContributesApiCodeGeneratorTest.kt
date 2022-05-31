package com.gpeal.droidconanvilsample.anvilcompilers

import com.google.common.truth.Truth.assertThat
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.compiler.internal.testing.compileAnvil
import com.tschuchort.compiletesting.KotlinCompilation.ExitCode.OK
import dagger.Provides
import dagger.Reusable
import org.junit.Test
import java.lang.reflect.AnnotatedElement

class ContributesApiCodeGeneratorTest {

    @Test fun `a dagger module is generated`() {
        compileAnvil(
            """
                package com.test
                
                import com.gpeal.droidconanvilsample.lib.daggerscopes.ContributesApi

                @ContributesApi(Any::class)
                interface TestApi
            """
        ) {
            assertThat(exitCode).isEqualTo(OK)

            val clazz = classLoader.loadClass("com.test.TestApi_Module")

            val contributesToAnnotation = clazz.annotation<ContributesTo>()
            assertThat(contributesToAnnotation.scope).isEqualTo(Any::class)

            val providerMethod = clazz.declaredMethods.single()

            assertThat(providerMethod.returnType).isEqualTo(classLoader.loadClass("com.test.TestApi"))
            assertThat(providerMethod.annotations.map { it.annotationClass }).containsExactly(Provides::class, Reusable::class)
        }
    }
}

inline fun <reified T> AnnotatedElement.annotationOrNull(): T? =
    annotations.singleOrNull { it.annotationClass == T::class } as? T

inline fun <reified T> AnnotatedElement.annotation(): T =
    requireNotNull(annotationOrNull<T>()) { "Couldn't find annotation ${T::class}" }