package orders.appup_kw.ivanpole.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import orders.appup_kw.ivanpole.databinding.BasketLayoutBinding
import orders.appup_kw.ivanpole.models.ProductsInBasket

class ProductsInBasketRecyclerViewAdapter(
    private val context: Context,
    private val products: List<ProductsInBasket?>
) : RecyclerView.Adapter<ProductsInBasketRecyclerViewAdapter.FavoritesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val binding = BasketLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {

        holder.setAllTextView(products[position])
        holder.loadImage(context, products[position])

    }




    override fun getItemCount() = products.size

    class FavoritesViewHolder(var binding: BasketLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun setAllTextView(product: ProductsInBasket?){
            binding.textView38.text = product?.name
            binding.textView39.text = product?.quantity.toString()
            binding.textView37.text = product?.price.toString() + "₽"
        }


        fun loadImage(context: Context, product: ProductsInBasket?){
            //try {
            //    Glide.with(context)
            //        .load(product?.image)
            //        .into(binding.image)
            //} catch (e: Exception) {
            //    e.printStackTrace()
            //    binding.image.setImageResource(R.drawable.img_not_found)
            //}
        }
    }




}