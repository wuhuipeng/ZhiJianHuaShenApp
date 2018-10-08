package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchWordsActivity extends AppCompatActivity {
    @BindView( R.id.search_button)
    public Button searchButton;
    @BindView(R.id.search_view)
    public SearchView searchView;
    private  String  keyword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);//接受消息界面

       initView();
    }

    public void initView(){
        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());
        ButterKnife.bind(this);
        /**
         * 设置搜索按钮点击事件
         */

        /**
         * 设置搜索框按钮监听事件
         */
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword = searchView.getQuery().toString();
                if (keyword.isEmpty()) {
                    Toast toast=Toast.makeText(getApplicationContext(), "您未输入宝贝名称欧"+keyword, Toast.LENGTH_SHORT);

                    toast.show();
                } else  {

                    Intent intent =new Intent(SearchWordsActivity.this,SearchSortActivity.class);



                    intent.putExtra("name", keyword);

                    startActivity(intent);

                }


            }
        });
        /**
         * 设置搜索框文本框文本改变事件
         */
          searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.isEmpty()){
                    Toast toast=Toast.makeText(getApplicationContext(), "您未输入宝贝名称欧", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Intent intent =new Intent(SearchWordsActivity.this,SearchSortActivity.class);

                    intent.putExtra("name", query);

                    startActivity(intent);
                }
                return true;
            }
            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){

                    //mListView.setFilterText(newText);
                }else{
                    //mListView.clearTextFilter();
                }
                return false;
            }
        });

    }
}
