package com.example.ilovezappos.zappos.model;

/**
 * Created by Amritansh on 2/9/2017.
 */

public class List_item {
    private String brandName;
    private String price;
    private String imageUrl;
    private String asin;
    private String productName;
    private String rating;
    private String description;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultProductUrl() {
        return defaultProductUrl;
    }

    public void setDefaultProductUrl(String defaultProductUrl) {
        this.defaultProductUrl = defaultProductUrl;
    }

    private String defaultProductUrl;
}
