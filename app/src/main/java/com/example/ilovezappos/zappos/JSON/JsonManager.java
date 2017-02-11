package com.example.ilovezappos.zappos.JSON;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ilovezappos.zappos.model.List_item;

import java.util.ArrayList;

/**
 * Created by Amritansh on 2/10/2017.
 */

public class JsonManager {



    private static final String TAG = "ILoveZappos-" + JsonManager.class.getSimpleName();

    // JSON Node names for Product
    private static final String RESULTS = "results";
    private static final String BRAND_NAME = "brandName";
    private static final String PRICE = "price";
    private static final String IMAGE_URL = "thumbnailImageUrl";
    private static final String PRODUCT_NAME = "productName";

    /**
     * Get products information from json string response.
     *
     * @return List of products, ArrayList<Product>
     */
    public ArrayList<List_item> getProducts(final String response) {
        // 1. build product's ArrayList


        final ArrayList<List_item> productList = new ArrayList<List_item>();
        try {
            // 2. build jsonObject of response

            final JSONObject jsonObject = new JSONObject(response);
            // 3. build jsonArray
            final JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                // 4. parse one by one attribute from json.
                final JSONObject object = jsonArray.getJSONObject(i);

                final String brandName = object.optString(BRAND_NAME);
                final String price = object.optString(PRICE);
                final String imageUrl = object.optString(IMAGE_URL);
                //final String asin = object.optString(ASIN);
                final String productName = object.optString(PRODUCT_NAME);
                //final String rating = object.optString(RATING);
                // 5. build product object from data
                final List_item product = new List_item();
                product.setBrandName(brandName);
                product.setPrice(price);
                product.setImageUrl(imageUrl);

                product.setProductName(productName);
                productList.add(product);

            }
        } catch (final JSONException e) {
            Log.e(TAG, "JSONException in getProducts(): " + e.getMessage(), e);
        }
        return productList;
    }

    /**
     * Get product details from json string response.
     *
     * @return products detail object, Product
     */
    public List_item getProductDetail(String response) {
        final List_item product = new List_item();
        try {
            final JSONObject jsonObject = new JSONObject(response);
            product.setProductName(jsonObject.optString(PRODUCT_NAME));
            product.setBrandName(jsonObject.optString(BRAND_NAME));

        } catch (JSONException e) {
            Log.e(TAG, "JSONException in getProductDetail(): " + e.getMessage(), e);
        }
        return product;
    }
}
