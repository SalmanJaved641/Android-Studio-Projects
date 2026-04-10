package com.example.kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//        val txt=findViewById<TextView>(R.id.txt)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener{
            hideKeyboard()
            if (binding.edtno1.text.toString()!="" && binding.edtno2.text.toString()!=""){
                val no1=binding.edtno1.text.toString().toInt()
                val no2=binding.edtno2.text.toString().toInt()
                val sum=no1+no2
                binding.sum.text=sum.toString()
                Toast.makeText(this,"The sum is $sum",Toast.LENGTH_SHORT).show()
            }

        }
        binding.edtno2.setOnEditorActionListener { _, actionId, event ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_DONE ||
                event?.keyCode == android.view.KeyEvent.KEYCODE_ENTER
            ) {
                binding.btnAdd.performClick() // 👈 Simulate Add button click
                true
            } else {
                false
            }
        }
    }
    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}