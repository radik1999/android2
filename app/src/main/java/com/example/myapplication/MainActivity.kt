package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var focuse_timer: MyTimer
    private lateinit var alive_timer: MyTimer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        Timber.i("onCreate Called")
        focuse_timer = MyTimer("resume")
        alive_timer = MyTimer("create")
        alive_timer.startTimer()



    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }


    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
        focuse_timer.startTimer()
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
        focuse_timer.stopTimer()
    }


    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
        alive_timer.stopTimer()
        Timber.i("(X/Y*100)% = ${(focuse_timer.getSeconds().toFloat() / alive_timer.getSeconds().toFloat()) * 100}%")

    }
}
