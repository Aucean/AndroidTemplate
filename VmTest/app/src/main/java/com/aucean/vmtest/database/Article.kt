package com.aucean.vmtest.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.aucean.vmtest.mvvm.dataprovider.ArticleDetailRawDataModel
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.content.Context
import com.aucean.vmtest.TestApplication


@Dao
public interface Article {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(vararg article: ArticleDetailRawDataModel)

    @Query("SELECT * FROM articles where postId = :postId")
    fun loadArticle(postId: Int): Array<ArticleDetailRawDataModel>

}

@Database(entities = [ArticleDetailRawDataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        val db: AppDatabase by lazy {
             Room.databaseBuilder(TestApplication.appContext,
                    AppDatabase::class.java, "article.db").build()
        }
//        private val lock = Object()
//        @JvmStatic fun getDataBase(): AppDatabase {
//            synchronized(lock, {
//                if (!this::db.isInitialized) {
//                    db = Room.databaseBuilder(TestApplication.appContext,
//                            AppDatabase::class.java, "article.db").build()
//                }
//            })
//            return db
//        }
    }
    abstract fun articleDao(): Article
}


