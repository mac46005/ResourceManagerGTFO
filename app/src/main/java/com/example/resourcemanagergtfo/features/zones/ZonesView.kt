package com.example.resourcemanagergtfo.features.zones

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.resourcemanagergtfo.core.composables.composables_gtfo.views.MainView
import com.example.resourcemanagergtfo.features.zones.core.ZonesVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZonesView(
    vm: ZonesVM = hiltViewModel()
){
    MainView(
        title = "Zones",
        action = {
            Button(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = {

                }
            ) {
                Text(text = "RESET")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            val list by vm.loadList().collectAsState(initial = emptyList())

            LazyColumn(){
                items(list!!){
                    Box(modifier = Modifier.clickable {
                        vm.onItemSelected(it)
                    }){
                        Text(text = it.toString())
                    }
                }
            }



            val newZoneState by vm.newZoneID.observeAsState()


            Row() {
                TextField(value = newZoneState!!, onValueChange = {
                    vm.onNewZoneNameChange(it)
                })
                Button(onClick = { vm.submit() }) {
                    Text(text = "Add Zone")
                }
            }
        }
    }
}