package com.alorma.compose.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alorma.compose.settings.internal.SettingsTileAction
import com.alorma.compose.settings.internal.SettingsTileIcon
import com.alorma.compose.settings.internal.SettingsTileTexts

@Composable
fun SettingsCheckbox(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    title: @Composable () -> Unit,
    subtitle: @Composable (() -> Unit)? = null,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Surface {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(onClick = { onCheckedChange(!checked) }),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SettingsTileIcon(icon = icon)
            SettingsTileTexts(title = title, subtitle = subtitle)
            SettingsTileAction {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { onCheckedChange(!checked) }
                )
            }
        }
    }
}
