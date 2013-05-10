/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gjashop.actions;

import com.opensymphony.xwork2.ActionSupport;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.custom.OperationProvider;

/**
 *
 * @author lacoret
 */
public class ShoppingAction extends ActionSupport{
    private OperationProvider dbProvider = new OperationProvider(HibernateUtil.getSessionFactory().openSession());
    
    public ShoppingAction(){
    }
    
    public String getProducts(){
        return SUCCESS;
    }
    public String showProducts(){
            return SUCCESS;
    }
    public String addToCart(){
        return SUCCESS;
    }
    public String updateInCart(){
            return SUCCESS;
    }
    public String removeFromCart(){
         return SUCCESS;
    }
    public String emptyCart(){
         return SUCCESS;
    }
    public String createOrder(){
        return SUCCESS;
    }
    public String showPaymentType(){
            return SUCCESS;
    }
    public String showDeliveres(){
          return SUCCESS;
    }
    public String addRating(){
             return SUCCESS;
    }
}
