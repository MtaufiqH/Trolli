package com.taufiq.core.utils

import com.taufiq.core.utils.customview.ProgressButton
import com.taufiq.core.utils.customview.Type


fun ProgressButton.disable() {
    selectedState(Type.DISABLED.value)
}
fun ProgressButton.enabled() {
    selectedState(Type.ENABLED.value)
}
fun ProgressButton.loading() {
    selectedState(Type.LOADING.value)
}