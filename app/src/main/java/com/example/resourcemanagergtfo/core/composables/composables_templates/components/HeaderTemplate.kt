package com.example.resourcemanagergtfo.core.composables.composables_templates.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString

@Composable
fun HeaderTemplate(
    modifier: Modifier = Modifier,
    annotatedString: AnnotatedString,
    titleAlign: Alignment = Alignment.CenterStart,
    contentAlignment: Alignment = Alignment.Center,
    action: @Composable (BoxScope.() -> Unit) = {}
    ){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = contentAlignment
    ){
        Text(
            modifier = Modifier.align(titleAlign),
            text = annotatedString
        )
        action(this)
    }
}