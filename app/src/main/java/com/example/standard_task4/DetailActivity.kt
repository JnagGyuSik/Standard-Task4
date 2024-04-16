package com.example.standard_task4

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard_task4.databinding.ActivityDetailBinding
import com.example.standard_task4.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private val binding:ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val cardNumberText = binding.textView
        val cardDateText = binding.textView2
        val cardBalanceText = binding.textView3

        val cardNumber = intent.getStringExtra("cardNumber")
        val cardDate = intent.getStringExtra("cardDate")
        val cardBalance = intent.getDoubleExtra("cardBalance", 0.0)
        Log.d("확인","${cardBalance}")


        cardNumberText.setText("카드번호 : $cardNumber")
        cardDateText.setText("유효기간 : $cardDate")
        cardBalanceText.setText(cardBalance.toString())
    }
}

