package com.example.standard_task4

import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

inline fun <reified T : Any> newIntent(context: Context) : Intent = Intent(context, T::class.java)

inline fun <reified T : Any> Context.launchaActivity(
    vararg pairs: Pair<String, String>
){
    val intent = newIntent<T>(this)
//    intent.putExtra(bundleOf(*pairs))
    startActivity(intent)
}
