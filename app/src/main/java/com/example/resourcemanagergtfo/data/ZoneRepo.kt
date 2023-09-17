package com.example.resourcemanagergtfo.data

import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.data.interfaces.ICRUD
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ZoneRepo @Inject constructor(): ICRUD<Zone, Int> {
    private val zones: MutableList<Zone> = mutableListOf()


    override fun create(item: Zone) {
        zones.add(item)
    }

    override fun delete(item: Zone) {
        zones.removeIf {zone -> zone.id == item.id }
    }
    override fun read(id: Int, vararg keys: Any?): Zone? {
        return zones.find { zone -> zone.id == id }
    }


    override fun read(vararg keys: Any?): Flow<List<Zone>?> {
        return  flow {
            emit(zones.sortedBy { zone ->  zone.id })
        }
    }

    override fun update(item: Zone) {
         TODO()
    }

    fun clear(){
        zones.clear()
    }
}