package com.example.car_maintenance_tracker.ui.addvehicle.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.car_maintenance_tracker.R

@Composable
fun AddVehicleButton(
    onClickAddVehicle: () -> Unit
) {
    Button(onClickAddVehicle) {
        val buttonText = stringResource(R.string.add_vehicle_button_text)
        Text(text = buttonText)
    }
}