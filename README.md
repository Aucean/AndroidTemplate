- 把MVPActivityTemplate和MVPFragmentTemplate放到AndroidStudio安装目录下的plugins\android\lib\templates\activities<br/>
  然后重启AndroidStudio

- 使用这两个模板创建Activity/Fragment时名字不需要包含Activity/Fragment后缀（会自动添加）<br/>
  e.g<br/>
	要创建PostDetailActivity时，只需在弹出的对话框中填入PostDetail, <br/>
	点击Finish后会创建PostDetailActivity,IPostDetailUI,PostDetailPresent三个文件<br/>

- 注意！！！需要在项目的跟目录（com.gelonghui.glhapp)而不是activity目录上使用该模板！！！
