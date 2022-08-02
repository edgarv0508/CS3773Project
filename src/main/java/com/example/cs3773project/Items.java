package com.example.cs3773project;

public class Items {
    public String item;
    public String price;
    public String amount;

    public Items(String item, String price, String amount){
        this.item = item;
        this.price = price;
        this.amount = amount;
    }


    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getAmount(){
        return amount;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

}
