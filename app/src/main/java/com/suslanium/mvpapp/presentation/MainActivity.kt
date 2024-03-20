package com.suslanium.mvpapp.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suslanium.mvpapp.R
import com.suslanium.mvpapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PhoneScreen {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: PhonePresenter

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

        presenter = PhonePresenter(phoneScreen = this)
        binding.submitButton.setOnClickListener {
            presenter.formatPhone(binding.phoneEditText.text.toString())
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPhoneText(phone: String) {
        binding.phoneText.text = phone
    }

    override fun showPhoneFormatError() {
        binding.phoneText.text = resources.getString(R.string.invalid_format)
    }

}