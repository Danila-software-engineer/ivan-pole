package orders.appup_kw.ivanpole.fragments.authfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.AuthRegisterScreenFragmentBinding
import orders.appup_kw.ivanpole.databinding.FragmentOneGoodBinding


class RegisterFragment : Fragment() {

    lateinit var binding: AuthRegisterScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = AuthRegisterScreenFragmentBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_codeFragment)
        }

        binding.loginFromRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_signFragment)
        }
    }

}