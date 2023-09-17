package com.example.resourcemanagergtfo.features.resources.core

import androidx.compose.runtime.Composable
import com.example.resourcemanagergtfo.core.models.app_models.ToolRefill
import com.example.resourcemanagergtfo.ui.theme.blueTool

@Composable
fun ToolItem(
    toolRefill: ToolRefill
){
    ResourceItem(resourcePack = toolRefill, textColor = blueTool)
}