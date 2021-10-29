package com.gmail.landre.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gmail.landre.activities.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {

    private lateinit var binding: ComputeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.field1.addTextChangedListener(this)
        binding.field2.addTextChangedListener(this)
        binding.btnCalculer.setOnClickListener(this)
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding.btnCalculer.isEnabled = binding.field1.text.isNotBlank() && binding.field2.text.isNotBlank()
    }

    override fun onClick(v: View?) {
        val result: Number
        result = binding.field1.text.toString().toDouble() + binding.field2.text.toString().toDouble()
        binding.resultat.text = result.toString()
    }
}
