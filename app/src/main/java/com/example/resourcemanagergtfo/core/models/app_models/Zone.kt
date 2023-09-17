package com.example.resourcemanagergtfo.core.models.app_models

import com.example.resourcemanagergtfo.data.ResourceRepo
import kotlinx.coroutines.flow.Flow

class Zone(
    val id: Int
) {
    override fun toString(): String {
        return "ZONE_$id"
    }
}