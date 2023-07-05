package com.example.leatherlyappshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    lateinit var email : EditText
    lateinit var mypassword: EditText
    lateinit var myconfigpassword: EditText
    lateinit var signupbtn : Button
    lateinit var signintxt : TextView
    private lateinit var auth: FirebaseAuth //Creating firebase authentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        email = findViewById(R.id.emailhint2)
        mypassword = findViewById(R.id.TextPassword)
        myconfigpassword = findViewById(R.id.passconfirm)
        signupbtn=findViewById(R.id.signupbutton)
        signintxt=findViewById(R.id.signintext)
        auth = Firebase.auth

        signupbtn.setOnClickListener {
            SignUpUser()
        }
        signintxt.setOnClickListener {
            val intent = Intent(this, logInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun SignUpUser(){
        val email = email.text.toString()
        val pass = mypassword.text.toString()
        val configpass = myconfigpassword.text.toString()
        if (email.isBlank() || pass.isBlank() || configpass.isBlank()){
            Toast.makeText(this, "Email and password can't be Blank", Toast.LENGTH_LONG).show()
            return
        }
        else if (pass !=configpass){
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
            return
        }

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Signed up successfuly", Toast.LENGTH_LONG).show()
                val intent = Intent(this, logInActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Failed to Create", Toast.LENGTH_LONG).show()
            }
        }
    }
}