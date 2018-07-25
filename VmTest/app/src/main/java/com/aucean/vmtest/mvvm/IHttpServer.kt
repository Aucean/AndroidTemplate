package com.aucean.vmtest.mvvm

import com.aucean.vmtest.mvvm.dataprovider.ArticleDetailRawDataModel
import com.aucean.vmtest.mvvm.dataprovider.VmTemplateExampleRawDataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IHttpServer {
    @GET("api/group/depth")
    fun getArticleList(@Query("timestamp") timestamp: Long?, @Query("count") count: Int?)
        : Observable<ResponseModel<VmTemplateExampleRawDataModel>>

    @GET("api/post/{postId}")
    fun getArticleDetail(@Path("postId") postId: Int) : Observable<ResponseModel<ArticleDetailRawDataModel>>
}