package ru.herobrine1st.practice

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun MainScreen() {
    Column {
        Button(onClick = { println("test") }) {
            Text("Test")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MainScreen()
    }
}