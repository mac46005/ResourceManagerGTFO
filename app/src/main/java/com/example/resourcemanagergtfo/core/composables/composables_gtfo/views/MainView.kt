package com.example.resourcemanagergtfo.core.composables.composables_gtfo.views

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.resourcemanagergtfo.core.composables.composables_gtfo.components.MainTopBar
import com.example.resourcemanagergtfo.ui.theme.ResourceManagerGTFOTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    title: String,
    backButtonVisible: Boolean = true,
    onBackButtonClicked: () -> Unit = {},
    action: @Composable (BoxScope.() -> Unit),
    content:@Composable (PaddingValues) -> Unit
){
    ResourceManagerGTFOTheme(
        dynamicColor = false
    ) {
        Scaffold(
            topBar = {
                     MainTopBar(
                         title = title,
                         backButtonVisible = backButtonVisible,
                         onBackButtonClicked = onBackButtonClicked,
                         action = action
                     )
            },
            content = content
        )
    }
}