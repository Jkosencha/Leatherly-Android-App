package com.example.leatherlyappshop

import BagsAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BagsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BagsAdapter
    private lateinit var productList2: List<BagsAdapter.Product>
    private var filteredList: MutableList<BagsAdapter.Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bags)


        // Initialize the product list
        productList2 = listOf(
            BagsAdapter.Product(R.drawable.bag1, "Women's Coffee bag", 2999.0),
            BagsAdapter.Product(R.drawable.bag2, "Women Laptop bag", 5000.0),
            BagsAdapter.Product(R.drawable.womenbag3, "Retro Buckle bag", 3300.0),
            BagsAdapter.Product(R.drawable.bag4, "Madini women bag", 3500.0),
            BagsAdapter.Product(R.drawable.bag5, "Native leather", 2400.0),
            BagsAdapter.Product(R.drawable.bag6, "Pien leather", 7000.0),
            BagsAdapter.Product(R.drawable.bag7, "Sienna bag", 3000.0),
            BagsAdapter.Product(R.drawable.bag8, "JW laptop bag", 8000.0),
        )

        // Initialize the RecyclerView and adapter
        recyclerView = findViewById(R.id.bags_recycler)
        adapter = BagsAdapter(productList2, this)

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

        for (product in productList2) {
            if (product.name.contains(query, true)) {
                filteredList.add(product)
            }
        }

        adapter.updateList(filteredList)
    }

    fun onAddToCart(product: BagsAdapter.Product) {
        // Handle the add to cart action here
        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

    fun onItemClick(product: BagsAdapter.Product) {
        // Handle the item click event here
        // You can create an Intent and start a new activity or perform any other action

        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

}
