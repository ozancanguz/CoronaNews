package com.ozancanguz.coronanews.data.db.news

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.coronanews.data.model.CoronaNews
import com.ozancanguz.coronanews.data.model.Result

class TypeConverter {


    var gson = Gson()

    @TypeConverter
    fun NewsToString(coronaNews: CoronaNews): String {
        return gson.toJson(coronaNews)
    }

    @TypeConverter
    fun stringToNews(data: String): CoronaNews {
        val listType = object : TypeToken<CoronaNews>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun resultToString(result: Result):String{
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data:String):Result{
        val listType=object : TypeToken <Result>(){
        }.type
        return gson.fromJson(data,listType)
    }

}