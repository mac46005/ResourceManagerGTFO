package com.example.resourcemanagergtfo.features.resources.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.models.app_models.IResourcePack
import com.example.resourcemanagergtfo.core.models.app_models.ResourceManager
import com.example.resourcemanagergtfo.core.models.app_models.ResourcePackType
import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IAddItem
import com.example.resourcemanagergtfo.core.models.vm_models.interfaces.IListDisplayVM
import com.example.resourcemanagergtfo.core.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ResourcesVM @Inject constructor(
    private val resourceManager: ResourceManager
): IListDisplayVM<IResourcePack>, IAddItem<IResourcePack>, ViewModel() {

    private var navController: NavController? = null
    private var zoneId: String = ""
    override var listInfo: MutableMap<String, Any> = mutableMapOf()
    private var _selectedItem: MutableLiveData<IResourcePack> = MutableLiveData()
    override var selectedItem: LiveData<IResourcePack>? = _selectedItem
    override var title: String = "Resources from ${listInfo[zoneId].toString()}"
    override var headers: List<String> = listOf()
    private var _model: MutableLiveData<IResourcePack> = MutableLiveData()
    override var model: LiveData<IResourcePack>? = _model


    override fun loadList(vararg args: Any): Flow<List<IResourcePack>?> {
        return resourceManager.zoneRepo.read(zoneId).loadResourceList()
    }

    override fun onItemSelected(item: IResourcePack) {
        TODO("Not yet implemented")
    }

    private var _resourceNames: MutableLiveData<String> = MutableLiveData("")
    var resourceNames: LiveData<String> = _resourceNames

    private var _resourceType: MutableLiveData<ResourcePackType> = MutableLiveData(ResourcePackType.AmmoPack)
    var resourceType: LiveData<ResourcePackType> = _resourceType

    fun resourceTypeChanged(resourceType: ResourcePackType){
        _resourceType.value = resourceType
    }
    fun resourceNamesChanged(resourceNames: String){
        _resourceNames.value = resourceNames
    }
    override fun submit() {
        resourceManager.zoneRepo.read(zoneId).addResourcesFromString(_resourceType.value!!, _resourceNames.value!!)
    }


    override fun getModel(): IResourcePack {
        TODO("Not yet implemented")
    }

    override fun onLoad(vararg args: Any) {
        navController = args[0] as NavController
        zoneId = (args[1] as Zone).id
        listInfo[zoneId] = resourceManager.zoneRepo.read(id = zoneId)
    }

    override fun onBackButtonClicked() {
        navController!!.navigate(Screen.Zones.fullRoute())
    }

    override fun navigateTo(route: String) {
        navController!!.navigate(route)
    }

    override fun setModel(model: IResourcePack) {
        TODO("Not yet implemented")
    }
}