package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentBasketBinding
import orders.appup_kw.ivanpole.databinding.FragmentOrderHistoryBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class OrderHistoryFragment : Fragment() {

    lateinit var binding: FragmentOrderHistoryBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentOrderHistoryBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(true)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goBasket.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_orderHistoryFragment_to_basketFragment)
        }


    }

}