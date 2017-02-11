package com.example.ilovezappos.zappos.Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.ilovezappos.zappos.R;
import com.example.ilovezappos.zappos.model.List_item;

import java.util.List;

/**
 * Created by Amritansh on 2/9/2017.
 */

public class Resultadapter extends RecyclerView.Adapter<Resultadapter.ResultHolder> {
    private List<List_item> mProductList;
    private LayoutInflater inflater;

    public Resultadapter(List<List_item> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.mProductList = listData;
    }

    @Override
    public Resultadapter.ResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_search__results, parent, false);
        return new ResultHolder(view);
    }

    @Override
    public void onBindViewHolder(Resultadapter.ResultHolder holder, int position) {
        List_item item =  mProductList.get(position);

        holder.brandName.setText(item.getBrandName());
        holder.price.setText(item.getPrice());
        holder.productName.setText(item.getProductName());
        //holder.productImage.setImageResource(item.getImageUrl(), mIm);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    class ResultHolder extends RecyclerView.ViewHolder {

        private TextView txt_price;
        private ImageView productImage;
        private TextView productName;
        private TextView brandName;
        private TextView price;
        private RatingBar rating;
        private View container;

        public ResultHolder(View itemView) {
            super(itemView);

            productImage = (ImageView)itemView.findViewById(R.id.thumbnail);
            productName = (TextView)itemView.findViewById(R.id.txt_product_name);
            brandName =(TextView) itemView.findViewById(R.id.txt_brand_name);
            price=(TextView)  itemView.findViewById(R.id.txt_price);

        }
    }
}

