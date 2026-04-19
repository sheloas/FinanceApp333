package com.example.financeapp333

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val editSalary = view.findViewById<EditText>(R.id.ss_edit_salary)
        val editRent = view.findViewById<EditText>(R.id.ss_edit_rent)
        val editFood = view.findViewById<EditText>(R.id.ss_edit_food)
        val btnCalculate = view.findViewById<Button>(R.id.ss_btn_calculate)

        btnCalculate.setOnClickListener {
            val salaryStr = editSalary.text.toString()
            val rentStr = editRent.text.toString()
            val foodStr = editFood.text.toString()

            if (salaryStr.isNotEmpty() && rentStr.isNotEmpty() && foodStr.isNotEmpty()) {
                val model = FinanceModel(
                    salary = salaryStr.toDouble(),
                    rent = rentStr.toDouble(),
                    food = foodStr.toDouble()
                )

                val fragmentB = FragmentB.newInstance(model)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.ss_fragment_container, fragmentB)
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
