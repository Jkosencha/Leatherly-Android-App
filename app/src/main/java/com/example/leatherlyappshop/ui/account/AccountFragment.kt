package com.example.leatherlyappshop.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.leatherlyappshop.AccountActivity
import com.example.leatherlyappshop.R
import com.example.leatherlyappshop.databinding.FragmentAccountBinding
import com.example.leatherlyappshop.logInActivity


class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val settingsViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val view = inflater.inflate(R.layout.fragment_account, container, false)

        val button = view?.findViewById<Button>(R.id.accountbtn)
        button?.setOnClickListener {
            // Handle the button click event
            openAccountActivity()
        }

        return view
        return root

    }

    private fun openAccountActivity() {
        val intent = Intent(requireContext(), logInActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}