package com.example.resourcemanagergtfo.core.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    private val baseRoute: String,
    val arguments: List<Argument>? = null
){
    fun fullRoute(): String{
        return buildString{
            append(baseRoute)
            arguments?.forEach{ arg->
                append("/{${arg.name}}")
            }
        }
    }

    fun namedNavArguments(): List<NamedNavArgument>{
        val argsList = mutableListOf<NamedNavArgument>()
        arguments!!.forEach { arg ->
            argsList.add(arg.navArgument!!)
        }
        return argsList
    }

    fun withArgs(vararg args: String): String {
        return buildString{
            append(baseRoute)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}