package orders.appup_kw.ivanpole.fragments.mainfragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentGoodsBinding
import orders.appup_kw.ivanpole.models.Products
import orders.appup_kw.ivanpole.ui.GoodsGridItemDecoration
import orders.appup_kw.ivanpole.ui.adapters.GoodsRecyclerViewAdapter
import orders.appup_kw.ivanpole.viewmodels.MainViewModel
import java.lang.Exception
import java.util.ArrayList


class GoodsFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentGoodsBinding

    lateinit var adapter: GoodsRecyclerViewAdapter

    var products: MutableList<Products?> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = FragmentGoodsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(true)

        try {
            adapter = GoodsRecyclerViewAdapter(requireContext(), products, viewModel)
        }catch (e: Exception){
            e.printStackTrace()
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)


        binding.recView.adapter = adapter
        val largePadding = 32
        val smallPadding = 32
        binding.recView.addItemDecoration(GoodsGridItemDecoration(largePadding, smallPadding))


        viewModel.base.observe(viewLifecycleOwner){
            it.products?.let { it1 -> products.addAll(it1) }
            adapter.notifyDataSetChanged()
        }



        binding.buttonFilter.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_goodsFragment_to_setSortingFragment)
        }



        /*
        binding.goodsFirst.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_goodsFragment_to_oneGoodFragment)
        }
        var favOrNot = false
        binding.buttonAddToFav.setOnClickListener{
            favOrNot = if(!favOrNot){
                binding.buttonAddToFav.setImageResource(R.drawable.vector_fav)
                viewModel.addToFav(1)
                true
            }else {
                binding.buttonAddToFav.setImageResource(R.drawable.vector_nofav)
                viewModel.addToFav(0)
                false
            }
        }

        binding.buttonToBasket.setOnClickListener{
            binding.groupBay.visibility = View.GONE
            binding.groupBayAmount.visibility = View.VISIBLE
            viewModel.addToBasket(1)
        }


        var amountBay = 1
        binding.textManySumBay.text = "${(250*amountBay)} ₽"
        binding.buttonPlusBay.setOnClickListener{
            amountBay++
            binding.buttonAmountBay.text = amountBay.toString()
            binding.textManySumBay.text = "${(250*amountBay)} ₽"
        }
        binding.buttonMinusBay.setOnClickListener{
            if(amountBay <= 1) {
                binding.groupBay.visibility = View.VISIBLE
                binding.groupBayAmount.visibility = View.GONE
                viewModel.addToBasket(0)
            }else{
                amountBay--
                binding.buttonAmountBay.text = amountBay.toString()
                binding.textManySumBay.text = "${(250*amountBay)} ₽"
            }
        }
        binding.buttonAmountBay.setOnClickListener{
            amountBay = 1
            binding.buttonAmountBay.text = amountBay.toString()
            binding.textManySumBay.text = "${(250*amountBay)} ₽"
            binding.groupBay.visibility = View.VISIBLE
            binding.groupBayAmount.visibility = View.GONE
            viewModel.addToBasket(0)
        }
        */









        binding.buttonSearchOn.setOnClickListener {
            binding.groupSearchOff.visibility = View.VISIBLE
            binding.groupSearchOn.visibility = View.GONE
        }

        binding.buttonSearchClose.setOnClickListener {
            binding.groupSearchOff.visibility = View.GONE
            binding.groupSearchOn.visibility = View.VISIBLE
        }

        var sortOrNot = false
        binding.buttonSort.setOnClickListener {
            sortOrNot = if(!sortOrNot){
                binding.constraintSort.visibility = View.VISIBLE
                binding.buttonSort.setImageResource(R.drawable.vector_krest)
                binding.buttonSort.background.setTint(Color.parseColor("#FF9B39"))
                true
            }else {
                binding.constraintSort.visibility = View.GONE
                binding.buttonSort.setImageResource(R.drawable.group_katigory)
                binding.buttonSort.background.setTint(Color.parseColor("#3B464C"))
                false
            }
        }

        binding.textNewSort.setOnClickListener {
            clearSortList()
            binding.textNewSort.setTextColor(Color.parseColor("#FF9B39"))
        }
        binding.textRichSort.setOnClickListener {
            clearSortList()
            binding.textRichSort.setTextColor(Color.parseColor("#FF9B39"))
        }
        binding.textChipSort.setOnClickListener {
            clearSortList()
            binding.textChipSort.setTextColor(Color.parseColor("#FF9B39"))
        }

        binding.buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun clearSortList(){
        binding.textNewSort.setTextColor(Color.parseColor("#FFFFFF"))
        binding.textRichSort.setTextColor(Color.parseColor("#FFFFFF"))
        binding.textChipSort.setTextColor(Color.parseColor("#FFFFFF"))
    }
}