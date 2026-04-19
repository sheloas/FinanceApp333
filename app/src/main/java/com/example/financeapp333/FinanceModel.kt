package com.example.financeapp333

import java.io.Serializable

data class FinanceModel(
    val salary: Double,
    val rent: Double,
    val food: Double
) : Serializable
