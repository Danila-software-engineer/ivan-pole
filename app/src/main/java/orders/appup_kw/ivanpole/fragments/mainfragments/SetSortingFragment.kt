package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.FragmentSetProfileBinding
import orders.appup_kw.ivanpole.databinding.FragmentSetSortingBinding
import orders.appup_kw.ivanpole.databinding.MainProfileFragmentBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class SetSortingFragment : Fragment() {

    lateinit var binding: FragmentSetSortingBinding
    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSetSortingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGoBack.setOnClickListener{
            activity?.onBackPressed()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.ternFooter(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.ternFooter(true)
    }

}