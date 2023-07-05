import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leatherlyappshop.AccessoriesActivity
import com.example.leatherlyappshop.R

class AccessoriesAdapter(
    private var productList5: List<Product>,
    private val addToCartClickListener: AccessoriesActivity
) : RecyclerView.Adapter<AccessoriesAdapter.ProductViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_accessories, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList5[position]

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
        return productList5.size
    }

    fun updateList(newList: MutableList<Product>) {
        productList5 = newList
        notifyDataSetChanged()
    }

    data class Product(
        val imageResId: Int,
        val name: String,
        val price: Double
    )
}
