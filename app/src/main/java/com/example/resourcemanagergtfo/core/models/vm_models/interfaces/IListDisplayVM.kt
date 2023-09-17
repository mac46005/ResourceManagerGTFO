package com.example.resourcemanagergtfo.core.models.vm_models.interfaces

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface IListDisplayVM<T, U>: IVM<T> {
    var listInfo: LiveData<U>?
    var selectedItem: LiveData<T>?
    fun loadList(vararg args: Any): Flow<List<T>?>
    fun onItemSelected(item: T)
}