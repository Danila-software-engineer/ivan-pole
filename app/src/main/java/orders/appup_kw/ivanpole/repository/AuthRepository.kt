package orders.appup_kw.ivanpole.repository


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import orders.appup_kw.ivanpole.models.Auth
import orders.appup_kw.ivanpole.network_servise.Api

class AuthRepository constructor(private val api: Api) {

    fun postAuth(login: String, pass: String): Observable<Auth> {
        return api.auth(login, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }



}