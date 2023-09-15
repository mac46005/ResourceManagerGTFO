package com.example.resourcemanagergtfo.core.models.vm_models.interfaces

import androidx.lifecycle.LiveData

interface IVM<T> {
    var title: String
    var headers: List<String>
    var model: LiveData<T>?

    fun setModel(model: T)
    fun getModel(): T
    fun onLoad(vararg args: Any)
    fun onBackButtonClicked()
    fun navigateTo(route: String)
}