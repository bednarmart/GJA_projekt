package net.gjashop.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.custom.OperationProvider;
import net.gjashop.entities.Address;
import net.gjashop.entities.User;

/**
 * <code>Správa akcí při práci s uživatelem</code>
 */
public class UserAction extends ActionSupport {

    private String login;
    private String pass;
    private String pass2;
    private User user;
    private Address address;
    private List<Address> addressList;
    private Integer addressIdToDelete;
    private OperationProvider dbProvider  = new OperationProvider(HibernateUtil.getSessionFactory().openSession());
    
    @Override
    public String execute() throws Exception {
        // vykonání příkazů, které se mají stát po zavolání
        return SUCCESS;
    }
    
    public String doLogin() throws Exception {
        boolean errIn = false;
        if (isInvalid(login)) {
            addActionError("Chybí login");
            errIn = true;
        }
        if (isInvalid(pass)) {
            addActionError("Chybí heslo");
            errIn = true;
        }
        if (errIn) return INPUT;

        List<User> users = null;
        users = dbProvider.getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                this.user = user;
            }
        }

        if (this.user == null) {
            addActionError("Neevidovaný uživatel");
            return ERROR;
        }
        
        if (!pass.equals(user.getPass())){
            addActionError("Špatné uživatelské jméno nebo heslo");
            return ERROR;
            
        } else {
            Map session = ActionContext.getContext().getSession();
            session.put("login", "true");
            session.put("user", user);
            return SUCCESS;
        }
    }

    public String showLogin() {
        System.out.println("show_login");
        return SUCCESS;
    }

    public String logout() {
        System.out.println("logout");
        Map session = ActionContext.getContext().getSession();
        session.remove("login");
        session.remove("user");
        session.remove("cart");
        return SUCCESS;
    }
    
    public String createUser () throws Exception
    {
        boolean errIn = false;
        if (isInvalid(user.getSurname())) {
            addActionError("Chybí příjmení");
            errIn = true;
        }
        if (isInvalid(user.getName())) {
            addActionError("Chybí jméno");
            errIn = true;
        }
        if (isInvalid(user.getLogin())) {
            addActionError("Chybí login");
            errIn = true;
        }
        if (isInvalid(user.getPass())) {
            addActionError("Chybí heslo");
            errIn = true;
        }
        if (! user.getPass().equals(pass2)) {
            addActionError("Hesla se neshodují");
            errIn = true;
        }
        
        for(User tmpUser: dbProvider.getAllUsers()){
            if(tmpUser.getLogin().equals(user.getLogin())){
                addActionError("Uživatel s loginem "+ user.getLogin() +".");
                errIn = true;
            }
        }
        
        if (errIn) return INPUT;
        
        try{
            dbProvider.getSession().clear();
            dbProvider.getSession().beginTransaction();
            
            dbProvider.createUser(user.getName(),
                                  user.getSurname(),
                                  user.getLogin(),
                                  user.getPass(),
                                  0);
            dbProvider.getSession().getTransaction().commit();
        }
        
        catch(Exception e){
           System.out.println(e);    
           addActionError("Problem s databazi");
           return INPUT;
        }
        
        this.login = user.getLogin();
        this.pass = user.getPass();
        
        return this.doLogin();
    }
    
    public String deleteUserAddress()
    {
      return SUCCESS;
    }
    public String addUserAdress()
    {
      return SUCCESS;
    }
    
    private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
    }
    // TODO: modely - contact, address
    
    
    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public User getUser() {
        return user;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPass2() {
        return pass2;
    }
    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Integer getAddressIdToDelete() {
        return addressIdToDelete;
    }

    public void setAddressIdToDelete(Integer addressIdToDelete) {
        this.addressIdToDelete = addressIdToDelete;
    }
        
}

