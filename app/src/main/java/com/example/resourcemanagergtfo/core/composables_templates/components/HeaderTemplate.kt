package com.example.resourcemanagergtfo.core.composables_templates.components

import androidx.compose.foundation.layout.Box
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
    contentAlignment: Alignment = Alignment.Center
    ){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = contentAlignment
    ){
        Text(text = annotatedString)
    }
}