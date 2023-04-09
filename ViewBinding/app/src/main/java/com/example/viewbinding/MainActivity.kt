package com.example.viewbinding

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val key = "viewbinding.name"
    }
    lateinit var binding :ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnsignup.setOnClickListener {
            if (binding.checkBox.isChecked){

                val name = binding.eTname.text.toString()

                // intent
                val intent = Intent(this, Second::class.java)
                intent.putExtra(key, name)
                startActivity(intent)
            }
            else{
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Agree first!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.checkBox.setOnClickListener{
            binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.GREEN)
            }
    }
}