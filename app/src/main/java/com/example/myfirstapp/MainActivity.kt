package com.example.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
// TODO: Create the logic to verify user login details, EMAIL should be valid, Password must have 8 length including small/capital letters with digit and special characters
        val email = findViewById<EditText>(R.id.etUserEmail)
        val password = findViewById<EditText>(R.id.etUserPassword)
        var output = findViewById<TextView>(R.id.tvOutput)

        // Function that verifies if the email is valid
        fun verifyEmail(email: String): Boolean {
//            when {
//                email.endsWith("@gmail.com") -> true
//                email.endsWith("@yahoo.com") -> true
//                email.endsWith("@hotmail.com") -> true
//                email.endsWith("@aol.com") -> true
//                email.endsWith("@outlook.com") -> true
//            }
            if (email.endsWith("@gmail.com")) {
                return true
            }
            else if (email.endsWith("@yahoo.com")) {
                return true
            }
            else if (email.endsWith("@hotmail.com")) {
                return true
            }
            else if (email.endsWith("@aol.com")) {
                return true
            }
            else if (email.endsWith("@outlook.com")) {
                return true
            }
            return false
        }

        // Function that verifies if the password is valid
        fun verifyPassword(password: String): Boolean {
            var lowerCase: Boolean = false
            var upperCase: Boolean = false
            var specialChar: Boolean = false
            if (password.length != 8) {
                return false
            }
            else {
                for (i in password) {
                    if (i.isLowerCase()) {
                        lowerCase = true
                    }
                    if (i.isUpperCase()) {
                        upperCase = true
                    }
                    if (!i.isDigit() && !i.isLetter()) {
                        specialChar = true
                    }
                }
            }
            if(lowerCase && upperCase && specialChar) {
                return true
            }
            return false
        }

        // Button Click
        findViewById<Button>(R.id.btnSubmitButton).setOnClickListener {
            val submittedEmail = email.text.toString()
            val submittedPassword = password.text.toString()

            if (verifyEmail(submittedEmail) && verifyPassword(submittedPassword)) {
                output.setText("You Logged In!")
            }

        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}