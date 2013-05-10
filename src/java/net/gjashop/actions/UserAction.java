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
public class UserAction extends ActionSupport{
    

    private OperationProvider dbProvider = new OperationProvider(HibernateUtil.getSessionFactory().openSession());
    
    public UserAction(){}
    
    public String doLogin(){
        
        return SUCCESS;    
    }
    public String doRegistration(){
        return SUCCESS;
    }
    public String addAddress(){
        return SUCCESS;
    }
    public String updateAddress(){
        return SUCCESS;
    }
    public String showAddress(){
        return SUCCESS;
    }
    public String removeAddress(){
        return SUCCESS;
    }
    
    public String addContact(){
        return SUCCESS;
    }
    public String updateContact(){
        return SUCCESS;
    }
    public String showContact(){
        return SUCCESS;
    }
    public String removeContact(){
        return SUCCESS;
    }
    
}
