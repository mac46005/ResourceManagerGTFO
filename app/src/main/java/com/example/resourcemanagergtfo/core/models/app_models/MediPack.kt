package com.example.resourcemanagergtfo.core.models.app_models

class MediPack(
    override val id: String,
    override val isCollected: Boolean
    ) : IResourcePack {
    override fun toString(): String {
        return "MEDIPACK_$id"
    }
}