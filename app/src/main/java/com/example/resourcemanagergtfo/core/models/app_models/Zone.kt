package com.example.resourcemanagergtfo.core.models.app_models

class Zone(
    val id: String
) {
    var resourceList: MutableList<IResourcePack> = mutableListOf()

    override fun toString(): String {
        return "ZONE_$id"
    }
}