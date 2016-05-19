package com.bq2015.tagflowlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bq2015.tagflowlayout.view.FlowTagLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  // @BindView(R.id.activity_ftl)
    FlowTagLayout mFlowTagLayout;
    List<String> mlist = new ArrayList<>();
    private TagAdapter mTagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);
        mFlowTagLayout = (FlowTagLayout) findViewById(R.id.activity_ftl);
        mFlowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_MULTI);
        for (int i = 0; i < 10; i++) {
            mlist.add("标签" + i);

        }
        mTagAdapter = new TagAdapter();
        mFlowTagLayout.setAdapter(mTagAdapter);
        mTagAdapter.notifyDataSetChanged();

       // mFlowTagLayout.setClickable(true);

        mFlowTagLayout.setOnTagSelectListener(new FlowTagLayout.OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                Toast.makeText(MainActivity.this, selectedList.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class TagAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mlist != null ? mlist.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(MainActivity.this, R.layout.lab, null);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.lab_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tv.setText(mlist.get(position));
            return convertView;
        }



        private  class ViewHolder {
            TextView tv;
        }
    }


}
