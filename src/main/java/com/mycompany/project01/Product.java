/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project01;

/**
 *
 * @author hp
 */
public class Product {

    private String pCode, pName;
    private int pPrice;

    public Product() {
    }

    public Product(String pCode, String pName, int pPrice) {
        this.pCode = pCode;
        this.pName = pName;
        this.pPrice = pPrice;
    }

    public String getpCode() {
        return pCode;
    }

    public String getpName() {
        return pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }
}
