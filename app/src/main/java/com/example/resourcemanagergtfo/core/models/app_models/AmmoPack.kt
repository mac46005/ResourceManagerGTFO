package com.example.resourcemanagergtfo.core.models.app_models

class AmmoPack(
    override val id: String,
    override val isCollected: Boolean
    ) : IResourcePack{


    override fun toString(): String {
        return "AMMOPACK_$id"
    }
}