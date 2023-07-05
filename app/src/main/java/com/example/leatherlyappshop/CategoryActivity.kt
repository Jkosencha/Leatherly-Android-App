package com.example.leatherlyappshop

import android.app.Dialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.example.leatherlyappshop.databinding.CategoryHomeBinding
import com.example.leatherlyappshop.ui.help.HelpFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File

class CategoryActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: CategoryHomeBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_home)

        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Category"
        setSupportActionBar(toolbar)

        if (uid.isNotEmpty()) {
            getUserData()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment_content_home)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_contact,
                R.id.nav_category,
                R.id.nav_about,
                R.id.nav_logout,
                R.id.nav_help,
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val headerView = navView.getHeaderView(0)
        val userNameTextView: TextView = headerView.findViewById(R.id.tvFullName)
        val profileImageView: CircleImageView = headerView.findViewById(R.id.profilePic)
    }


    private fun getUserData() {
        databaseReference.child(uid).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    user = snapshot.getValue(User::class.java)!!
                    getUserProfile()
                } else {
                    // Handle the case when the snapshot does not exist or user data is not found
                    Toast.makeText(this@CategoryActivity, "User data not found", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@CategoryActivity,
                    "Failed to getUserProfile Data",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    private fun getUserProfile() {
        storageReference = FirebaseStorage.getInstance().reference.child("Users/$uid.jpg")
        val localFile = File.createTempFile("TempImage", "jpg")
        storageReference.getFile(localFile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
        }.addOnFailureListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.queryHint = "Type here to search"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Handle text submission
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Handle text change
                return false
            }
        })

        // Further configuration or handling of the search menu item if needed
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}