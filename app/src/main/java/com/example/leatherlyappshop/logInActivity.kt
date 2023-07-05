package com.example.leatherlyappshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class logInActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login : Button
    lateinit var forgotpassword : TextView
    lateinit var signup : TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        email = findViewById(R.id.emailhint)
        password = findViewById(R.id.passhint)
        forgotpassword = findViewById(R.id.forgotpass)
        login=findViewById(R.id.signinbtn)
        signup=findViewById(R.id.textView5)
        auth = Firebase.auth

        login.setOnClickListener {
            login()
        }
        signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        forgotpassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun login(){
        val email = email.text.toString()
        val pass = password.text.toString()

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Successfully logged In", Toast.LENGTH_LONG).show()
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "Log In failed", Toast.LENGTH_LONG).show()
        }
    }
}