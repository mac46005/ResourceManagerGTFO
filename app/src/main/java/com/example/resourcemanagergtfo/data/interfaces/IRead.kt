package com.example.resourcemanagergtfo.data.interfaces

import kotlinx.coroutines.flow.Flow


interface IRead<T,U> {
    fun read(id: U): T
    fun read(): Flow<List<T>?>
}