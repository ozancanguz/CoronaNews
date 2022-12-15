package com.ozancanguz.coronanews.data.db.favorites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.coronanews.data.model.Result


@Entity(tableName = "favorites_table")
class FavoritesEntity(
    @PrimaryKey(autoGenerate =true)
    var id:Int=0,
    var result:Result

) {
}