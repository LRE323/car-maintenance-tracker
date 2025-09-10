package com.example.car_maintenance_tracker.ui.addvehicle.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.car_maintenance_tracker.R

private const val maxLength = 4

@Composable
fun VehicleYearTextField() {
    var rememberInput by remember { mutableStateOf("") }
    val labelText = stringResource(R.string.vehicle_year_label)

    TextField(
        value = rememberInput,
        onValueChange = { input->
            if (shouldPostNewValue(input)) {
                rememberInput = input
            }
        },
        label = { Text(text = labelText) },
        singleLine = true,
        keyboardOptions = keyboardOptions
    )
}

private fun shouldPostNewValue(input: String): Boolean {
    val inputAsInt = input.toIntOrNull()

    return if (input.isBlank()) {
        true
    } else if (inputAsInt != null) {
        return input.length <= maxLength
    } else {
        false
    }
}

private val keyboardOptions: KeyboardOptions get() {
    return KeyboardOptions(
        keyboardType = KeyboardType.Number
    )
}