package ru.herobrine1st.practice.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.herobrine1st.practice.CarBasicInsuranceCalculator
import ru.herobrine1st.practice.CarProInsuranceCalculator

@Composable
fun CarInsuranceScreen() {
    var daysSinceLastIncident by remember { mutableStateOf("") }
    var horsePower by remember { mutableStateOf("") }
    var type by remember { mutableStateOf(CarInsuranceType.BASIC) }
    var result by remember { mutableStateOf(-1f) }

    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Column(
            Modifier.width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier) // empty spacer for 4 dp on top

            CarInsuranceType.entries.forEach {
                Row(
                    Modifier.fillMaxWidth()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null, // remove indication
                            onClick = { type = it }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = type == it,
                        onClick = { type = it },
                    )
                    Text(it.legalName)
                }
            }

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

            val isErrorSurface = horsePower.isBlank() || horsePower.toFloatOrNull()?.takeIf { it >= 0 } == null
            OutlinedTextField(
                value = horsePower,
                onValueChange = { horsePower = it },
                supportingText = { Text("Лошадиные силы") },
                label = { Text("Мощность двигателя") },
                isError = isErrorSurface,
                placeholder = { Text("Число с плавающей запятой") },
                trailingIcon = { if (isErrorSurface) Icon(Icons.Default.Error, null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )



            Button(
                onClick = {
                    val daysSinceLastIncidentInt = daysSinceLastIncident.toIntOrNull()?.takeIf { it >= 0 } ?: -1
                    val horsePowerFloat = horsePower.toFloatOrNull()?.takeIf { it >= 0 } ?: return@Button

                    result = when(type) {
                        CarInsuranceType.BASIC -> CarBasicInsuranceCalculator().calculate(daysSinceLastIncidentInt, horsePowerFloat)
                        CarInsuranceType.PRO -> CarProInsuranceCalculator().calculate(daysSinceLastIncidentInt, horsePowerFloat)
                    }
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

enum class CarInsuranceType(val legalName: String) {
    BASIC("ОСАГО"),
    PRO("КАСКО")
}