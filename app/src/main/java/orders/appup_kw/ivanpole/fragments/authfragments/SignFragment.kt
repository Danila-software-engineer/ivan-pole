package orders.appup_kw.ivanpole.fragments.authfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.base.BaseFragment
import orders.appup_kw.ivanpole.databinding.AuthSignInFragmentBinding
import orders.appup_kw.ivanpole.databinding.FragmentGoodsBinding
import orders.appup_kw.ivanpole.viewmodels.AuthViewModel
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class SignFragment : Fragment() {

    //override val viewModel: AuthViewModel by viewModels()
    //override fun getViewBinding()  = AuthSignInFragmentBinding.inflate(layoutInflater)

    lateinit var viewModel: AuthViewModel
    lateinit var binding: AuthSignInFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = AuthSignInFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAuthButtonListener()
        setSuccessAuthObserver()
    }

    private fun setSuccessAuthObserver(){
        viewModel.successAuth.observe(viewLifecycleOwner){
            Navigation.findNavController(binding.root).navigate(R.id.action_signFragment_to_mainActivity)
            //viewModel.user()
        }
    }

    private fun setAuthButtonListener(){
        binding.button2.setOnClickListener {
            viewModel.auth(binding.cardNumber.text.toString(), binding.editTextTextPersonName4.text.toString())
            //viewModel.user()
        }
    }

}