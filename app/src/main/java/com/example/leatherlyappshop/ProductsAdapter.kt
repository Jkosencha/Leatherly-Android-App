package com.example.leatherlyappshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    private var productList: List<Product>,
    private val addToCartClickListener: OnAddToCartClickListener
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    interface OnAddToCartClickListener {
        fun onAddToCart(product: Product)
        fun onItemClick(product: Product)
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProduct: ImageView = itemView.findViewById(R.id.imageViewProduct)
        val textViewProductName: TextView = itemView.findViewById(R.id.textViewProductName)
        val textViewProductPrice: TextView = itemView.findViewById(R.id.textViewProductPrice)
        val buttonAddToCart: Button = itemView.findViewById(R.id.buttonAddToCart)
    }

    data class Product(
        val imageResId: Int,
        val name: String,
        val price: Double
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.productview_activity, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.imageViewProduct.setImageResource(product.imageResId)
        holder.textViewProductName.text = product.name
        holder.textViewProductPrice.text = "Ksh${product.price}"

        holder.buttonAddToCart.setOnClickListener {
            addToCartClickListener.onAddToCart(product)
        }

        holder.itemView.setOnClickListener {
            addToCartClickListener.onItemClick(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    fun updateList(newList: List<Product>) {
        productList = newList
        notifyDataSetChanged()
    }
}
