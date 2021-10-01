package com.alorma.settings.storage.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.alorma.settings.storage.SettingValueState

@Composable
fun rememberPreferenceFloatSettingState(key: String, defaultValue: Float = 0f): FloatPreferenceSettingValueState {
  val context = LocalContext.current
  return remember {
    FloatPreferenceSettingValueState(
      context = context,
      key = key,
      defaultValue = defaultValue
    )
  }
}

class FloatPreferenceSettingValueState(
  context: Context,
  private val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context),
  val key: String,
  val defaultValue: Float = 0f,
) : SettingValueState<Float> {

  private var _value by mutableStateOf(preferences.getFloat(key, defaultValue))

  override var value: Float
    set(value) {
      _value = value
      preferences.edit { putFloat(key, value) }
    }
    get() = _value
}
