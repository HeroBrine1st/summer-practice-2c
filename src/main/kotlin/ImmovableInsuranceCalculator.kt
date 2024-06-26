package ru.herobrine1st.practice

class ImmovableInsuranceCalculator {
    fun calculate(daysSinceLastIncident: Int, surfaceSquareMeters: Float): Float {
        val unconditionalPart =
            InsuranceCoefficientsSingleton.INSTANCE.immovableMinimumMonthlyPaymentPerSquareMeter * surfaceSquareMeters
        val conditionalPart =
            if (daysSinceLastIncident >= 0) 1f / daysSinceLastIncident * InsuranceCoefficientsSingleton.INSTANCE.immovablePastIncidentsCoefficient
            else 0f
        return unconditionalPart + conditionalPart.coerceAtMost(2f) * unconditionalPart
    }
}