 package com.example.simple_conversion_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simple_conversion_calculator.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue=150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250

        binding.weightPicker.setOnValueChangedListener{ _, _, _,->
            calculateBMI()
        }
        binding.heightPicker.setOnValueChangedListener{ _, _, _,->
            calculateBMI()
        }

    }

     private fun  calculateBMI()
     {
         val height = binding.heightPicker.value
         val doubleHeight = height.toDouble()/100

         val weight = binding.weightPicker.value

         val bmi = weight.toDouble()/ (doubleHeight * doubleHeight)

         binding.resultTextView.text = String.format("Your BMI is: %.2f", bmi)
         binding.limitsTextView.text = String.format("Considered: %s", healthyMessage(bmi))
     }

     private  fun healthyMessage(bmi :Double) :String{
         if (bmi <18.5){
             return "Underweight"
         }
         if (bmi< 25.8){
             return "Healthy"
         }

         if(bmi >30.0){
             return "Overweight"
         }
         return "Obese"

     }
    }


