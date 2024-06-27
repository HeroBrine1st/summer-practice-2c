package ru.herobrine1st.practice.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.herobrine1st.practice.ImmovableInsuranceCalculator

@Composable
fun ImmovableInsuranceScreen() {
    var daysSinceLastIncident by remember { mutableStateOf("") }
    var surface by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(-1f) }


    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Column(
            Modifier.width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier) // empty spacer for 4 dp on top

            val isErrorDays = daysSinceLastIncident.isNotBlank() && daysSinceLastIncident.toIntOrNull()
                ?.takeIf { it >= 0 } == null
            OutlinedTextField(
                value = daysSinceLastIncident,
                onValueChange = { daysSinceLastIncident = it },
                supportingText = { Text("Дней с последнего инцидента по вине клиента (оставить пустым при отсутствии инцидентов)") },
                isError = isErrorDays,
                placeholder = { Text("Целое число") },
                trailingIcon = { if (isErrorDays) Icon(Icons.Default.Error, null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            val isErrorSurface = surface.isBlank() || surface.toFloatOrNull()?.takeIf { it >= 0 } == null
            OutlinedTextField(
                value = surface,
                onValueChange = { surface = it },
                supportingText = { Text("Площадь недвижимости") },
                isError = isErrorSurface,
                placeholder = { Text("Число с плавающей запятой") },
                trailingIcon = { if (isErrorSurface) Icon(Icons.Default.Error, null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Button(
                onClick = {
                    result = ImmovableInsuranceCalculator().calculate(
                        daysSinceLastIncident = daysSinceLastIncident.toIntOrNull()?.takeIf { it >= 0 } ?: -1,
                        surfaceSquareMeters = surface.toFloatOrNull()?.takeIf { it >= 0 } ?: return@Button
                    )
                },
                enabled = !(isErrorSurface || isErrorDays)
            ) {
                Text("Рассчитать")
            }

            if (result >= 0) {
                Text("Результат: $result рублей в месяц")
            }

            Spacer(Modifier) // empty spacer for 4 dp on bottom
        }
    }
}


