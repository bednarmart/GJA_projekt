package net.gjashop.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.custom.OperationProvider;
import net.gjashop.entities.Category;
import net.gjashop.entities.Product;
import net.gjashop.entities.Segment;

/**
 * <code>Správa akcí při nakupování</code>
 */
public class ShoppingAction extends ActionSupport {
    private OperationProvider dbProvider = new OperationProvider(HibernateUtil.getSessionFactory().openSession());

    private String name;
    
    private static final long serialVersionUID = 9149826260758390091L;
    private List<Category> categoriList;
    private List<Segment> subCategoriList;
    private Category category;
    private Segment subCategory; 
//    private String categoriList;
    private Long cat;
    private Long subcat;
    private Long selectedProduct;
    
    private Product product;
    
    
    @Override
    public String execute() throws Exception {
        // vykonání příkazů, které se mají stát po zavolání
        System.out.println("execute called get all Category" );
        System.out.println("cat:" + this.cat );
        System.out.println("subcat:" + this.subcat );
/*        this.categoriList = new ArrayList<String>();
        this.categoriList.add("neco0");
        this.categoriList.add("neco1");
        this.categoriList.add("neco2");*/
        
        // zmacknuta kategorie
        if (cat != null){
            this.subCategoriList = dbProvider.getSegmentsByCategory(dbProvider.getCategory(cat.intValue()));
            System.out.println("velikost: " + subCategoriList.size());
        }

        this.categoriList = dbProvider.getAllCategorys();
//        this.subCategoriList = dbProvider.getAllSegments();
        return SUCCESS;
    }

    
    public String productDetail (){
        this.selectedProduct = Long.valueOf(1);
        product = dbProvider.getProduct(this.selectedProduct.intValue());
        System.out.println("productDetail called" + product.getName());
        return SUCCESS;
    }
    
    public String getname (){
        System.out.println("getname called" );
        return name;
    }
    
    public List<Category> getCategoriList(){
        System.out.println("getcategoriList called ");
        return categoriList;
    }
    public String setCategoriList(List<Category> cl){
        this.categoriList = cl;
        return SUCCESS;
    }
    public List<Segment> getSubCategoriList(){
        System.out.println("getSubcategoriList called ");
        return subCategoriList;
    }
    public String setSubCategoriList(List<Segment> cl){
        this.subCategoriList = cl;
        return SUCCESS;
    }
    public String setCategory( Category cat ){
        this.category = cat;
        return SUCCESS;
    }
    public Category getCategory(){
       return this.category;
    }
    public void setCat(Long id){
        System.out.println("setCat called"); 
        this.cat = id;
    }
    public Long getCat(){
        System.out.println("getCat called"); 
        return this.cat;
    }
    public void setSubcat(Long id){
        System.out.println("setSubcat called"); 
        this.subcat = id;
    }
    public Long getSubcat(){
        System.out.println("getSubcat called"); 
        return this.subcat;
    }
    
    // TODO: modely - user, cart
    
    
    // TODO: gettery, settery
    
    
    
    public ShoppingAction(){
        System.out.println("ShoppingAction called"); 
        System.out.println(this.cat );
        System.out.println(this.subcat );
    }
    
    public String getProducts(){
                System.out.println("getProducts called");  
        return SUCCESS;
    }
    public String showProducts(){
                System.out.println("showProducts called");  
            return SUCCESS;
    }
    public String addToCart(){
                System.out.println("addToCart called");  
        return SUCCESS;
    }
    public String updateInCart(){
                System.out.println("updateInCart called");  
            return SUCCESS;
    }
    public String removeFromCart(){
                System.out.println("removeFromCart called");  
         return SUCCESS;
    }
    public String emptyCart(){
                System.out.println("emptyCart called");  
         return SUCCESS;
    }
    public String createOrder(){
                System.out.println("createOrder called");  
        return SUCCESS;
    }
    public String showPaymentType(){
                System.out.println("showPaymentType called");  
            return SUCCESS;
    }
    public String showDeliveres(){
                System.out.println("showDeliveres called");  
          return SUCCESS;
    }
    public String addRating(){
                System.out.println("addRating called");  
             return SUCCESS;
    }
}

