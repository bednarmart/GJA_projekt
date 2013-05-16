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

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
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
        this.count = count;
    }
    
}
