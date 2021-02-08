package orders.appup_kw.ivanpole.cache_bd.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class BasketEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int,

    var amount: Int,

    var name: String,

    var image: String,

    var cost: Float

)