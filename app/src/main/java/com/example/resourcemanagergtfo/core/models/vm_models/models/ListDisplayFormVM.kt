package com.example.resourcemanagergtfo.core.models.vm_models.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IAddItem
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IForm
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IListDisplayVM

abstract class ListDisplayFormVM<T, U>: IListDisplayVM<T, U>, IForm<T>, VM<T>() {
    protected var _listInfo: MutableLiveData<U> = MutableLiveData()
    override var listInfo: LiveData<U>? = _listInfo
    protected var _selectedItem: MutableLiveData<T> = MutableLiveData()
    override var selectedItem: LiveData<T>? = _selectedItem
}