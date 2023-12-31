package com.example.resourcemanagergtfo.core.models.vm_models.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IVM

abstract class VM<T>: ViewModel(), IVM<T> {
    protected var _navController: NavController? = null

    protected var _model: MutableLiveData<T> = MutableLiveData()
    override var model: LiveData<T>? = _model

    private var _title: String = ""
    override var title: String
        get() = _title
        set(value){
            _title = value
        }

    private var _headers: List<String> = emptyList()
    override var headers: List<String>
        get() = _headers
        set(value){
            _headers = value
        }

    override fun navigateTo(route: String) {
        _navController!!.navigate(route)
    }
}