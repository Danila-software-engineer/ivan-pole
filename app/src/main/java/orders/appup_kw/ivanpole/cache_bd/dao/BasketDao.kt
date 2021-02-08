package orders.appup_kw.ivanpole.cache_bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import orders.appup_kw.ivanpole.cache_bd.entity.BasketEntity

@Dao
interface BasketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogEntity: BasketEntity): Long

    @Query("DELETE FROM BasketEntity WHERE id = :userId")
    suspend fun deleteByUserId(userId: Long)

    //UPDATE law SET term=term+12 WHERE lawnumber=37;
    @Query("UPDATE BasketEntity SET amount = :amount WHERE id = :userId")
    suspend fun updateAmountByUserId(userId: Long, amount: Int)

    @Query("SELECT * FROM BasketEntity WHERE id = :userId")
    suspend fun getById(userId: Long): List<BasketEntity>

    @Query("DELETE FROM BasketEntity")
    fun deleteAll()
}