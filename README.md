# TagflowLaout #

## 在布局中引用 ##
  
        <com.bq2015.tagflowlayout.view.FlowTagLayout
        android:id="@+id/activity_ftl"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
## 设定选择类型 ##
> - FLOW_TAG_CHECKED_NONE 不选择
> - FLOW_TAG_CHECKED_SINGLE 单选
> - FLOW_TAG_CHECKED_MULTI  多选

    mFlowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_MULTI);


>1.选中时回调


     mFlowTagLayout.setOnTagSelectListener(new FlowTagLayout.OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                Toast.makeText(MainActivity.this, selectedList.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    
>2.设置点击事件

    	mFlowTagLayout.setOnTagClickListener(new OnTagClickListener(){
			......
		});
    
    
## 绑定数据 ##
>自定义Adapter继承BaseAdapter    
>mFlowTagLayout.setAdapter(mTagAdapter);