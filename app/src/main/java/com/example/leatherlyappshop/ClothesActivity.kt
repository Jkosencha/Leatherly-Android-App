package com.example.leatherlyappshop

import ClothesAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ClothesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ClothesAdapter
    private lateinit var productList4: List<ClothesAdapter.Product>
    private var filteredList: MutableList<ClothesAdapter.Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothes)


        // Initialize the product list
        productList4 = listOf(
            ClothesAdapter.Product(R.drawable.clothe1, "Disk Jacket", 4900.9),
            ClothesAdapter.Product(R.drawable.clothe2, "Bike leather jacket", 5000.0),
            ClothesAdapter.Product(R.drawable.clothe3, "Lambskin leather pants", 3900.0),
            ClothesAdapter.Product(R.drawable.clothe4, "Zahra sleeveless", 4900.0),
            ClothesAdapter.Product(R.drawable.clothe5, "Prince top", 5900.0),
            ClothesAdapter.Product(R.drawable.clothe6, "Fleece leather coat", 6900.0),
            ClothesAdapter.Product(R.drawable.clothe7, "Leren leather skirt", 7900.0),
            ClothesAdapter.Product(R.drawable.clothe8, "Trench Shirt", 8900.0),
        )

        // Initialize the RecyclerView and adapter
        recyclerView = findViewById(R.id.clothes_recycler)
        adapter = ClothesAdapter(productList4, this)

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

        for (product in productList4) {
            if (product.name.contains(query, true)) {
                filteredList.add(product)
            }
        }

        adapter.updateList(filteredList)
    }

    fun onAddToCart(product: ClothesAdapter.Product) {
        // Handle the add to cart action here
        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

    fun onItemClick(product: ClothesAdapter.Product) {
        // Handle the item click event here
        // You can create an Intent and start a new activity or perform any other action

        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

}
