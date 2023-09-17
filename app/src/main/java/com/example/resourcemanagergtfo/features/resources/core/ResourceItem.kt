package com.example.resourcemanagergtfo.features.resources.core

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.resourcemanagergtfo.core.models.app_models.AmmoPack
import com.example.resourcemanagergtfo.core.models.app_models.IResourcePack
import com.example.resourcemanagergtfo.ui.theme.ResourceManagerGTFOTheme

@Composable
fun ResourceItem(
    resourcePack: IResourcePack,
    textColor: Color = Color.Black
){
    ResourceManagerGTFOTheme() {
        val checkedState = remember {
            mutableStateOf(false)
        }

        val boxColor by animateColorAsState(targetValue = if(checkedState.value) Color.Green else Color.Transparent)

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Checkbox(
                modifier = Modifier.align(Alignment.CenterStart),
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                }
            )
            Text(
                text = resourcePack.toString(),
                color = textColor
            )
        }
    }

}

@Preview
@Composable
fun PreviewResourceItem(){
    ResourceItem(resourcePack = AmmoPack(id = 122, zoneId = 222))
}