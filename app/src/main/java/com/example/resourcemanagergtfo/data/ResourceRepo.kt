package com.example.resourcemanagergtfo.data

import com.example.resourcemanagergtfo.core.models.app_models.IResourcePack
import com.example.resourcemanagergtfo.data.interfaces.ICRUD
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ResourceRepo: ICRUD<IResourcePack,String>  {
    var resources: MutableList<IResourcePack> = mutableListOf()
    override fun create(item: IResourcePack) {
        resources.add(item)
    }

    override fun delete(item: IResourcePack) {
        resources.remove(item)
    }

    override fun read(id: String): IResourcePack {
        return resources.find { resource ->
            resource.id == id
        }!!
    }

    override fun read(): Flow<List<IResourcePack>?> {
        return flow {
            emit(resources)
        }
    }

    override fun update(item: IResourcePack) {
        TODO()
    }

    fun clear(){
        resources.clear()
    }

}