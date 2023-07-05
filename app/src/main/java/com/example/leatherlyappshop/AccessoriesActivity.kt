package com.example.leatherlyappshop

import AccessoriesAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AccessoriesActivity : AppCompatActivity(), AccessoriesAdapter.OnAddToCartClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AccessoriesAdapter
    private lateinit var productList5: List<AccessoriesAdapter.Product>
    private var filteredList: MutableList<AccessoriesAdapter.Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accessories)

        // Initialize the product list
        productList5 = listOf(
            AccessoriesAdapter.Product(R.drawable.accessories1, "Rori women belts", 1000.0),
            AccessoriesAdapter.Product(R.drawable.accessories2, "Heather Belt", 2000.0),
            AccessoriesAdapter.Product(R.drawable.accessories3, "Faux cap", 2360.0),
            AccessoriesAdapter.Product(R.drawable.accessories4, "Baseball cap", 3500.0),
            AccessoriesAdapter.Product(R.drawable.accessories5, "Leather visor", 5000.0),
            AccessoriesAdapter.Product(R.drawable.accessories6, "Chef watch", 8000.0),
            AccessoriesAdapter.Product(R.drawable.accessories7, "Alligator leather", 1000.0),
            AccessoriesAdapter.Product(R.drawable.accessories8, "Eco leather bracelate", 4500.0),
        )

        // Initialize the RecyclerView and adapter
        recyclerView = findViewById(R.id.accessories_recycler)
        adapter = AccessoriesAdapter(productList5, this)

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

        for (product in productList5) {
            if (product.name.contains(query, true)) {
                filteredList.add(product)
            }
        }

        adapter.updateList(filteredList)
    }

    override fun onAddToCart(product: AccessoriesAdapter.Product) {
        // Handle the add to cart action here
        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

    override fun onItemClick(product: AccessoriesAdapter.Product) {
        // Handle the item click event here
        // You can create an Intent and start a new activity or perform any other action

        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }
}
