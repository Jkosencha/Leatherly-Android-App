package com.example.leatherlyappshop.ui.logout

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.leatherlyappshop.BagsActivity
import com.example.leatherlyappshop.R
import com.example.leatherlyappshop.databinding.FragmentLogoutBinding
import com.example.leatherlyappshop.logInActivity
import kotlinx.coroutines.NonCancellable

class LogoutFragment : Fragment() {

    private var _binding: FragmentLogoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val logoutViewModel =
            ViewModelProvider(this).get(LogoutViewModel::class.java)

        _binding = FragmentLogoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val logoutText = binding.textLogout
        logoutText.setOnClickListener {
            // Handle the button click event
            openLogoutDialog()
        }

        return root
    }

    private fun openLogoutDialog() {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setMessage("Do you want to close this application?")
        alertDialogBuilder.setPositiveButton("PROCEED") { dialog, which ->
            performLogout()
            // Perform logout action here
        }
        alertDialogBuilder.setNegativeButton("CANCEL") { dialog, which ->
            dialog.dismiss()
        }
        alertDialogBuilder.setTitle("App2")
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun performLogout() {
        // Navigate to the login screen
        navigateToLoginScreen()
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(requireContext(), logInActivity::class.java)
        startActivity(intent)
    }


//    var box= AlertDialog.Builder(this)
//
//    box.setMessage("Do you want to close this application?")
//    box.setPositiveButton("PROCEED", DialogInterface.OnClickListener { dialog, id -> finish() })
//    box.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, id -> cancel() })
//
//    var alert=box.create()
//    alert.setTitle("App2")
//    alert.show()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}