package Default.calculator

import Default.calculator.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.*
import java.text.DecimalFormat

import android.util.Log


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonClear.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
        }
        binding.buttonBracketLeft.setOnClickListener {
            binding.input.text = addToInputText("(")
        }
        binding.buttonBracketRight.setOnClickListener {
            binding.input.text = addToInputText(")")
        }
        binding.button0.setOnClickListener {
            binding.input.text = addToInputText("0")
        }
        binding.button1.setOnClickListener {
            binding.input.text = addToInputText("1")
        }
        binding.button2.setOnClickListener {
            binding.input.text = addToInputText("2")
        }
        binding.button3.setOnClickListener {
            binding.input.text = addToInputText("3")
        }
        binding.button4.setOnClickListener {
            binding.input.text = addToInputText("4")
        }
        binding.button5.setOnClickListener {
            binding.input.text = addToInputText("5")
        }
        binding.button6.setOnClickListener {
            binding.input.text = addToInputText("6")
        }
        binding.button7.setOnClickListener {
            binding.input.text = addToInputText("7")
        }
        binding.button8.setOnClickListener {
            binding.input.text = addToInputText("8")
        }
        binding.button9.setOnClickListener {
            binding.input.text = addToInputText("9")
        }
        binding.button0.setOnClickListener {
            binding.input.text = addToInputText("0")
        }
        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInputText(".")
        }
        binding.buttonDivision.setOnClickListener {
            binding.input.text = addToInputText("÷")
        }
        binding.buttonMultiply.setOnClickListener {
            binding.input.text = addToInputText("×")
        }
        binding.buttonSubtraction.setOnClickListener {
            binding.input.text = addToInputText("-")
        }
        binding.buttonAddition.setOnClickListener {
            binding.input.text = addToInputText("+")
        }
        binding.buttonEquals.setOnClickListener {
            showResult()
        }

    }
    private fun addToInputText(buttonValue: String): String{
        return (binding.input.text.toString() + "$buttonValue")
    }
    private fun getInputExpression(): String{
        var expression = binding.input.text.replace(Regex("÷"), "/")
        expression = binding.input.text.replace(Regex("×"), "*")
        return expression
    }
    private fun showResult(){
        try{
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            Log.i("TAG", expression.toString())
            if (result.isNaN()){
                //show error message
                binding.output.text = "NaN"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else {
                //show result
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.dark_teal))
            }
        }catch(e: Exception){
            //show error message
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}