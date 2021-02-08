package orders.appup_kw.ivanpole.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel: ViewModel() {

    val errorLiveData = MutableLiveData<Throwable?>()

    val compositeDisposable = CompositeDisposable()


    override fun onCleared() {
        destroy()
        super.onCleared()
    }

    private fun destroy(){
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }
}