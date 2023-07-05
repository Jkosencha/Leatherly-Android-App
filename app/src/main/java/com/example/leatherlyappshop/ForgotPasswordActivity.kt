package com.example.leatherlyappshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var submit : Button
    lateinit var etForgotEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        submit = findViewById(R.id.buttonReset)
        etForgotEmail = findViewById(R.id.resetTextEmail)

        submit.setOnClickListener {
            val email: String = etForgotEmail.text.toString().trim { it <= ' '}
            if (email.isEmpty()){
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_LONG).show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Email sent successfully to reset your password!", Toast.LENGTH_LONG).show()
                            finish()
                        }else{
                            Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
            }
            val intent = Intent(this, logInActivity ::class.java)
            startActivity(intent)
            finish()
        }

    }
}