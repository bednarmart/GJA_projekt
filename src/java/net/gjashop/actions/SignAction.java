/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gjashop.actions;


import net.gjashop.custom.OperationProvider;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.entities.Sign;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lacoret
 */
public class SignAction extends ActionSupport{
    private static final long serialVersionUID = 9149826260758390091L;
    private Sign sign;
    private List<Sign> signList;
    private Long id;
    
    private OperationProvider operationProviderBase;
 
    public SignAction() {
        
    }
 
    public String execute() {
        operationProviderBase = new OperationProvider(HibernateUtil.getSessionFactory().openSession());
        this.signList = operationProviderBase.getAllSigns();
        System.out.println("execute called");
        return SUCCESS;
    }
    
    
    public String add() {
        operationProviderBase = new OperationProvider(HibernateUtil.getSessionFactory().openSession());
        System.out.println(this.sign.getName());
        try {
            
            
            
            //operationProviderBase.createSign(this.sign.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //this.signList = operationProviderBase.getAllSigns();
        return SUCCESS;
    }
    
    public String delete() {
        //operationProviderBase.delete(operationProviderBase.getSign((int) getId()));
        return SUCCESS;
    }
 
    public Sign getSign() {
        return sign;
    }
    
    public void setSign(Sign sign){
        this.sign = sign;
    }
 
    public List<Sign> getSignList() {
        return signList;
    }
    
    public long getId() {
        return id;
    }
     public void setId(Long id) {
        this.id = id;
    }

}
