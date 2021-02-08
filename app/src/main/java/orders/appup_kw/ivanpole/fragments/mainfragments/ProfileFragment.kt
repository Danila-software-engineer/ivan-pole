package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.MainProfileFragmentBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class ProfileFragment : Fragment() {

    lateinit var binding: MainProfileFragmentBinding
    lateinit var viewModel: MainViewModel

    //var notGoingThere = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainProfileFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(false)
        viewModel.user()

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userResponse.observe(viewLifecycleOwner){
            binding.textView16.text = it.nAME+ " " + it.lAST_NAME
            binding.textView17.text = it.pERSONAL_PHONE
        }

        binding.button4.setOnClickListener{
            activity?.onBackPressed()
        }

        binding.kotalog.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_blankFragment)
        }

        binding.basketFirst.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_basketFragment)
        }

        binding.zakazi.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_orderHistoryFragment)
        }

        binding.Soobshenia.setOnClickListener{
            //notGoingThere = false
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_chatFragment)
        }

        binding.oNas.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_aboutUsFragment)
        }

        binding.svazatsa.setOnClickListener{
            //Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_chatFragment)
        }

        binding.dostavka.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_deliveryPaymentFragment)
        }

        binding.obmen.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_exchangeReturnFragment)
        }

        binding.goProfile.setOnClickListener{
            //notGoingThere = false
            Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_setProfileFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        //if(notGoingThere) {
        //    viewModel.ternFooter(true)
        //}

        //println("lolol onDestroyView ProfileFragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        //if(notGoingThere) {
        //    viewModel.ternFooter(true)
        //}
        //println("lolol onDestroy ProfileFragment")
    }
}