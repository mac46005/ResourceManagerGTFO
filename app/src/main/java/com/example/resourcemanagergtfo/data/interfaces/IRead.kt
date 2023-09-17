package com.example.resourcemanagergtfo.data.interfaces

import kotlinx.coroutines.flow.Flow


interface IRead<T,U> {
    fun read(id: U, vararg keys: Any?): T?
    fun read(vararg keys: Any?): Flow<List<T>?>
}