package com.example.leatherlyappshop

import android.app.Dialog
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.leatherlyappshop.databinding.ActivityAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri: Uri
    private lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        binding.saveBtn.setOnClickListener {
            showProgressBar()

            val firstname = binding.etFirstName.text.toString()
            val lastname = binding.etLastName.text.toString()
            val bio = binding.etBio.text.toString()

            val user = User(firstname, lastname, bio)
            if (uid != null) {
                databaseReference.child(uid).setValue(user).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        uploadProfilePic()
                    } else {
                        hideProgressBar()
                        Toast.makeText(this, "Failed to upload profile", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun uploadProfilePic() {
        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.profilepicture}")
        storageReference =
            FirebaseStorage.getInstance().getReference("Users/${auth.currentUser?.uid} .jpg")
        storageReference.putFile(imageUri).addOnSuccessListener {
            hideProgressBar()
            Toast.makeText(this, "Profile Successfully updated", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            hideProgressBar()
            Toast.makeText(this, "Failed to upload profile pic", Toast.LENGTH_LONG).show()
        }
    }

    private fun showProgressBar() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog)
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun hideProgressBar() {
        dialog.dismiss()
    }
}
