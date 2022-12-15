package com.ozancanguz.coronanews.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.coronanews.data.Repository
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

        var coronaNewsList=MutableLiveData<CoronaNews>()
         var job: Job?=null


           fun requestApiData(){
               job= CoroutineScope(Dispatchers.IO).launch {
                   val response=repository.remote.getAllNews()
                   if(response.isSuccessful){
                       coronaNewsList.postValue(response.body())
                   }else{
                       Log.d("viewmodel","data not found")
                   }
               }
           }










}