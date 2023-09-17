package com.example.resourcemanagergtfo.core.models.app_models

import com.example.resourcemanagergtfo.data.ResourceRepo
import com.example.resourcemanagergtfo.data.ZoneRepo
import javax.inject.Inject

class GTFOResourceManager @Inject constructor() {
    val zoneRepo = ZoneRepo()
    val resourceRepo = ResourceRepo()
}