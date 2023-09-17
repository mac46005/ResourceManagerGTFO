package com.example.resourcemanagergtfo.features.resources.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.models.app_models.IResourcePack
import com.example.resourcemanagergtfo.core.models.app_models.ResourcePackType
import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.core.models.vm_models.models.ListDisplayFormVM
import com.example.resourcemanagergtfo.data.ResourceRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ResourcesVM @Inject constructor(
    private val resourceRepo: ResourceRepo
): ListDisplayFormVM<IResourcePack, Zone>(){

    override fun onViewLoad(vararg args: Any) {
        _navController = args[0] as NavController
        _listInfo.value = args[1] as Zone

        title = "Resources in ${_listInfo.value.toString()}"
    }

    override fun loadList(vararg args: Any): Flow<List<IResourcePack>?> {
        return resourceRepo.read(_listInfo.value!!.id as Any)
    }



    override fun onBackButtonClicked() {
        _navController!!.popBackStack()
    }

    override fun onItemSelected(item: IResourcePack) {
        TODO("Not yet implemented")
    }

    private var _resourceType: MutableLiveData<ResourcePackType> = MutableLiveData(ResourcePackType.AMMOPACK)
    var resourceType: LiveData<ResourcePackType> = _resourceType

    private var _resourceNames: MutableLiveData<String> = MutableLiveData("")
    var resourceNames: LiveData<String> = _resourceNames
    fun resourceNamesChanged(names: String){
        _resourceNames.value = names
    }

    fun resourceTypeChanged(resourceType: ResourcePackType){
        _resourceType.value = resourceType
    }

    override fun submit() {
        resourceRepo.createResources(_resourceType.value!!, _resourceNames.value!!, _listInfo.value!!.id)
        _resourceNames.value = ""
    }

}