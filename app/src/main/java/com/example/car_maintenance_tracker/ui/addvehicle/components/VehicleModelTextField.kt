package com.example.car_maintenance_tracker.ui.addvehicle.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.car_maintenance_tracker.R

@Composable
fun VehicleModelTextField() {
    var rememberInput by remember { mutableStateOf("") }
    val labelText = stringResource(R.string.vehicle_model_label)

    TextField(
        value = rememberInput,
        onValueChange = { rememberInput = onValueChange(it) },
        label = { Text(text = labelText) },
        singleLine = true
    )
}

private fun onValueChange(input: String): String {
    val maxLength = 20
    return if (input.length <= maxLength) {
        input
    } else {
        input.take(maxLength)
    }
}