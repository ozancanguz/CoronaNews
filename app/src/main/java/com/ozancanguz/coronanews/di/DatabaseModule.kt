package com.ozancanguz.coronanews.di

import android.content.Context
import androidx.room.Room
import com.ozancanguz.coronanews.data.db.news.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NewsDatabase::class.java,
        "news_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: NewsDatabase) = database.newsDao()

}
