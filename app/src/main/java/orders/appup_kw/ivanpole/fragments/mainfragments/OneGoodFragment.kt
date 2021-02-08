package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentGoodsBinding
import orders.appup_kw.ivanpole.databinding.FragmentOneGoodBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class OneGoodFragment : Fragment() {

    lateinit var binding: FragmentOneGoodBinding
    lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentOneGoodBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(true)




        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var favOrNot = false
        binding.buttonAddToFav.setOnClickListener{
            favOrNot = if(!favOrNot){
                binding.buttonAddToFav.setImageResource(R.drawable.vector_fav)
                viewModel.addToFav(1)
                true
            }else {
                binding.buttonAddToFav.setImageResource(R.drawable.vector_nofav)
                viewModel.addToFav(-1)
                false
            }
        }

        binding.buttonToBasket.setOnClickListener{
            binding.groupBuyOff.visibility = View.GONE
            binding.groupBuyOn.visibility = View.VISIBLE
            viewModel.addToBasketL(1)
        }


        var amountBay = 1
        binding.textManySumBay2.text = "${(250*amountBay)} ₽"
        binding.buttonPlusBay2.setOnClickListener{
            amountBay++
            binding.buttonAmountBay2.text = amountBay.toString()
            binding.textManySumBay2.text = "${(250*amountBay)} ₽"
        }
        binding.buttonMinusBay2.setOnClickListener{
            if(amountBay <= 1) {
                binding.groupBuyOff.visibility = View.VISIBLE
                binding.groupBuyOn.visibility = View.GONE
                viewModel.addToBasketL(-1)
            }else{
                amountBay--
                binding.buttonAmountBay2.text = amountBay.toString()
                binding.textManySumBay2.text = "${(250*amountBay)} ₽"
            }
        }
        binding.buttonAmountBay2.setOnClickListener{
            amountBay = 1
            binding.buttonAmountBay2.text = amountBay.toString()
            binding.textManySumBay2.text = "${(250*amountBay)} ₽"
            binding.groupBuyOff.visibility = View.VISIBLE
            binding.groupBuyOn.visibility = View.GONE
            viewModel.addToBasketL(-1)
        }


        binding.buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}