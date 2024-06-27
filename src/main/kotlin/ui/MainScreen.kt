package ru.herobrine1st.practice.ui

import androidx.compose.animation.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MinorCrash
import androidx.compose.material.icons.filled.RealEstateAgent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf(Screen.ImmovableInsurance) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                Screen.entries.forEach {
                    NavigationBarItem(
                        selected = it == currentScreen,
                        onClick = { currentScreen = it },
                        label = { Text(it.screenName) },
                        icon = { Icon(it.icon, null) }
                    )
                }
            }
        }
    ) { paddingValues ->
        Crossfade(currentScreen, modifier = Modifier.padding(paddingValues)) { currentScreen ->
            when (currentScreen) {
                Screen.ImmovableInsurance -> ImmovableInsuranceScreen()
                Screen.CarInsurance -> CarInsuranceScreen()
            }
        }
    }

}

enum class Screen(val screenName: String, val icon: ImageVector) {
    // i18n ignored on purpose
    ImmovableInsurance("Недвижимость", Icons.Default.RealEstateAgent),
    CarInsurance("Автомобиль", Icons.Default.MinorCrash)
}