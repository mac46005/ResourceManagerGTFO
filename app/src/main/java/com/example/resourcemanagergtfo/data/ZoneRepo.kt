package com.example.resourcemanagergtfo.data

import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.data.interfaces.ICRUD
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ZoneRepo: ICRUD<Zone, String> {
    private val zones: MutableMap<String, Zone> = mutableMapOf()


    override fun create(item: Zone) {
        zones[item.id] = item
    }

    override fun delete(item: Zone) {
        zones.remove(item.id)
    }
    override fun read(id: String): Zone {
        return zones[id]!!
    }


    override fun read(): Flow<List<Zone>?> {
        return  flow{
            val list = mutableListOf<Zone>()
            zones.forEach{str, zone -> list.add(zone)}
            emit(list)
        }
    }

    override fun update(item: Zone) {
        zones[item.id] = item
    }

    fun clear(){
        zones.clear()
    }
}