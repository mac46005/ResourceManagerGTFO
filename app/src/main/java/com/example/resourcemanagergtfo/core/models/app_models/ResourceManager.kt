package com.example.resourcemanagergtfo.core.models.app_models

import com.example.resourcemanagergtfo.data.ZoneRepo
import javax.inject.Inject

class ResourceManager @Inject constructor() {
    val zoneRepo = ZoneRepo()
}