package orders.appup_kw.ivanpole.fragments.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


class DeliveryPaymentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.ternFooter(true)
        return inflater.inflate(R.layout.fragment_delivery_payment, container, false)
    }

}