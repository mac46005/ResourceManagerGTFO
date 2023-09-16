package com.example.resourcemanagergtfo.core.composables.composables_templates.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun<T> ListDisplay(
    modifier: Modifier = Modifier,
    list: List<T>,
    itemView: @Composable ((T) -> Unit)
){
    LazyColumn(modifier = modifier){
        items(list){item ->
            itemView(item)
        }
    }
}