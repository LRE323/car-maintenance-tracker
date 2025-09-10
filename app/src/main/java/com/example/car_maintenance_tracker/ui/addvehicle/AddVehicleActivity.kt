package com.example.car_maintenance_tracker.ui.addvehicle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.car_maintenance_tracker.ui.addvehicle.components.AddVehicleButton
import com.example.car_maintenance_tracker.ui.addvehicle.components.VehicleMakeTextField
import com.example.car_maintenance_tracker.ui.addvehicle.components.VehicleModelTextField
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
    onClicks: AddVehicleScreenOnClicks
) {
    val modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        VehicleMakeTextField()
        VehicleModelTextField()
        AddVehicleButton(onClicks.onClickAddVehicle)
    }
}

data class AddVehicleScreenOnClicks(val onClickAddVehicle: () -> Unit)
