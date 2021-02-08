package orders.appup_kw.ivanpole.fragments.authfragments

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.AuthSplashScreenFragmentBinding
import orders.appup_kw.ivanpole.databinding.MainProfileFragmentBinding

class SplashFragment : Fragment() {

    lateinit var binding: AuthSplashScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = AuthSplashScreenFragmentBinding.inflate(inflater, container, false)



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_splashFragment_to_registerFragment)
        }
    }



}