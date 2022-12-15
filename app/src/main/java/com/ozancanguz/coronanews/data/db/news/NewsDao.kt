package com.ozancanguz.coronanews.data.db.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsDao {


    // list from db
    @Query("select * from news_table order by id asc")
    fun listNews(): Flow<List<NewsEntity>>

    // insert db
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertNews(newsEntity: NewsEntity)


}