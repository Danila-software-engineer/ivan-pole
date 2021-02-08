package orders.appup_kw.ivanpole.ui.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import orders.appup_kw.ivanpole.databinding.GoodsLayoutBinding
import orders.appup_kw.ivanpole.models.Products
import orders.appup_kw.ivanpole.viewmodels.MainViewModel

class GoodsRecyclerViewAdapter(
    var context: Context,
    private val goods: List<Products?>,
    val viewModel: MainViewModel
) : RecyclerView.Adapter<GoodsRecyclerViewAdapter.GoodsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val binding = GoodsLayoutBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return GoodsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {

        //holder.binding.kkal.text = goods[position].kkal.toInt().toString()
        //holder.binding.protein.text = goods[position].protein.toInt().toString()
        //holder.binding.xe.text = goods[position].xe.toInt().toString()
        holder.binding.goodsName.text = goods[position]?.nAME


        holder.binding.textManyBay.text = goods[position]?.pRICE.toString() + " " + goods[position]?.cURRENCY
        holder.binding.discountPrice.text = goods[position]?.dISCOUNT_PRICE.toString() + " " + goods[position]?.cURRENCY

        /*
        holder.binding.kkal.text = goods[position].kkal.toInt().toString()
        holder.binding.protein.text = goods[position].protein.toInt().toString()
        holder.binding.xe.text = goods[position].xe.toInt().toString()
        holder.binding.goodsName.text = goods[position].name
        holder.binding.textManyBay.text = goods[position].coast.toString()




        if(!goods[position].status.isNullOrEmpty()){
            holder.binding.status.visibility = View.VISIBLE
            holder.binding.status.text = goods[position].status.toString()
            holder.binding.status.background.setTint(Color.parseColor(goods[position].colorStatus.toString()))
        }

        try {
            Glide.with(context)
                    .load(goods[position].img)
                    .into(holder.binding.goodsImage)
        } catch (e: Exception) {
            e.printStackTrace()
            holder.binding.goodsImage.setImageResource(R.drawable.img_not_found)
        }


        holder.binding.goodsFirst.setOnClickListener{
            Navigation.findNavController(holder.binding.root).navigate(R.id.action_goodsFragment_to_oneGoodFragment)
        }
        var favOrNot = false
        holder.binding.buttonAddToFav.setOnClickListener{
            favOrNot = if(!favOrNot){
                holder.binding.buttonAddToFav.setImageResource(R.drawable.vector_fav)
                viewModel.addToFav(1)
                true
            }else {
                holder.binding.buttonAddToFav.setImageResource(R.drawable.vector_nofav)
                viewModel.addToFav(-1)
                false
            }
        }

        holder.binding.buttonToBasket.setOnClickListener{
            holder.binding.groupBay.visibility = View.GONE
            holder.binding.groupBayAmount.visibility = View.VISIBLE
            viewModel.addToBasket(1,
                    BasketEntity(goods[position].id,
                    holder.binding.buttonAmountBay.text.toString().toInt(),
                    goods[position].name,
                    goods[position].img,goods[position].coast))
        }


        var amountBay = 1

        //viewModel.getById(goods[position].id)

        holder.binding.textManySumBay.text = "${(250*amountBay)} ₽"
        holder.binding.buttonPlusBay.setOnClickListener{
            amountBay++
            holder.binding.buttonAmountBay.text = amountBay.toString()
            holder.binding.textManySumBay.text = "${(250*amountBay)} ₽"
            viewModel.updateAmountBasket(goods[position].id,amountBay)
        }
        holder.binding.buttonMinusBay.setOnClickListener{
            if(amountBay <= 1) {
                holder.binding.groupBay.visibility = View.VISIBLE
                holder.binding.groupBayAmount.visibility = View.GONE
                viewModel.addToBasket(-1,
                        BasketEntity(goods[position].id,
                                holder.binding.buttonAmountBay.text.toString().toInt(),
                                goods[position].name,
                                goods[position].img,goods[position].coast))

            }else{
                amountBay--
                holder.binding.buttonAmountBay.text = amountBay.toString()
                holder.binding.textManySumBay.text = "${(250*amountBay)} ₽"
                viewModel.updateAmountBasket(goods[position].id,amountBay)
            }
        }
        holder.binding.buttonAmountBay.setOnClickListener{
            amountBay = 1
            holder.binding.buttonAmountBay.text = amountBay.toString()
            holder.binding.textManySumBay.text = "${(250*amountBay)} ₽"
            holder.binding.groupBay.visibility = View.VISIBLE
            holder.binding.groupBayAmount.visibility = View.GONE
            viewModel.addToBasket(-1,
                    BasketEntity(goods[position].id,
                            holder.binding.buttonAmountBay.text.toString().toInt(),
                            goods[position].name,
                            goods[position].img,goods[position].coast))
        }


        */

    }

    override fun getItemCount() = goods.size

    class GoodsViewHolder(var binding: GoodsLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}

