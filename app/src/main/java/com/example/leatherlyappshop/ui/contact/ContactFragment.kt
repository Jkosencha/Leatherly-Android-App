package com.example.leatherlyappshop.ui.contact

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.leatherlyappshop.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.sendbtn.setOnClickListener {
            sendEmail()
        }

        return root
    }

    private fun sendEmail() {
        val name = binding.personName.text.toString().trim()
        val email = binding.emailAddress.text.toString().trim()
        val message = binding.message.text.toString().trim()

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("jenniferkosencha@gmail.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact Us - Message from $name")
        emailIntent.putExtra(Intent.EXTRA_TEXT, message)

        startActivity(Intent.createChooser(emailIntent, "Send Email"))

        // Clear the EditText fields
        binding.personName.text = null
        binding.emailAddress.text = null
        binding.message.text = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
