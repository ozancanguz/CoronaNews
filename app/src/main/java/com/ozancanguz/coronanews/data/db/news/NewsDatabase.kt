package com.ozancanguz.coronanews.data.db.news

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [NewsEntity::class],
    version = 1,
     exportSchema = false,
    )

@TypeConverters(TypeConverter::class)
abstract class NewsDatabase:RoomDatabase() {

    abstract fun newsDao(): NewsDao

}