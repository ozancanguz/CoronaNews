package com.ozancanguz.coronanews.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.coronanews.data.model.CoronaNews

@Entity(tableName = "news_table")
class NewsEntity(

    var coronaNews: CoronaNews
) {
    @PrimaryKey(autoGenerate = false)
    var id:Int=0

}