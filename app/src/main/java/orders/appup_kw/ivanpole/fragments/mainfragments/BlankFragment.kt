package orders.appup_kw.ivanpole.fragments.mainfragments

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
import orders.appup_kw.ivanpole.databinding.FragmentBlankBinding
import orders.appup_kw.ivanpole.models.Category
import orders.appup_kw.ivanpole.ui.GoodsGridItemDecoration
import orders.appup_kw.ivanpole.ui.adapters.CategoryRecyclerViewAdapter
import orders.appup_kw.ivanpole.viewmodels.MainViewModel
import java.lang.Exception
import java.util.ArrayList

class BlankFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentBlankBinding


    lateinit var adapter: CategoryRecyclerViewAdapter
    var categories: MutableList<Category?> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = FragmentBlankBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(true)


        try {
            adapter = CategoryRecyclerViewAdapter(requireContext(), categories, viewModel)
        }catch (e: Exception){
            e.printStackTrace()
        }

        //viewModel.base.observe(viewLifecycleOwner){
        //    it.category
        //}


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resView.setHasFixedSize(true)
        binding.resView.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)


        binding.resView.adapter = adapter
        val largePadding = 16
        val smallPadding = 16
        binding.resView.addItemDecoration(GoodsGridItemDecoration(largePadding, smallPadding))


        viewModel.base.observe(viewLifecycleOwner){
            it.category?.let { it1 -> categories.addAll(it1) }
            adapter.notifyDataSetChanged()
        }


        adapter.click.observe(viewLifecycleOwner){
            Navigation.findNavController(binding.root).navigate(R.id.action_blankFragment_to_goodsFragment)
        }


    }

}