package com.alorma.compose.settings

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alorma.compose.settings.internal.SettingsTileIcon

@Preview
@Composable
internal fun SettingsGroupPreview() {
    MaterialTheme {
        SettingsGroup(
            title = { Text(text = "Title") }
        ) {
            Box(
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Settings group")
            }
        }
    }
}

@Preview
@Composable
internal fun SettingsCheckboxPreview() {
    MaterialTheme {
        var state by remember { mutableStateOf(true) }
        SettingsCheckbox(
            icon = { Icon(imageVector = Icons.Default.Wifi, contentDescription = "Wifi") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            checked = state,
            onCheckedChange = { state = it }
        )
    }
}

@Preview
@Composable
internal fun SettingsMenuLinkPreview() {
    MaterialTheme {
        SettingsMenuLink(
            icon = { Icon(imageVector = Icons.Default.Wifi, contentDescription = "Wifi") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
        ) {

        }
    }
}

@Preview
@Composable
internal fun SettingsMenuLinkActionPreview() {
    var rememberCheckBoxState by remember { mutableStateOf(true) }
    MaterialTheme {
        SettingsMenuLink(
            icon = { Icon(imageVector = Icons.Default.Wifi, contentDescription = "Wifi") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            action = {
                Checkbox(checked = rememberCheckBoxState, onCheckedChange = { newState ->
                    rememberCheckBoxState = newState
                })
            },
        ) {

        }
    }
}

@Preview
@Composable
internal fun SettingsSwitchPreview() {
    MaterialTheme {
        var state by remember { mutableStateOf(true) }
        SettingsSwitch(
            icon = { Icon(imageVector = Icons.Default.Wifi, contentDescription = "Wifi") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            checked = state,
            onCheckedChange = { state = it }
        )
    }
}

@Preview
@Composable
fun SettingsIconPreview() {
    MaterialTheme {
        SettingsTileIcon {
            Icon(imageVector = Icons.Default.Wifi, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun SettingsIconPreviewEmpty() {
    MaterialTheme {
        SettingsTileIcon()
    }
}
