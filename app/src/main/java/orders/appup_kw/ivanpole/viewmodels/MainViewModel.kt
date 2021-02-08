package orders.appup_kw.ivanpole.viewmodels

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import orders.appup_kw.ivanpole.base.BaseViewModel
import orders.appup_kw.ivanpole.cache_bd.entity.BasketEntity
import orders.appup_kw.ivanpole.models.Base
import orders.appup_kw.ivanpole.models.Basket
import orders.appup_kw.ivanpole.models.User
import orders.appup_kw.ivanpole.models.UserResponse
import orders.appup_kw.ivanpole.repository.MainRepository


class MainViewModel @ViewModelInject
constructor(
    private val mainRepository: MainRepository
): BaseViewModel() {


///////////////////////////////////////////////////////////////////

    val fav = MutableLiveData(0)
    val basket = MutableLiveData(0)
    val footer = MutableLiveData(true)

    fun ternFooter(footer: Boolean){ this.footer.value = footer }

    fun addToBasketL(amount: Int)
    {
        basket.value = basket.value?.plus(amount)
    }

    fun addToFav(amount: Int){
        fav.value = fav.value?.plus(amount)
    }


    /*
    fun addToBasket(amount: Int, blogEntity: BasketEntity)
    {
        basket.value = basket.value?.plus(amount)
    }
    fun updateAmountBasket(id: Int, amount: Int){
    }
    fun getById(id: Int){
        viewModelScope.launch {
            mainRepository.getById(id)
        }
    }
    */
    //fun getGoods() = mainRepository.getGoodsFromNetwork()

//////////////////////////////////////////////////////////////////

    val base = MutableLiveData<Base>()

    fun getBaseFromNetwork(){
        viewModelScope.launch {
            mainRepository.getBaseFromNetwork().let {
                base.value = it
            }
        }
    }

///////////////////////////////////////////////////////////////////

    val basketResponse = MutableLiveData<Basket>()

    fun getBasket(){
        compositeDisposable.add(
                mainRepository.getBasket()
                        .subscribe(
                        { basketResponse.value = it},
                        { Log.e("TAGG", "провал")}
                )
        )
    }

///////////////////////////////////////////////////////////////////

    val userResponse = MutableLiveData<User>()

    fun user(){
        compositeDisposable.add(
                mainRepository.getUser().subscribe(
                        { userResponse.value = it.user},
                        { Log.e("TAGG", "провал")}
                )
        )
    }
}