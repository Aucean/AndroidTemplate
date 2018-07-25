package com.aucean.vmtest.mvvm.dataprovider

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.util.Log
import com.aucean.vmtest.database.AppDatabase
import com.aucean.vmtest.mvvm.*
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Generated by MVVMActivityTemplate
 */
/**
 * 封装多一层ArticleDetailDataProvider, 并把具体实现委托给ArticleDetailNetWorkDataProvider，而不是直接使
 * 用ArticleDetailNetWorkDataProvider的原因在于，把获取数据的细节对ViewModel隐藏起来，从而提高解耦
 *
 * 例如，现在有个需求，需要展示一些数据，为了减少等待数据从服务器加载过程中的空白时间，现在需要先
 * 从数据库中获取缓存先显示，然后再从网络加载数据显示
 *
 * ViewModel 不需要知道这些细节，ViewModel 只需负责接收到数据，然后把数据更新到界面上
 * 这些细节的具体实现应该在DataProvider中
 *
 * 为了实现这需求，现在我们可以在VmExampleDataProvider中重写getData
 *
 *    override fun getData(params: (VmExampleApiParams) -> Unit): Observable<Optional<VmExampleRawDataModel>> {
 *        return Observable.merge(Observable.create { emitter ->
 *            emitter.onNext(Optional.empty() 假装在从数据库中加载数据并返回)
 *            emitter.onComplete()
 *        }, provider.getData(params))
 *    }
 * 把数据缓存放在DataProvider 而不是直接通过HttpClient实现，是因为有时候我们不需要所有的网络请求都缓存，需要根据
 * 业务需要选择性缓存
 */
class ArticleDetailDataProvider
    : BaseDataProviderWithCache<ArticleDetailApiParams, ArticleDetailRawDataModel>(ArticleDetailNetWorkDataProvider()) {

    companion object {
        private const val LOG_TAG = "ArticleDataProvider"
    }

    protected class ArticleDetailNetWorkDataProvider : BaseNetworkProvider<ArticleDetailApiParams, ArticleDetailRawDataModel>() {
        override fun getDataFromNetwork(params: ArticleDetailApiParams): Observable<ResponseModel<ArticleDetailRawDataModel>> {
            /* e.g.
             *      return HttpHelper.getServer().getExampleData(params.stockType, params.stockCode)
            */
            return HttpHelper.getServer().getArticleDetail(params.postId)
        }
    }

    override fun getCacheData(param: ArticleDetailApiParams): Optional<ArticleDetailRawDataModel> {
        val cache = AppDatabase.db.articleDao().loadArticle(param.postId)
        if (cache != null && !cache.isEmpty()) {
            Log.i(LOG_TAG, "return cached article[postId = ${param.postId}]: ${cache[0]}" )
            return OptionalImpl(cache[0])
        } else {
            return OptionalImpl()
        }
    }

    override fun saveData(param: ArticleDetailApiParams, data: ArticleDetailRawDataModel) {
        Log.i(LOG_TAG, "store article for ${data.postId}")
        AppDatabase.db.articleDao().insertArticle(data)
    }
}

class ArticleDetailApiParams(var postId: Int)
/**
 * Api 返回数据Bean对象(网络层数据Bean)
 */
@Entity(tableName = "articles")
class ArticleDetailRawDataModel(@PrimaryKey val postId: Int,
    val type: Int,
    val title: String,
    val content: String,
    val createDate: Int,
    val userId: Int,
    val nickname: String,
    val avatar: String,
    val summary: String,
    val coverImageUrl: String
)