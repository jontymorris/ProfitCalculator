package me.morris.grossprofitcalculator

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

class AppUtils (activity: Activity) {

    private var activity: Activity? = null

    init {
        this.activity = activity
    }

    fun setTextValue(id: Int, value: String) {
        var view: TextView = activity!!.findViewById(id)
        view.text = value
    }

    fun roundValue(value: Double): String {
        return "%.2f".format(value)
    }

    fun getDouble(id: Int): Double {
        val view: EditText = activity!!.findViewById(id)
        return view.text.toString().toDouble()
    }

    fun clearEdit(id: Int) {
        var view: EditText = activity!!.findViewById(id)
        view.setText("")
    }

    fun showView(id: Int) {
        var view: View = activity!!.findViewById(id)
        view.visibility = View.VISIBLE
    }

    fun hideKeyboard(view: View) {
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

}