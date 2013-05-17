package net.gjashop.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.gjashop.custom.CartItem;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.custom.OperationProvider;
import net.gjashop.entities.Category;
import net.gjashop.entities.Picture;
import net.gjashop.entities.Product;
import net.gjashop.entities.Rating;
import net.gjashop.entities.Segment;
import net.gjashop.entities.User;

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
    private int selectedProduct;
    
    private Product product;
    private List<CartItem> cart = null;
    private int iProduct;
    private int productCount;
    
    private int newEvaluation;
    
    private String image;
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String showCategory() {
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
        this.selectedProduct = 1;
        
        product = dbProvider.getProduct(this.selectedProduct);
        System.out.println("productDetail called" + product.getName() );
        //System.out.println("productDetail called");
        
        List<Picture> pic = dbProvider.getPicturesByProduct(this.product);
           if(pic != null && pic.size()>0)
           {
               this.image = pic.get(0).getPath();
           }
        System.out.println("productDetail called cesta: " + this.image );
        return SUCCESS;
    }
    
    public String evaluateProduct (){
        dbProvider.getSession().clear();
        
        Map session = ActionContext.getContext().getSession();
        product = dbProvider.getProduct(this.iProduct);
        Boolean founded = false;
        
        List<Rating> usersRating = dbProvider.getRatingsByUser((User) session.get("user"));
        Rating updateRating = null;
        for (Rating item : usersRating) {
            if (item.getProduct().getId() == iProduct) {
                founded = true;
                updateRating = item;
                break;
            }
        }
        dbProvider.getSession().clear();
        // update
        if (founded == true){
            System.out.println("evaluateProduct called: update");
            dbProvider.getSession().beginTransaction();   
            updateRating.setValue(newEvaluation);
            dbProvider.update(updateRating);
            dbProvider.getSession().beginTransaction().commit();                
        }
        // vkladani
        else {
        System.out.println("evaluateProduct called: " + newEvaluation);
            dbProvider.getSession().beginTransaction();   
            dbProvider.createRating((User) session.get("user"), product, newEvaluation);
            dbProvider.getSession().beginTransaction().commit();                
        }
        
        return SUCCESS;
    }

    public String getSign (){
        product = dbProvider.getProduct(this.selectedProduct);
        return product.getSign().getName();
    }
    
    public String getBLogedIn (){
        Map session = ActionContext.getContext().getSession();
        if (session.get("login").toString().equals("true") ){
            return "true";
        }
        else
            return "false";
    }
    
    public String getDeliveryTime (){
        product = dbProvider.getProduct(this.selectedProduct);
        if (product.getCount() == 0){
            
            Random generator = new Random( );
            Integer randomIndex = generator.nextInt( 20 )+2;
            return randomIndex.toString() + " dnu";
        }
        else {
            return "2 dny";
        }
    }
    
    public String getEvaluation (){
        product = dbProvider.getProduct(this.selectedProduct);
        List <Rating> ratings = dbProvider.getRatingsByProduct(product);
        
        int ratingSum = 0;
        for (Rating item : ratings) {
            ratingSum += item.getValue();
        }

        if (ratingSum == 0){
            return "Nehodnoceno";
        }
        
        Double result = (double)Math.round((double)ratingSum/ratings.size()*10)/10;
        
        return (result.toString());
    }
    
    public String getProductSex (){
        product = dbProvider.getProduct(this.selectedProduct);
        
        if (product.getSex() == 1){
            return "Muže";
        }
        else if (product.getSex() == 2){
            return "Ženy";
        }
        else {
            return "-";
        }
    }
    
    public int getNewEvaluation() {
        return newEvaluation;
    }

    public void setNewEvaluation(int newEvaluation) {
        this.newEvaluation = newEvaluation;
    }

    public int getSelectedProduct() {
        return selectedProduct;
    }

    public String getImage() {
        return image;
    }

    public Product getProduct() {
        return product;
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
    
    public String showCart() {
        Map session = ActionContext.getContext().getSession();
        cart = (List<CartItem>) session.get("cart");
        
        return SUCCESS;
    }
    
    public String addToCart() {
        System.out.println("addToCart called: " + iProduct);  
        boolean added = false;
        Map session = ActionContext.getContext().getSession();
        cart = (List<CartItem>) session.get("cart");
        
        product = dbProvider.getProduct(iProduct);
        for (CartItem item : cart) {
            if (item.getProduct().getId() == iProduct) {
                item.setCount(item.getCount() + 1);
                added = true;
            }
        }
        if (! added) {
            cart.add(new CartItem(product, 1));
        }
        
        session.put("cart", cart);
        return SUCCESS;
    }

    public String removeFromCart() {
        System.out.println("removeFromCart called");  
        Map session = ActionContext.getContext().getSession();
        cart = (List<CartItem>) session.get("cart");

        for (CartItem item : cart) {
            if (item.getProduct().getId() == iProduct) {
                cart.remove(item);
            }
        }
        
        session.remove("cart");
        return SUCCESS;
    }     
    
    public String updateInCart(){
        System.out.println("updateInCart called");  
        Map session = ActionContext.getContext().getSession();
        cart = (List<CartItem>) session.get("cart");
        
        for (CartItem item : cart) {
            if (item.getProduct().getId() == iProduct) {
                item.setCount(productCount);
            }
        }

        return SUCCESS;
    }

    public String eraseCart(){
         System.out.println("emptyCart called");  
         Map session = ActionContext.getContext().getSession();
         session.remove("cart");

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

    public void setIProduct(int iProduct) {
        this.iProduct = iProduct;
    }

    public int getIProduct() {
        return iProduct;
    }


    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }


    public String productFilter (){
        System.out.println("productFilter called");  
        return SUCCESS;
    }

    public String doFilter (){
        System.out.println("doFilter called !!!!!!!!!!!!!!!" + sexFilter);  
        return SUCCESS;
    }

    private String sexFilter;
    private List<String> sexList;
    private String signFilter;
    private List<String> signList;
    
    public List<String> getSexList() {
        sexList = new ArrayList();
        sexList.add("jedna");
        sexList.add("dva");
        return sexList;
    }

    public String getSexFilter() {
        return sexFilter;
    }

    public void setSexFilter(String sexFilter) {
        this.sexFilter = sexFilter;
    }

    public String getSignFilter() {
        return signFilter;
    }

    public void setSignFilter(String signFilter) {
        this.signFilter = signFilter;
    }

    public List<String> getSignList() {
        signList = new ArrayList();
        signList.add("tri");
        signList.add("čtyři");
        return signList;
    }

    public void setSignList(List<String> signList) {
        this.signList = signList;
    }


    
}

