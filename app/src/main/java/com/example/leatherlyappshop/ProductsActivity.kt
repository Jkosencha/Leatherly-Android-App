package com.example.leatherlyappshop

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity(), ProductsAdapter.OnAddToCartClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductsAdapter
    private lateinit var productList: List<ProductsAdapter.Product>
    private var filteredList: MutableList<ProductsAdapter.Product> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)


        // Initialize the product list
        productList = listOf(
            ProductsAdapter.Product(R.drawable.accessories1, "Rori women belts", 1000.0),
            ProductsAdapter.Product(R.drawable.bag1, "Women's Coffee bag", 2999.0),
            ProductsAdapter.Product(R.drawable.shoes1, "black cookie shoes", 3999.0),
            ProductsAdapter.Product(R.drawable.clothe1, "Disk Jacket", 4900.9),
            ProductsAdapter.Product(R.drawable.bag2, "Women Laptop bag", 5000.0),
            ProductsAdapter.Product(R.drawable.accessories2, "Heather Belt", 2000.0),
            ProductsAdapter.Product(R.drawable.clothe2, "Bike leather jacket", 5000.0),
            ProductsAdapter.Product(R.drawable.accessories3, "Faux cap", 2360.0),
            ProductsAdapter.Product(R.drawable.shoes2, "Fatima Oat sandals", 4000.0),
            ProductsAdapter.Product(R.drawable.clothe8, "Trench Shirt", 8900.0),
            ProductsAdapter.Product(R.drawable.accessories6, "Chef watch", 8000.0),
            ProductsAdapter.Product(R.drawable.shoes4, "Garccone sandals", 3500.0),
            ProductsAdapter.Product(R.drawable.accessories7, "Alligator leather", 1000.0),
            ProductsAdapter.Product(R.drawable.shoes7, "Taoffen summer shoes", 5550.0),
            ProductsAdapter.Product(R.drawable.clothe3, "Lambskin leather pants", 3900.0),
            ProductsAdapter.Product(R.drawable.bag5, "Native leather", 2400.0),
            ProductsAdapter.Product(R.drawable.clothe5, "Prince top", 5900.0),
            ProductsAdapter.Product(R.drawable.accessories8, "Eco leather bracelate", 4500.0),
            ProductsAdapter.Product(R.drawable.clothe7, "Leren leather skirt", 7900.0),
            ProductsAdapter.Product(R.drawable.accessories4, "Baseball cap", 3500.0),
            ProductsAdapter.Product(R.drawable.shoes3, "Zara women sandals", 4999.0),
            ProductsAdapter.Product(R.drawable.bag7, "Sienna bag", 3000.0),
            ProductsAdapter.Product(R.drawable.shoes5, "BeauVintage", 12000.0),
            ProductsAdapter.Product(R.drawable.accessories5, "Leather visor", 5000.0),
            ProductsAdapter.Product(R.drawable.shoes6, "Roma leather", 6999.9),
            ProductsAdapter.Product(R.drawable.clothe4, "Zahra sleeveless", 4900.0),
            ProductsAdapter.Product(R.drawable.shoes8, "Buckle men boots", 6000.0),
            ProductsAdapter.Product(R.drawable.womenbag3, "Retro Buckle bag", 3300.0),
            ProductsAdapter.Product(R.drawable.bag4, "Madini women bag", 3500.0),
            ProductsAdapter.Product(R.drawable.bag6, "Pien leather", 7000.0),
            ProductsAdapter.Product(R.drawable.clothe6, "Fleece leather coat", 6900.0),
            ProductsAdapter.Product(R.drawable.bag8, "JW laptop bag", 8000.0),
        )

        // Initialize the RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerview)
        adapter = ProductsAdapter(productList, this@ProductsActivity)

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

        for (product in productList) {
            if (product.name.contains(query, true)) {
                filteredList.add(product)
            }
        }

        adapter.updateList(filteredList)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                // Perform search action here
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onAddToCart(product: ProductsAdapter.Product) {
        // Handle the add to cart action here
        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }

    override fun onItemClick(product: ProductsAdapter.Product) {
        // Handle the item click event here
        // You can create an Intent and start a new activity or perform any other action

        var next= Intent(this,PaybillActivity::class.java)
        startActivity(next)
    }



}
