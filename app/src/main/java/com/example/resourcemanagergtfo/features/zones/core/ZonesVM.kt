package com.example.resourcemanagergtfo.features.zones.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.models.app_models.GTFOResourceManager
import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IAddItem
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IListDisplayVM
import com.example.resourcemanagergtfo.core.models.vm_models.models.ListDisplayFormVM
import com.example.resourcemanagergtfo.core.navigation.Screen
import com.example.resourcemanagergtfo.data.ZoneRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ZonesVM @Inject constructor(
    private val zoneRepo: ZoneRepo
) : ListDisplayFormVM<Zone, Zone>() {

    override fun loadList(vararg args: Any): Flow<List<Zone>?> {
        return zoneRepo.read()
    }

    override fun onItemSelected(item: Zone) {
        _selectedItem.value = item
        _navController!!.navigate(Screen.Resources.withArgs(item.id.toString()))
    }

    private var _newZoneId: MutableLiveData<String> = MutableLiveData("")
    val newZoneID: LiveData<String> = _newZoneId

    fun onNewZoneNameChange(id: String){
        _newZoneId.value = id
    }
    override fun submit() {
        zoneRepo.create(Zone(id = _newZoneId.value!!.trim().toInt()))
        _newZoneId.value = ""
    }


    override fun onViewLoad(vararg args: Any) {
        _navController = args[0] as NavController
        title = "Zones"
    }

    override fun onBackButtonClicked() {

    }



    fun reset(){
        zoneRepo.clear()
    }
}