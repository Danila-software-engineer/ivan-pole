package orders.appup_kw.ivanpole.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import orders.appup_kw.ivanpole.cache_bd.dao.BasketDao
import orders.appup_kw.ivanpole.cache_bd.entity.BasketEntity
import orders.appup_kw.ivanpole.models.Base
import orders.appup_kw.ivanpole.models.Basket
import orders.appup_kw.ivanpole.models.Goods
import orders.appup_kw.ivanpole.models.UserResponse
import orders.appup_kw.ivanpole.network_servise.Api

class MainRepository constructor(private val basketDao: BasketDao, private val api: Api) {

    /*
    suspend fun add(blogEntity: BasketEntity){
        basketDao.insert(blogEntity)
    }

    suspend fun delete(id: Int){
        basketDao.deleteByUserId(id.toLong())
    }

    suspend fun update(id: Int, amount: Int){
        basketDao.updateAmountByUserId(id.toLong(), amount)
    }

    suspend fun getById(id: Int){
        basketDao.getById(id.toLong())
    }

    */


    suspend fun getBaseFromNetwork(): Base? {
        val result = api.catalog()
        return if(result.code() == 200) {
            result.body()
        }else{
            null
        }
    }

    fun getBasket(): Observable<Basket> {
        return api.cart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun getUser(): Observable<UserResponse> {
        return api.user()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}