package orders.appup_kw.ivanpole.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import orders.appup_kw.ivanpole.base.BaseViewModel
import orders.appup_kw.ivanpole.repository.AuthRepository

class AuthViewModel @ViewModelInject
constructor(
        private val authRepository: AuthRepository
): BaseViewModel() {

    val successAuth = MutableLiveData<Boolean>()

    fun auth(login: String, pass: String){
        compositeDisposable.add(
                authRepository.postAuth(login, pass).subscribe(
                        {successAuth.value = true},
                        {error -> errorLiveData.value = error}
                )
        )
    }



}