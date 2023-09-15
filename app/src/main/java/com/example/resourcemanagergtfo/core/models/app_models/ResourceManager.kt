package com.example.resourcemanagergtfo.core.models.app_models

import javax.inject.Inject

class ResourceManager @Inject constructor() {
    private var zones: MutableMap<String, Zone> = mutableMapOf()
    fun addZone(id: String){
        zones[id] = Zone(id = id)
    }
}