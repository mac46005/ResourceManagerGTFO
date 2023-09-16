package com.example.resourcemanagergtfo.features.zones

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {




            LazyColumn(){
                items(){

                }
            }






            Row() {
                TextField(value = "", onValueChange = {})
                Button(onClick = {  }) {
                    Text(text = "")
                }
            }
        }
    }
}