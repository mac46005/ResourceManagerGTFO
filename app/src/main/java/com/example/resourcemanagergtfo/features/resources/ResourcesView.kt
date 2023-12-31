package com.example.resourcemanagergtfo.features.resources

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.composables.composables_gtfo.views.MainView
import com.example.resourcemanagergtfo.core.models.app_models.AmmoPack
import com.example.resourcemanagergtfo.core.models.app_models.MediPack
import com.example.resourcemanagergtfo.core.models.app_models.ResourcePackType
import com.example.resourcemanagergtfo.core.models.app_models.ToolRefill
import com.example.resourcemanagergtfo.core.models.app_models.Zone
import com.example.resourcemanagergtfo.features.resources.core.AmmoItem
import com.example.resourcemanagergtfo.features.resources.core.MediItem
import com.example.resourcemanagergtfo.features.resources.core.ResourcesVM
import com.example.resourcemanagergtfo.features.resources.core.ToolItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourcesView(
    navController: NavController,
    zone: Zone,
    vm: ResourcesVM = hiltViewModel()
){
    vm.onViewLoad(navController, zone)


    MainView(
        title = vm.title,
        onBackButtonClicked = {vm.onBackButtonClicked() },
        action = {
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val list by vm.loadList(zone.id).collectAsState(initial = emptyList())

            LazyColumn(){
                items(list!!){
                    when(it){
                        is AmmoPack -> AmmoItem(ammoPack = it)
                        is MediPack -> MediItem(mediPack = it)
                        is ToolRefill -> ToolItem(toolRefill = it)
                    }
                }
            }

            val resourceTypeState by vm.resourceType.observeAsState()
            val resourceNameState by vm.resourceNames.observeAsState()
            val isExpanded = remember {
                mutableStateOf(false)
            }
            Column() {
                Row() {
                    Button(onClick = { isExpanded.value = true }) {
                        Text(text = "Select Resource Type")
                    }
                    Text(text = resourceTypeState!!.name)
                    DropdownMenu(expanded = isExpanded.value, onDismissRequest = { isExpanded.value = false }) {
                        for (rt in ResourcePackType.values()){
                            DropdownMenuItem(
                                text = { Text(text = rt.name) },
                                onClick = {
                                    vm.resourceTypeChanged(rt)
                                    isExpanded.value = false
                                }
                            )
                        }
                    }
                }
                TextField(
                    value = resourceNameState!!,
                    onValueChange = {vm.resourceNamesChanged(it)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(onClick = { vm.submit() }) {
                    Text(text = "Add Resources")
                }
            }
        }

    }
}