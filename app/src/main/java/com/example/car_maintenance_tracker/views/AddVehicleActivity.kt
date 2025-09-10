package com.example.car_maintenance_tracker.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.car_maintenance_tracker.R
import com.example.car_maintenance_tracker.ui.theme.CarMaintenanceTrackerTheme

class AddVehicleActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarMaintenanceTrackerTheme {
                val scaffoldModifier = Modifier.fillMaxSize()
                Scaffold(modifier = scaffoldModifier) { innerPadding ->
                    AddVehicleScreen(innerPadding, getAddVehicleScreenOnClicks())
                }
            }
        }
    }

    private fun getAddVehicleScreenOnClicks(): AddVehicleScreenOnClicks {
        return AddVehicleScreenOnClicks(
            onClickAddVehicle = { this.onClickAddVehicle() }
        )
    }

    private fun onClickAddVehicle() {
        Toast.makeText(this, "Add Vehicle", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun AddVehicleScreen(
    innerPadding: PaddingValues,
    addVehicleScreenOnClicks: AddVehicleScreenOnClicks
) {
    val modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        VehicleMakeInput()
        AddVehicleButton(addVehicleScreenOnClicks.onClickAddVehicle)
    }
}

@Composable
fun AddVehicleButton(
    onClickAddVehicle: () -> Unit
) {
    Button(onClickAddVehicle) {
        Text("Add Vehicle")
    }
}

@Composable
fun VehicleMakeInput() {
    var rememberInput by remember { mutableStateOf("") }
    val labelText = stringResource(R.string.vehicle_make_label)

    fun onValueChange(input: String) {
        if (input.length <= 15) {
            rememberInput = input
        }
    }

    TextField(
        value = rememberInput,
        onValueChange = ::onValueChange,
        label = { Text(text = labelText) },
        singleLine = true
        )
}

data class AddVehicleScreenOnClicks(val onClickAddVehicle: () -> Unit)
