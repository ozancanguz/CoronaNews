package com.ozancanguz.coronanews.data.local

import com.ozancanguz.coronanews.data.db.favorites.FavoritesEntity
import com.ozancanguz.coronanews.data.db.news.NewsDao
import com.ozancanguz.coronanews.data.db.news.NewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class LocalDataSource@Inject constructor(private val newsDao: NewsDao){

    // get and list all data
    fun listNews(): Flow<List<NewsEntity>> {
        return newsDao.listNews()
    }

    // insert news
    suspend fun insertNews(newsEntity: NewsEntity){
        return newsDao.insertNews(newsEntity)
    }


    // get and list fav news
    fun readFavoriteNews():Flow<List<FavoritesEntity>>{
      return   newsDao.readFavoriteNews()
    }

    suspend fun insertFavorites(favoritesEntity: FavoritesEntity){
        return newsDao.insertFavorites(favoritesEntity)
    }




}