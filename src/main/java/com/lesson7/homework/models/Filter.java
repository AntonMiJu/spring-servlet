package com.lesson7.homework.models;

public class Filter {
    private Category category;
    private String city;
    private String keyWord;

    public Category getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
