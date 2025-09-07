package com.example.car_maintenance_tracker.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class AddVehicleActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldModifier = Modifier.fillMaxSize()
            Scaffold(modifier = scaffoldModifier) { innerPadding ->
                AddVehicleScreen(innerPadding, getAddVehicleScreenOnClicks())
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
    ) {
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

data class AddVehicleScreenOnClicks(val onClickAddVehicle: () -> Unit)
