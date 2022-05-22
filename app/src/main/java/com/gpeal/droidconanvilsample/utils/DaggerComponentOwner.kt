package com.gpeal.droidconanvilsample.utils

interface DaggerComponentOwner {
    /** This is either a component, or a list of components. */
    val daggerComponent: Any
}