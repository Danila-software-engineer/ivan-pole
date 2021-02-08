package orders.appup_kw.ivanpole.cache_bd

import androidx.room.Database
import androidx.room.RoomDatabase
import orders.appup_kw.ivanpole.cache_bd.dao.BasketDao
import orders.appup_kw.ivanpole.cache_bd.entity.BasketEntity

@Database(entities = [BasketEntity::class ], version = 1)
abstract class BasketDatabase: RoomDatabase() {

    abstract fun basketDao(): BasketDao

    companion object{
        val DATABASE_NAME: String = "basket"
    }


}