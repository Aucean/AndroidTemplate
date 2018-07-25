package com.aucean.vmtest.activity

import android.app.ActivityOptions
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import com.aucean.vmtest.databinding.ActivityMainBinding
import android.os.Bundle
import com.aucean.vmtest.R
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.aucean.vmtest.adapter.CommonRecyclerViewAdapter
import com.aucean.vmtest.mvvm.bindingmodel.VmTemplateExampleBindingModel
import com.aucean.vmtest.mvvm.bindingmodel.VmTemplateExampleBindingModelItem
import com.aucean.vmtest.mvvm.viewmodel.VmTemplateExampleViewModel
import android.util.Pair


/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
class MainActivity : AppCompatActivity() {


    internal lateinit var mBinding: ActivityMainBinding

    val articleList = ArrayList<VmTemplateExampleBindingModelItem>()
    val mArticleAdapter = CommonRecyclerViewAdapter<VmTemplateExampleBindingModelItem>(this, articleList, R.layout.layout_artile_item)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mBinding.articleList.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        mArticleAdapter.setOnItemClickListener(object : CommonRecyclerViewAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val intent = Intent(this@MainActivity, ArticleDetailActivity::class.java)
                intent.putExtra(ArticleDetailActivity.POST_ID, articleList[position].postId)
                intent.putExtra(ArticleDetailActivity.IMAGE_URL, articleList[position].imgUrl)
                val shareElement = v.findViewById<View>(R.id.picture)
                val shareTitle = v.findViewById<View>(R.id.title)
//                val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity,
//                        Pair.create(shareElement, "covertImg"),
//                        Pair.create(shareTitle, "title"))

                val options = ActivityOptions
                        .makeSceneTransitionAnimation(this@MainActivity, shareElement, "covertImg")
                startActivity(intent, options.toBundle())
            }

            override fun onLongClick(v: View, position: Int): Boolean {
                return false
            }
        })
        mBinding.articleList.setAdapter(mArticleAdapter)

        val viewModel = ViewModelProviders.of(this).get(VmTemplateExampleViewModel::class.java)

        mBinding.layoutRefresh.setOnRefreshListener {
            viewModel.refreshData()
        }

        viewModel.bindingModel.observe(this, object : Observer<VmTemplateExampleBindingModel>{
            override fun onChanged(t: VmTemplateExampleBindingModel?) {
                t?.run {
                    articleList.clear()
                    articleList.addAll(t)
                    mArticleAdapter.notifyDataSetChanged()
                }
                mBinding.layoutRefresh.isRefreshing = false
            }
        })


        // 获取数据
        // e.g.
         viewModel.getData()
    }
}