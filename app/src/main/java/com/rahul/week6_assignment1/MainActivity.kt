package com.rahul.week6_assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    private lateinit var etusername: TextInputEditText
    private lateinit var etpassword: TextInputEditText
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener{
            val userName = etusername.text.toString()
            val password = etpassword.text.toString()

            if(userName == "softwarica" && password == "coventry") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show()
                etusername.error = "Username or password is incorrect"
                etusername.requestFocus()
            }
        }
    }

    private fun validate(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etusername.text) -> {
                etusername.error = "Username or password is incorrect"
                etusername.requestFocus()
                flag = false
            }
        }
        return flag
    }
}


