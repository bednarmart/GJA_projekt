/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gjashop.actions;


import net.gjashop.custom.OperationProvider;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import net.gjashop.entities.Sign;
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
        operationProviderBase = new OperationProvider(new Configuration().configure().buildSessionFactory().openSession());
    }
 
    public String execute() {
        this.signList = operationProviderBase.getAllSigns();
        System.out.println("execute called");
        return SUCCESS;
    }
    
    
    public String add() {
        System.out.println(getSign());
        try {
            operationProviderBase.createSign(getSign().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.signList = operationProviderBase.getAllSigns();
        return SUCCESS;
    }
    
    public String delete() {
        operationProviderBase.delete(operationProviderBase.getSign((int) getId()));
        return SUCCESS;
    }
 
    public Sign getSign() {
        return sign;
    }
 
    public List<Sign> getSignList() {
        return signList;
    }
    
    public long getId() {
        return id;
    }

}
