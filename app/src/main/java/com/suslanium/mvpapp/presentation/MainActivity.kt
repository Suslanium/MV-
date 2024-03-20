package com.suslanium.mvpapp.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.suslanium.mvpapp.R
import com.suslanium.mvpapp.databinding.ActivityMainBinding
import com.suslanium.mvpapp.domain.entity.FormatResult

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: PhoneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[PhoneViewModel::class.java]

        viewModel.formatResult.observe(this) { formatResult ->
            binding.phoneText.text = when(formatResult) {
                FormatResult.Error -> resources.getString(R.string.invalid_format)
                is FormatResult.Phone -> formatResult.phone
            }
        }

        binding.submitButton.setOnClickListener {
            viewModel.formatPhone(binding.phoneEditText.text.toString())
        }
    }

}