package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentChatBinding
import orders.appup_kw.ivanpole.databinding.FragmentSetProfileBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class ChatFragment : Fragment() {

    lateinit var binding: FragmentChatBinding
    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBackFromChat.setOnClickListener{
            activity?.onBackPressed()
        }
        binding.profileButton.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.profileFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        //viewModel.ternFooter(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        //viewModel.ternFooter(true)
    }


}