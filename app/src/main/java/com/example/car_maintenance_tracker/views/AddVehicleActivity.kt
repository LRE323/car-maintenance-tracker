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
                    AddVehicleScreen(innerPadding, getComposableLogic())
                }
            }
        }
    }

    private fun getAddVehicleScreenOnClicks(): AddVehicleScreenOnClicks {
        return AddVehicleScreenOnClicks(
            onClickAddVehicle = { this.onClickAddVehicle() }
        )
    }

    private fun getOnValueChangeLogic(): OnValueChangeLogic {
        return OnValueChangeLogic(
            onVehicleMakeValueChange = ::onVehicleMakeValueChange
        )
    }

    private fun getComposableLogic(): ComposableLogic {
        return ComposableLogic(
            onClicks = getAddVehicleScreenOnClicks(),
            onValueChangeLogic = getOnValueChangeLogic()
        )
    }

    private fun onClickAddVehicle() {
        Toast.makeText(this, "Add Vehicle", Toast.LENGTH_SHORT).show()
    }

    private fun onVehicleMakeValueChange(input: String): String {
        val maxLength = 20
        return if (input.length <= maxLength) {
            input
        } else {
            input.take(maxLength)
        }
    }
}

@Composable
fun AddVehicleScreen(
    innerPadding: PaddingValues,
    composableLogic: ComposableLogic
) {
    val modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        VehicleMakeInput(composableLogic.onValueChangeLogic.onVehicleMakeValueChange)
        AddVehicleButton(composableLogic.onClicks.onClickAddVehicle)
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
fun VehicleMakeInput(onVehicleMakeValueChange: (String) -> String) {
    var rememberInput by remember { mutableStateOf("") }
    val labelText = stringResource(R.string.vehicle_make_label)

    TextField(
        value = rememberInput,
        onValueChange = { rememberInput = onVehicleMakeValueChange(it) } ,
        label = { Text(text = labelText) },
        singleLine = true
        )
}

data class ComposableLogic(
    val onClicks: AddVehicleScreenOnClicks,
    val onValueChangeLogic: OnValueChangeLogic
)

data class AddVehicleScreenOnClicks(val onClickAddVehicle: () -> Unit)

data class OnValueChangeLogic(val onVehicleMakeValueChange: (String) -> String)
