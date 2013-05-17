/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gjashop.custom;

import net.gjashop.entities.Product;

/**
 *
 * @author Radim
 */
public class CartItem {
    private Product product;
    private int count;
    private int price;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
        this.price = (int) (product.getPrice() * count);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        System.out.println("CartItem->setCount(Int)");
        this.price = (int) (product.getPrice() * count);
        this.count = count;
    }

    public void setCount(String count) {
        System.out.println("CartItem->setCount(String)");
        this.price = (int) (product.getPrice() * Integer.valueOf(count));
        this.count = Integer.valueOf(count);
    }    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
