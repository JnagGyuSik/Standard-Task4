package com.example.standard_task4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_task4.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        var dataList = mutableListOf<Data>()
        dataList.add(Data(R.color.blue, "2423 3581 9503 2412", "21 / 24", 3100.30))
        dataList.add(Data(R.color.skyBlue, "2423 3581 9503 2412", "12 / 25", 3100.30))
        dataList.add(Data(R.color.orenge, "2423 3581 9503 2412", "21 / 24", 3100.30))

        val adapter =Adapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        var availableBalance = binding.availableBalance
        var dec = DecimalFormat("#,##,###.00") //숫자 포맷 변경
        var availableBalanceText = 285856.20
        availableBalance.text = "$" + dec.format(availableBalanceText)

        //리스트 클릭시 실행
        adapter.itemClick = object : Adapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("cardNumber",dataList[position].cardNumber)
                    putExtra("cardDate",dataList[position].cardDate)
                    putExtra("cardBalance",dataList[position].cardBalance)
                    Log.d("확인","${dataList[position].cardBalance}")
                }
                startActivity(intent)
            }
        }
    }
}