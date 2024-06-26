package ru.herobrine1st.practice

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.herobrine1st.practice.ui.MainScreen

/**
 * Пусть класс-синглтон предоставляет 2 коэффициента для расчета страховой премии за конкретный вид страхования: автомобиль и недвижимость.
 * Вместе с ним есть 3 класса-калькулятора: ОСАГО, КАСКО и страхование квартиры. Классы-калькуляторы определяют формулу расчета, используя коэффициенты из класса-синглтона.
 * Формулы придумать самостоятельно.
 */

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MainScreen()
    }
}