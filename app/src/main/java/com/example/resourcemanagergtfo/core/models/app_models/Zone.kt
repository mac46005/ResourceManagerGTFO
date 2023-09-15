package com.example.resourcemanagergtfo.core.models.app_models

class Zone(
    val id: String
) {
    var resourceList: MutableList<IResourcePack> = mutableListOf()

    fun addResource(resource: IResourcePack){
        resourceList.add(resource)
    }

    fun addResourcesFromString(resourceType: ResourcePackType, resourceIds: String){

        var ids = resourceIds.split(',')

        when(resourceType){
            ResourcePackType.AmmoPack -> {
                ids.forEach {id ->
                    addResource(AmmoPack(id.trim()))
                }
            }
            ResourcePackType.MediPack -> {
                ids.forEach { id -> addResource(MediPack(id.trim())) }
            }
            ResourcePackType.ToolRefill -> {
                ids.forEach { id -> addResource(ToolRefill(id = id.trim())) }
            }
        }
    }

    override fun toString(): String {
        return "ZONE_$id"
    }
}