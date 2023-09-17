package com.example.resourcemanagergtfo.features.zones

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.resourcemanagergtfo.core.composables.composables_gtfo.views.MainView
import com.example.resourcemanagergtfo.features.zones.core.ZonesVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZonesView(
    navController: NavController,
    vm: ZonesVM = hiltViewModel()
){
    vm!!.onViewLoad(navController)
    MainView(
        title = "Zones",
        backButtonVisible = false,
        action = {
            Button(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = {
                    vm.reset()
                }
            ) {
                Text(text = "RESET")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            val list by vm.loadList().collectAsState(initial = emptyList())

            LazyColumn(){
                items(list!!){
                    Box(
                        modifier = Modifier.clickable { 
                            vm.onItemSelected(it) 
                        }
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = it.toString()
                        )
                    }
                }
            }



            val newZoneState by vm.newZoneID.observeAsState()


            Row() {
                TextField(
                    value = newZoneState!!,
                    onValueChange = {
                    vm.onNewZoneNameChange(it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "Insert zone id here...")}
                )
                Button(
                    onClick = { vm.submit() }
                ) {
                    Text(text = "Add Zone")
                }
            }
        }
    }
}