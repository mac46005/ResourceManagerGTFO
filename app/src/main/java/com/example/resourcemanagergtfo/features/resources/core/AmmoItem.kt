package com.example.resourcemanagergtfo.features.resources.core

import androidx.compose.runtime.Composable
import com.example.resourcemanagergtfo.core.models.app_models.AmmoPack
import com.example.resourcemanagergtfo.ui.theme.orangeAmmo
@Composable
fun AmmoItem(
    ammoPack: AmmoPack
){
    ResourceItem(
        resourcePack = ammoPack,
        textColor = orangeAmmo
    )
}