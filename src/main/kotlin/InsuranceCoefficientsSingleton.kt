package ru.herobrine1st.practice

class InsuranceCoefficientsSingleton private constructor() {
    companion object {
        @JvmStatic
        val INSTANCE by lazy { InsuranceCoefficientsSingleton() }
    }

    /**
     * Coefficient for days since last incident due to customer's fault
     */
    val carPastIncidentsCoefficient = 0.5f

    val carMinimumMonthlyPaymentPerHorsePower = 1000

    /**
     * Coefficient for days since last incident due to customer's fault
     */
    val immovablePastIncidentsCoefficient = 2f

    val immovableMinimumMonthlyPaymentPerSquareMeter = 1000
}

