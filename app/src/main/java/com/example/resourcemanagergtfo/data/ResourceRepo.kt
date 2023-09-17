package com.example.resourcemanagergtfo.data

import com.example.resourcemanagergtfo.core.models.app_models.AmmoPack
import com.example.resourcemanagergtfo.core.models.app_models.IResourcePack
import com.example.resourcemanagergtfo.core.models.app_models.MediPack
import com.example.resourcemanagergtfo.core.models.app_models.ResourcePackType
import com.example.resourcemanagergtfo.core.models.app_models.ToolRefill
import com.example.resourcemanagergtfo.data.interfaces.ICRUD
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ResourceRepo @Inject constructor() : ICRUD<IResourcePack,Int>  {
    var resources: MutableList<IResourcePack> = mutableListOf()
    override fun create(item: IResourcePack) {
        resources.add(item)
    }

    override fun delete(item: IResourcePack) {
        resources.remove(item)
    }

    override fun read(id: Int, vararg keys: Any?): IResourcePack? {
        return resources.find { resource ->
            resource.id == id && resource.zoneId == keys[0] as Int
        }!!
    }

    override fun read(vararg keys: Any?): Flow<List<IResourcePack>?> {
        return flow {
            val list = mutableListOf<IResourcePack>()
            resources.forEach { r ->
                if(r.zoneId == keys[0]){
                    list.add(r)
                }
            }
            emit(list)
        }
    }

    override fun update(item: IResourcePack) {
        TODO()
    }

    fun clear(){
        resources.clear()
    }

    fun createResources(resourceType: ResourcePackType, resourceIds: String, zoneId: Int){
        val ids = resourceIds.split(',')
        when(resourceType){
            ResourcePackType.AmmoPack -> {
                for(id in ids){
                    create(AmmoPack(id = id.trim().toInt(), zoneId = zoneId))
                }
            }
            ResourcePackType.MediPack -> {
                for(id in ids){
                    create(MediPack(id = id.trim().toInt(), zoneId = zoneId))
                }
            }
            ResourcePackType.ToolRefill -> {
                for(id in ids){
                    create(ToolRefill(id = id.trim().toInt(), zoneId = zoneId))
                }
            }
        }
    }
}