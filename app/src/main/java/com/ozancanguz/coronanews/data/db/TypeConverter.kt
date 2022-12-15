package com.ozancanguz.coronanews.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.coronanews.data.model.CoronaNews

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
}