package com.example.resourcemanagergtfo.core.models.vm_models.interfaces

import androidx.lifecycle.LiveData

/**
 * @author Marco Preciado
 * @property title The title for this ViewModel
 * @property headers Other headers assigned to this view
 * @property model the model that represents this view
 */
interface IVM<T> {
    var title: String
    var headers: List<String>
    var model: LiveData<T>?


    /**
     * Should be used for initializing this view with necessary data
     */
    fun onViewLoad(vararg args: Any)

    /**
     * Acts as the back button pressed function
     */
    fun onBackButtonClicked()

    /**
     * Navigates to the provided route
     */
    fun navigateTo(route: String)
}