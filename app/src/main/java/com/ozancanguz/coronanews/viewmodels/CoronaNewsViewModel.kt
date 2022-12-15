package com.ozancanguz.coronanews.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.ozancanguz.coronanews.data.Repository
import com.ozancanguz.coronanews.data.db.news.NewsEntity
import com.ozancanguz.coronanews.data.model.CoronaNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoronaNewsViewModel@Inject constructor(private val repository: Repository, application: Application)
    :AndroidViewModel(application){


    //    ------for retrofit-----------
        var coronaNewsList=MutableLiveData<CoronaNews>()
         var job: Job?=null


    //                 -------for room-------

    var newsList:LiveData<List<NewsEntity>> = repository.local.listNews().asLiveData()


    fun insertNews(newsEntity: NewsEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.local.insertNews(newsEntity)
        }

    }


    // offline caching fun
    private fun offlineCacheCartoons(coronaNews: CoronaNews) {
        val newsEntity = NewsEntity(coronaNews)
        insertNews(newsEntity)
    }



    //              ------------ for retrofit----------

           fun requestApiData(){
               job= CoroutineScope(Dispatchers.IO).launch {
                   val response=repository.remote.getAllNews()
                   if(response.isSuccessful){
                       coronaNewsList.postValue(response.body())

                        val coronanews=coronaNewsList.value!!
                        offlineCacheCartoons(coronanews)

                   }else{
                       Log.d("viewmodel","data not found")
                   }
               }
           }










}