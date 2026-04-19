package com.example.financeapp333

class FinanceManager {
    private val lastName = "Shelia"
    private val birthMonth = 8

    val savingsPercent: Int = lastName.length + birthMonth

    fun calculateExpenses(model: FinanceModel): Double {
        return model.rent + model.food
    }

    fun calculateSavings(model: FinanceModel): Double {
        val expenses = calculateExpenses(model)
        return (model.salary - expenses) * (savingsPercent / 100.0)
    }

    fun isDeficit(model: FinanceModel): Boolean {
        return calculateExpenses(model) > model.salary
    }
}
