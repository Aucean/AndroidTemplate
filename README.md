# 如何使用

- 使用这两个模板创建Activity/Fragment时名字不需要包含Activity/Fragment后缀（会自动添加）<br/>
  e.g<br/>
	要创建PostDetailActivity时，只需在弹出的对话框中填入PostDetail, <br/>
	点击Finish后会创建PostDetailActivity,IPostDetailUI,PostDetailPresent三个文件<br/>

- 注意！！！需要在项目的跟目录（如示例中的com.aucean.vmtest)而不是activity目录上使用该模板！！！

# 说明
- 本模板的核心思想是把页面结构规划为
    View(Activity/Fragment) -> ViewModel -> IDataProvider -> NetworkDataProvider <br/>
    关于在ViewModel和DataProvider之间加入一个IDataProvider 的抽象层的原因请参考示例VmTest 中的ArticleDetailDataProvider的说明<br/>
    ViewModel作为一个数据holder, 并不是必须，它存在的意义在于减少由于配置改变而导致View重写创建时的数据重新获取，从而减少白屏时间
