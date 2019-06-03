package me.morris.grossprofitcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SalesActivity : AppCompatActivity() {

    private var utils: AppUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        utils = AppUtils(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun calculate(view: View) {
        var price = utils!!.getDouble(R.id.priceEdit)
        var sale = utils!!.getDouble(R.id.saleEdit)
        var saved = price

        utils!!.clearEdit(R.id.priceEdit)
        utils!!.clearEdit(R.id.saleEdit)

        price *= 1 - (sale/100)
        saved -= price

        utils!!.setTextValue(R.id.savedText, "$" + utils!!.roundValue(saved))
        utils!!.setTextValue(R.id.saleText, utils!!.roundValue(sale) + "%")
        utils!!.setTextValue(R.id.priceText, "$" + utils!!.roundValue(price))

        utils!!.showView(R.id.infoLayout)
        utils!!.hideKeyboard(view)
    }

}
