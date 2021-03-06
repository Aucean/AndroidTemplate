<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="bindingModel"
            type="android.arch.lifecycle.LiveData&lt;${packageName}.mvvm.bindingmodel.${className}BindingModel&gt;"/>
    </data>
    <LinearLayout
        android:id="@+id/coordinator_layout"
        android:fitsSystemWindows="true"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.activity.${className}Activity">
        <android.support.v7.widget.Toolbar
            android:id="@+id/tool_bar"
            android:layout_width="match_parent"
            android:layout_height="39dp">
        </android.support.v7.widget.Toolbar>
        <RelativeLayout
            android:id="@+id/layout_content"
            android:layout_width="match_parent"
            android:layout_height="match_parent" >
        </RelativeLayout>

    </LinearLayout>
</layout>