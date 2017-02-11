package com.example.ilovezappos.zappos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilovezappos.zappos.Adpter.Resultadapter;
import com.example.ilovezappos.zappos.JSON.JsonManager;
import com.example.ilovezappos.zappos.model.List_item;

import org.w3c.dom.Text;

import java.util.List;

public class Search_Results extends AppCompatActivity {
    private TextView res;
    private RecyclerView mRecyclerView;
    private List<List_item> products;
    private RecyclerView.Adapter mAdapter;
    private JsonManager jm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__results);

        //data from main activity
        Intent intent =getIntent();
        String result=intent.getStringExtra("result");
        //Call json
        String t =result;

        List<List_item> p=products;
//        res=(TextView)findViewById(R.id.restext);
//        res.setText(result);


        jm= new JsonManager();
        products= jm.getProducts(result);

        //Recycle View Reference
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        mAdapter=new Resultadapter(products,this);
        recList.setAdapter(mAdapter);

        //specify adapter




    }
}
