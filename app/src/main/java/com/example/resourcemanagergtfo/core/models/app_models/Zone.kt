package com.example.resourcemanagergtfo.core.models.app_models

import com.example.resourcemanagergtfo.data.ResourceRepo
import kotlinx.coroutines.flow.Flow

class Zone(
    val id: String
) {
    private var resourceRepo: ResourceRepo = ResourceRepo()


    fun addResourcesFromString(resourceType: ResourcePackType, resourceIds: String){

        val ids = resourceIds.split(',')

        when(resourceType){
            ResourcePackType.AmmoPack -> {
                ids.forEach {id -> resourceRepo.create(AmmoPack(id = id.trim())) }
            }
            ResourcePackType.MediPack -> {
                ids.forEach { id -> resourceRepo.create(MediPack(id = id.trim())) }
            }
            ResourcePackType.ToolRefill -> {
                ids.forEach { id -> resourceRepo.create(ToolRefill(id = id.trim())) }
            }
        }
    }

    fun loadResourceList(): Flow<List<IResourcePack>?>{
        return resourceRepo.read()
    }

    fun delete(item: IResourcePack){
        resourceRepo.delete(item)
    }
    fun clear(){
        resourceRepo.clear()
    }
    override fun toString(): String {
        return "ZONE_$id"
    }
}