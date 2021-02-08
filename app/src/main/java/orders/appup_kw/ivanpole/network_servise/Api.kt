package orders.appup_kw.ivanpole.network_servise

import io.reactivex.Observable
import okhttp3.ResponseBody
import orders.appup_kw.ivanpole.models.Auth
import orders.appup_kw.ivanpole.models.Base
import orders.appup_kw.ivanpole.models.Basket
import orders.appup_kw.ivanpole.models.UserResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("catalog/")
    suspend fun catalog() : Response<Base>

    @FormUrlEncoded
    @POST("auth/")
    fun auth(@Field("login") login: String, @Field("pass") pass: String) : Observable<Auth>

    @GET("user/")
    fun user() : Observable<UserResponse>

    @GET("cart/")
    fun cart(): Observable<Basket>


}