package com.example.car_maintenance_tracker.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.car_maintenance_tracker.ui.addvehicle.AddVehicleActivity
import com.example.car_maintenance_tracker.ui.theme.CarMaintenanceTrackerTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarMaintenanceTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationScreen(innerPadding, getNavigationScreenOnClicks())
                }
            }
        }
    }

    private fun getNavigationScreenOnClicks(): NavigationScreenOnClicks {
        return NavigationScreenOnClicks(
            onClickViewVehicles = { onClickButtonToast("Clicked View Vehicles") },
            onClickLogItem = { onClickButtonToast("Clicked Log Item") },
            onClickCreateNewVehicle = { launchCreateNewVehicleActivity() }
        )
    }

    private fun launchCreateNewVehicleActivity() {
        val intent = Intent(this, AddVehicleActivity::class.java)
        startActivity(intent)
    }

    private fun onClickButtonToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

data class NavigationScreenOnClicks(
    val onClickCreateNewVehicle: () -> Unit,
    val onClickViewVehicles: () -> Unit,
    val onClickLogItem: () -> Unit
)

@Composable
private fun NavigationScreen(
    innerPadding: PaddingValues,
    navigationScreenOnClicks: NavigationScreenOnClicks
) {
    val modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 16.dp)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavigationOptions(navigationScreenOnClicks)
    }
}

@Composable
fun NavigationOptions(onClicks: NavigationScreenOnClicks) {
    onClicks.apply {
        NavigationButton("Create New Vehicle", onClickCreateNewVehicle)
        NavigationButton("View Vehicles", onClickViewVehicles)
        NavigationButton("Log Item", onClickLogItem)
    }
}

@Composable
fun NavigationButton(
    buttonText: String = "button",
    onClickButton: () -> Unit
) {
    Button(onClick = onClickButton) {
        Text(text = buttonText)
    }
}