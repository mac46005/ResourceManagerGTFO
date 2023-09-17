package com.example.resourcemanagergtfo.core.models.app_models

class MediPack(
    override val id: Int,
    override val zoneId: Int,
    override var isCollected: Boolean = false
    ) : IResourcePack {
    override fun toString(): String {
        return "MEDIPACK_$id"
    }
}