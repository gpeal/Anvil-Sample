package com.gpeal.droidconanvilsample.lib.daggerscopes.utils

interface DaggerComponentOwner {
    /** This is either a component, or a list of components. */
    val daggerComponent: Any
}