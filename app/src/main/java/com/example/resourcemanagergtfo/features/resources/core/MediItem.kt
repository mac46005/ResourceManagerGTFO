package com.example.resourcemanagergtfo.features.resources.core

import androidx.compose.runtime.Composable
import com.example.resourcemanagergtfo.core.models.app_models.MediPack
import com.example.resourcemanagergtfo.ui.theme.greenMedi
@Composable
fun MediItem(
    mediPack: MediPack
){
    ResourceItem(
        resourcePack = mediPack,
        textColor = greenMedi
    )
}