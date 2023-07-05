package com.example.leatherlyappshop.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.leatherlyappshop.*
import com.example.leatherlyappshop.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val button1 = view.findViewById<Button>(R.id.purchase1)
        val button2 = view.findViewById<Button>(R.id.purchase2)
        val button3 = view.findViewById<Button>(R.id.purchase3)
        val button4 = view.findViewById<Button>(R.id.purchase4)
        val button5 = view.findViewById<Button>(R.id.purchase5)
        val button6 = view.findViewById<Button>(R.id.purchase6)
        val button7 = view.findViewById<Button>(R.id.purchase7)
        val button8 = view.findViewById<Button>(R.id.purchase8)


        val intent = Intent(activity, PaybillActivity::class.java)


        button1.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            // Handle click action for button1
            val intent = Intent(requireContext(), PaybillActivity::class.java)
            startActivity(intent)
        }

        val allbutton = view.findViewById<Button>(R.id.allbtn)
        allbutton.setOnClickListener {
            // Handle the button click event
            openProductsActivity()
        }

        val shoesbutton = view.findViewById<Button>(R.id.shoesbtn)
        shoesbutton.setOnClickListener {
            // Handle the button click event
            openShoesActivity()
        }

        val bagsbutton = view.findViewById<Button>(R.id.bagsbtn)
        bagsbutton.setOnClickListener {
            // Handle the button click event
            openBagsActivity()
        }

        val clothesbutton = view.findViewById<Button>(R.id.clothesbtn)
        clothesbutton.setOnClickListener {
            // Handle the button click event
            openClothesActivity()
        }

        val accessoriesbutton = view.findViewById<Button>(R.id.accessoriesbtn)
        accessoriesbutton.setOnClickListener {
            // Handle the button click event
            openAccessoriesActivity()
        }

        return view
        return root
    }



    private fun openAccessoriesActivity() {
        val intent = Intent(requireContext(), AccessoriesActivity::class.java)
        startActivity(intent)
    }

    private fun openClothesActivity() {
        val intent = Intent(requireContext(), ClothesActivity::class.java)
        startActivity(intent)
    }

    private fun openShoesActivity() {
        val intent = Intent(requireContext(), ShoesActivity::class.java)
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

    private fun openProductsActivity() {
        val intent = Intent(requireContext(), ProductsActivity::class.java)
        startActivity(intent)
    }

}