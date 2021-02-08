package orders.appup_kw.ivanpole.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import orders.appup_kw.ivanpole.R
import orders.appup_kw.ivanpole.databinding.ActivityMainBinding
import orders.appup_kw.ivanpole.viewmodels.MainViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    lateinit var viewModel: MainViewModel// by viewModels()

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment3) as NavHostFragment? ?: return

        val navController = host.navController

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        //Запрос на получение каталога и списка товаров
        viewModel.getBaseFromNetwork()


        viewModel.fav.observe(this) {
            it?.let {
                if(it == 1){
                    binding.favAmount.visibility = View.VISIBLE
                }
                if(it >= 1){
                    binding.favAmount.text = it.toString()
                }else{
                    binding.favAmount.visibility = View.GONE
                }

            }
        }

        viewModel.basket.observe(this) {
            it?.let {
                if(it == 1){
                    binding.basketAmount.visibility = View.VISIBLE
                }
                if(it >= 1){
                    binding.basketAmount.text = it.toString()
                }else{
                    binding.basketAmount.visibility = View.GONE
                }
            }

        }

        viewModel.footer.observe(this) {
            it?.let {
                if(it){
                    binding.constraintLayout.visibility = View.VISIBLE
                    binding.linearLayout3.visibility = View.VISIBLE
                }else{
                    binding.constraintLayout.visibility = View.GONE
                    binding.linearLayout3.visibility = View.GONE
                }
            }

        }




        binding.profileButton.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }

        binding.basketFirst.setOnClickListener {
            navController.navigate(R.id.basketFragment)
        }

        binding.katalogFirst.setOnClickListener {
            navController.navigate(R.id.blankFragment)
        }



        binding.favoritesFirst.setOnClickListener {
            navController.navigate(R.id.favsFragment)
        }


    }



    override fun onBackPressed() {
        super.onBackPressed()

        //binding.constraintLayout.visibility = View.VISIBLE
        //binding.linearLayout3.visibility = View.VISIBLE

    }
}