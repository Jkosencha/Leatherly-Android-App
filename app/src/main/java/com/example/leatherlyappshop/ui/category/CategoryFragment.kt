package com.example.leatherlyappshop.ui.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.leatherlyappshop.*
import com.example.leatherlyappshop.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val categoryViewModel =
            ViewModelProvider(this).get(CategoryViewModel::class.java)

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.bagscard.setOnClickListener {
            openBagsActivity()
        }

        binding.acccessoriescard.setOnClickListener {
            openAccessoriesActivity()
        }

        binding.clothescard.setOnClickListener {
            openClothesActivity()
        }


        binding.shoescard.setOnClickListener {
            openShoesActivity()
        }

        return root
    }

    private fun openShoesActivity() {
        val intent = Intent(requireContext(), ShoesActivity::class.java)
        startActivity(intent)
    }

    private fun openClothesActivity() {
        val intent = Intent(requireContext(), ClothesActivity::class.java)
        startActivity(intent)
    }

    private fun openAccessoriesActivity() {
        val intent = Intent(requireContext(), AccessoriesActivity::class.java)
        startActivity(intent)
    }

    private fun openBagsActivity() {
        val intent = Intent(requireContext(), BagsActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}