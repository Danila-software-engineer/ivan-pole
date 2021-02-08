package orders.appup_kw.ivanpole.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.CatalogLayoutBinding
import orders.appup_kw.ivanpole.models.Category
import orders.appup_kw.ivanpole.viewmodels.MainViewModel

class CategoryRecyclerViewAdapter(
    var context: Context,
    private val categories: List<Category?>,
    val viewModel: MainViewModel
) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>() {

    val imgUri = "http://kukoba1.av.fvds.ru"

    val click = MutableLiveData<Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CatalogLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {


        holder.binding.textView41.text = categories[position]?.nAME

        when(position % 6){
            0->holder.binding.choseCatigory.setBackgroundResource(R.drawable.background_for_catigory)
            1->holder.binding.choseCatigory.setBackgroundResource(R.drawable.background_for_catigory1)
            2->holder.binding.choseCatigory.setBackgroundResource(R.drawable.background_for_catigory2)
            3->holder.binding.choseCatigory.setBackgroundResource(R.drawable.background_for_catigory3)
            4->holder.binding.choseCatigory.setBackgroundResource(R.drawable.background_for_catigory4)
        }

        holder.itemView.setOnClickListener{
            click.value = true
            //Navigation.findNavController(binding.root).navigate(R.id.action_blankFragment_to_goodsFragment)
        }
        //holder.binding.choseCatigory.setBackgroundResource(R.drawable.background_for_catigory)
        try {
            Glide.with(context)
                .load(imgUri+categories[position]?.pICTURE)
                .into(holder.binding.imageView3)
        } catch (e: Exception) {
            e.printStackTrace()
            holder.binding.imageView3.setImageResource(R.drawable.img_not_found)
        }

    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(var binding: CatalogLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}