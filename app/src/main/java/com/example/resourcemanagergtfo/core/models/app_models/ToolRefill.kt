package com.example.resourcemanagergtfo.core.models.app_models

class ToolRefill(
    override val id: String,
    override val isCollected: Boolean) : IResourcePack {
    override fun toString(): String {
        return "TOOL_REFILL_$id"
    }
}