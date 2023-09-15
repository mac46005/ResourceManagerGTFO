package com.example.resourcemanagergtfo.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.navArgument

sealed class Argument(val name: String) {
    var navArgument: NamedNavArgument? = null

    object ID: Argument("id"){
        override fun buildNavArgumnet(navArgumentBuilder: NavArgumentBuilder.() -> Unit): Argument {
            navArgument = navArgument(name, navArgumentBuilder)
            return this
        }
    }







    abstract fun buildNavArgumnet(navArgumentBuilder: NavArgumentBuilder.() -> Unit): Argument
}