package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentSetProfileBinding
import orders.appup_kw.ivanpole.databinding.MainProfileFragmentBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class SetProfileFragment : Fragment() {

    lateinit var binding: FragmentSetProfileBinding
    lateinit var viewModel: MainViewModel

    var notGoingThere = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSetProfileBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(false)
        println("lolol onCreateView SetProfileFragment")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBackFromSetProfile.setOnClickListener{
            activity?.onBackPressed()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        //viewModel.ternFooter(true)

        println("lolol onDestroyView SetProfileFragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        //viewModel.ternFooter(true)

        println("lolol onDestroy SetProfileFragment")
    }
}