package com.example.financeapp333

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    companion object {
        private const val ARG_MODEL = "arg_model"

        fun newInstance(model: FinanceModel): FragmentB {
            val fragment = FragmentB()
            val args = Bundle()
            args.putSerializable(ARG_MODEL, model)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        val txtName = view.findViewById<TextView>(R.id.ss_txt_name)
        val txtYear = view.findViewById<TextView>(R.id.ss_txt_year)
        val txtResult = view.findViewById<TextView>(R.id.ss_txt_result)


        txtName.text = "Saba Shelia"
        txtYear.text = "2003"

        val model = arguments?.getSerializable(ARG_MODEL) as? FinanceModel
        if (model != null) {
            val manager = FinanceManager()
            val savings = manager.calculateSavings(model)
            val deficit = manager.isDeficit(model)

            txtResult.text = "Total Savings: $${String.format("%.2f", savings)}"

            if (deficit) {
                txtResult.setTextColor(Color.RED)
            } else {
                txtResult.setTextColor(Color.GREEN)
            }
        }

        return view
    }
}
