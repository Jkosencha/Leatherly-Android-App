package com.example.leatherlyappshop.ui.help

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.leatherlyappshop.*
import com.example.leatherlyappshop.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val helpViewModel =
            ViewModelProvider(this).get(HelpViewModel::class.java)

        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val policyText: TextView = binding.policy
        policyText.setOnClickListener {
            openPolicyActivity()
        }

        val faqsText: TextView = binding.faq
        faqsText.setOnClickListener {
            openFAQsActivity()
        }

        val location: TextView = binding.location
        location.setOnClickListener {
            openLocationActivity()
        }

        return root
    }

    private fun openLocationActivity() {
        val intent = Intent(requireContext(), MapActivity::class.java)
        startActivity(intent)
    }

    private fun openFAQsActivity() {
        val intent = Intent(requireContext(), FAQs::class.java)
        startActivity(intent)
    }

    private fun openPolicyActivity() {
        val intent = Intent(requireContext(), PrivacyPolicy::class.java)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}