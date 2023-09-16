package com.example.resourcemanagergtfo.data

import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.data.interfaces.ICRUD
import kotlinx.coroutines.flow.Flow

class ZoneRepo: ICRUD<Zone> {
    override fun create(item: Zone) {
        TODO("Not yet implemented")
    }

    override fun delete(item: Zone) {
        TODO("Not yet implemented")
    }

    override fun <U> read(id: U): Zone {
        TODO("Not yet implemented")
    }

    override fun read(): Flow<List<Zone>?> {
        TODO("Not yet implemented")
    }

    override fun update(item: Zone) {
        TODO("Not yet implemented")
    }
}