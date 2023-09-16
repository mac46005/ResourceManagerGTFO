package com.example.resourcemanagergtfo.core.composables.composables_gtfo.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import com.example.resourcemanagergtfo.core.composables.composables_templates.components.HeaderTemplate
import com.example.resourcemanagergtfo.ui.theme.ResourceManagerGTFOTheme

@Composable
fun MainTopBar(
    title: String,
    action: @Composable (BoxScope.() -> Unit)
){
    val mainTitleSize = 50.sp
    val titleSize = 30.sp
    ResourceManagerGTFOTheme() {
        Column {
            HeaderTemplate(annotatedString = buildAnnotatedString{
                pushStyle(
                    SpanStyle(
                        color = Color.Yellow,
                        fontSize = mainTitleSize
                    )
                )
                append("GTFO")
                pop()
                pushStyle(
                    SpanStyle(
                        fontSize = mainTitleSize
                    )
                )
                append("Resource Manager")

            })
            HeaderTemplate(
                contentAlignment = Alignment.CenterStart,
                annotatedString = buildAnnotatedString {
                    pushStyle(
                        SpanStyle(
                        fontSize = titleSize
                        )
                    )

                    append(title)
                    pop()
                },
                action = action
            )
        }
    }

}