package orders.appup_kw.ivanpole.fragments.authfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import orders.appup_kw.ivanpole.R

class CodeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.auth_get_code_sms_fragmet, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button6).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_codeFragment_to_mainActivity)
        }

    }

}