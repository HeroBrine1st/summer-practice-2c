package ru.herobrine1st.practice

// Should it be exactly `class`?
class CarBasicInsuranceCalculator {
    fun calculate(daysSinceLastIncident: Int, horsePower: Float): Float {
        val unconditionalPart =
            InsuranceCoefficientsSingleton.INSTANCE.carMinimumMonthlyPaymentPerHorsePower * horsePower
        val conditionalPart =
            if (daysSinceLastIncident >= 0) 1f / daysSinceLastIncident * InsuranceCoefficientsSingleton.INSTANCE.carPastIncidentsCoefficient
            else 0f
        return unconditionalPart + conditionalPart.coerceAtMost(2f) * unconditionalPart
    }
}


