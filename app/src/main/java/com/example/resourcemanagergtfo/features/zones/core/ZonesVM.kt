package com.example.resourcemanagergtfo.features.zones.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.models.app_models.GTFOResourceManager
import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IAddItem
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IListDisplayVM
import com.example.resourcemanagergtfo.core.navigation.Screen
import com.example.resourcemanagergtfo.data.ZoneRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ZonesVM @Inject constructor(
    private val zoneRepo: ZoneRepo
) :IListDisplayVM<Zone>, IAddItem<Zone>, ViewModel() {

    private var navController: NavController? = null
    override var listInfo: MutableMap<String, Any> = mutableMapOf()
    private var _selectedItem: MutableLiveData<Zone> = MutableLiveData(Zone(id = 0))
    override var selectedItem: LiveData<Zone>? = _selectedItem
    override var title: String = "Zones"
    override var headers: List<String> = listOf()
    private var _model: MutableLiveData<Zone> = MutableLiveData(Zone(0))
    override var model: LiveData<Zone>? = _model
    override fun loadList(vararg args: Any): Flow<List<Zone>?> {
        return zoneRepo.read()
    }

    override fun onItemSelected(item: Zone) {
        _selectedItem.value = item
        navController!!.navigate(Screen.Resources.withArgs(item.id.toString()))
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


    override fun getModel(): Zone {
        TODO("Not yet implemented")
    }

    override fun onLoad(vararg args: Any) {
        navController = args[0] as NavController
    }

    override fun onBackButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun navigateTo(route: String) {
        navController!!.navigate(route)
    }

    override fun setModel(model: Zone) {
        TODO("Not yet implemented")
    }

    fun reset(){
        zoneRepo.clear()
    }
}