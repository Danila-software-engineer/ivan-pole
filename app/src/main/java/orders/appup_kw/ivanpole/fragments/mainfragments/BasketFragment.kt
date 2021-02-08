package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentBasketBinding
import orders.appup_kw.ivanpole.databinding.FragmentBlankBinding
import orders.appup_kw.ivanpole.models.ProductsInBasket
import orders.appup_kw.ivanpole.ui.adapters.ProductsInBasketRecyclerViewAdapter
import orders.appup_kw.ivanpole.viewmodels.MainViewModel
import java.lang.Exception
import java.util.ArrayList

class BasketFragment : Fragment() {

    lateinit var binding: FragmentBasketBinding
    lateinit var viewModel: MainViewModel

    lateinit var adapter: ProductsInBasketRecyclerViewAdapter
    var products: MutableList<ProductsInBasket?> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(true)



        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpRecViewAndAdapter()

        viewModel.getBasket()

        viewModel.basketResponse.observe(viewLifecycleOwner){
            products.addAll(it.products)
            adapter.notifyDataSetChanged()

            binding.textView56.text = it.price.toString() + "₽"
            binding.textView423.text = it.final_price.toString() + "₽"
            binding.textView20.text = it.weight.toString() + "г"
            binding.textView57.text = (it.final_price - it.price).toString() + "₽"
        }

        binding.makeOder.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_basketFragment_to_deliveryFragment)
        }

        binding.historyOrder.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_basketFragment_to_orderHistoryFragment)
        }
    }



    private fun setUpRecViewAndAdapter() {
        initializeAdapter()
        setUpRecyclerViewAndAdapter()
    }

    private fun initializeAdapter(){
        try {
            adapter = ProductsInBasketRecyclerViewAdapter(requireContext(), products)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun setUpRecyclerViewAndAdapter(){
        binding.resView.layoutManager = LinearLayoutManager(context)//LLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.resView.adapter = adapter
    }

}