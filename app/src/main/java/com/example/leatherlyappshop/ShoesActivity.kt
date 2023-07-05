package com.example.leatherlyappshop


import ShoesAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoesActivity : AppCompatActivity(), ShoesAdapter.OnAddToCartClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShoesAdapter
    private lateinit var productList3: List<ShoesAdapter.Product>
    private var filteredList: MutableList<ShoesAdapter.Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoes)


        // Initialize the product list
        productList3 = listOf(
            ShoesAdapter.Product(R.drawable.shoes1, "black cookie shoes", 3999.0),
            ShoesAdapter.Product(R.drawable.shoes2, "Fatima Oat sandals", 4000.0),
            ShoesAdapter.Product(R.drawable.shoes3, "Zara women sandals", 4999.0),
            ShoesAdapter.Product(R.drawable.shoes4, "Garccone sandals", 3500.0),
            ShoesAdapter.Product(R.drawable.shoes5, "BeauVintage", 12000.0),
            ShoesAdapter.Product(R.drawable.shoes6, "Roma leather", 6999.9),
            ShoesAdapter.Product(R.drawable.shoes7, "Taoffen summer shoes", 5550.0),
            ShoesAdapter.Product(R.drawable.shoes8, "Buckle men boots", 6000.0),
        )

        // Initialize the RecyclerView and adapter
        recyclerView = findViewById(R.id.shoes_recycler)
        adapter = ShoesAdapter(productList3, this)


        // Set the adapter to the RecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Perform search based on the submitted query
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Perform search as the text changes
                filterList(newText)
                return true
            }
        })

        return true
    }

    private fun filterList(query: String) {
        // Filter the product list based on the search query
        filteredList.clear()

        for (product in productList3) {
            if (product.name.contains(query, true)) {
                filteredList.add(product)
            }
        }

        adapter.updateList(filteredList)
    }

    override fun onAddToCart(product: ShoesAdapter.Product) {
        // Handle the add to cart action here
        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

    override fun onItemClick(product: ShoesAdapter.Product) {
        // Handle the item click event here
        // You can create an Intent and start a new activity or perform any other action

        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

}
