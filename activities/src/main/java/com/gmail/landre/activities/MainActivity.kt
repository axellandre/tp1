package com.gmail.landre.activities
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.landre.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var nbClick = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (nbClick == 0) {
            binding.textView.text = "vide"
        }
        binding.btnClickMe.setOnClickListener {
            nbClick++
            val newText = "Cliquez moi $nbClick"
            binding.btnClickMe.text = newText
            val message = "Vous avez cliquez $nbClick fois"
            binding.textView.text = message
            binding.btnClickMe.isEnabled = nbClick <= 4
        }
        binding.btnCompute.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }
}
