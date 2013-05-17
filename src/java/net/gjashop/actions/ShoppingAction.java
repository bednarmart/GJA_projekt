package net.gjashop.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.gjashop.custom.CartItem;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.custom.OperationProvider;
import net.gjashop.custom.ProductInTable;
import net.gjashop.entities.Category;
import net.gjashop.entities.Picture;
import net.gjashop.entities.Product;
import net.gjashop.entities.Rating;
import net.gjashop.entities.Segment;
import net.gjashop.entities.Sign;
import net.gjashop.entities.User;

/**
 * <code>Správa akcí při nakupování</code>
 */
public class ShoppingAction extends ActionSupport {
    private OperationProvider dbProvider = new OperationProvider(HibernateUtil.getSessionFactory().openSession());

    private static final long serialVersionUID = 9149826260758390091L;
    private List<Category> categoriList;
    private List<Segment> subCategoriList;

    //    private String categoriList;
    private Long cat;
    private Long subcat;
    
    private List<Product> productList;
    private List<ProductInTable> productInTableList;

   
    private Product product;
    private List<CartItem> cart = null;
    private boolean cartActive = false;
    private int iProduct;
    private int productCount;
    
    private int newEvaluation;
    private int cartTotalPrice;
    
    private String image;
    
    private String[] cartProductCount;
    
    
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
        //this.iProduct = 4;
        
        product = dbProvider.getProduct(this.iProduct);
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
        product = dbProvider.getProduct(this.iProduct);
        return product.getSign().getName();
    }
    
    public String getDeliveryTime (){
        product = dbProvider.getProduct(this.iProduct);
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
        product = dbProvider.getProduct(this.iProduct);
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
        product = dbProvider.getProduct(this.iProduct);
        
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

    public String getImage() {
        return image;
    }

    public Product getProduct() {
        return product;
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
        List<Picture> pic  = dbProvider.getPicturesByProduct(this.product);
        if(pic != null && pic.size()>0)
        {
            this.image   = pic.get(0).getPath();
        }        
        return SUCCESS;
    }

    public String showProducts(){
                System.out.println("showProducts called");  
            return SUCCESS;
    }

    public String getCartActive() {
        System.out.println("/////getCartActive called");
        if (cartActive) {
            return "true";
        } else {
            return "false";
        }
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public int getCartTotalPrice() {
        return cartTotalPrice;
    }
    
    public String getCartItemsCount() {
        Map session = ActionContext.getContext().getSession();
        cart = (List<CartItem>) session.get("cart");
        return String.valueOf(cart.size());
    }
    
    public String cartDetail() {
        System.out.println("/////////////cartDetail called");
        if (cart == null) {
            Map session = ActionContext.getContext().getSession();
            cart = (List<CartItem>) session.get("cart");
        }
        
        cartTotalPrice = 0;
        if (cart != null) {
            for (CartItem item : cart) {
                cartTotalPrice += item.getPrice();
            }
        }
        
        return SUCCESS;
    }
    
    public String showCart() {
        System.out.println("/////////////showCart called");
        cartActive = true;
        
        return SUCCESS;
    }
    
    public String addToCart() {
        System.out.println("addToCart called: " + iProduct);  
        boolean added = false;
        Map session = ActionContext.getContext().getSession();
        cart = (List<CartItem>) session.get("cart");
        
        product = dbProvider.getProduct(iProduct);
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProduct().getId() == iProduct) {
                    item.setCount(item.getCount() + 1);
                    added = true;
                }
            }
        } else {
            cart = new ArrayList<CartItem>();
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
        List<CartItem> newCart = new ArrayList<CartItem>();

        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProduct().getId() != iProduct) {
                    newCart.add(item);
                } 
            }
        }
        session.remove("cart");
        if (newCart != null) {
            session.put("cart", newCart);
        }
        cartActive = true;
        return SUCCESS;
    }     
    
    public String updateInCart(){

        System.out.println("updateInCart called");

        Map session = ActionContext.getContext().getSession();
        /*
        cart = (List<CartItem>) session.get("cart");
        
        
        if (cart != null) {
            for (CartItem item : cart) {
                item.setCount(Integer.valueOf(cartProductCount[item.getProduct().getId()]));
            }
        }
        */
        /*
        session.remove("cart");
        if (cart != null) {
            session.put("cart", cart);
        }
        */
        cartActive = true;

        return SUCCESS;
    }

    public void setCart(List<CartItem> cart) {
        System.out.println("setCart called");
       
        if (cart != null) {
            for (CartItem item : cart) {
                System.out.println("item - prodname:" + item.getProduct().getName());
                System.out.println("item - count:" + item.getCount());
            }
        }
        System.out.println("setCart called - end");
        
        /* pokus  - start */
        Map session = ActionContext.getContext().getSession();
        List<CartItem> sesCart = (List<CartItem>) session.get("cart");
        session.remove("cart");
        if (cart != null) {
            session.put("cart", cart);
        } else {
            session.put("cart", sesCart);
            cart = sesCart;
        }
        /* pokus  - end */
        
        this.cart = cart;
    }
    
    
    
    public void setCartProductCount(String[] cartProductCount) {
        System.out.println("setCartProductCount called");  
        this.cartProductCount = cartProductCount;
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
        List<Sign> tempSignList= dbProvider.getAllSigns();
        
        //signList = new ArrayList();
        
        // nacteni filtru značky
        for (Sign item : tempSignList){
            if (item.getName().equals(signFilter)){
                signFilterId = item.getId();   
            }
        }
        
        // nacteni filtro pohlavi
        if (sexFilter.equals("Pánské")){
            sexFilterId = 1;
        }
        else{
            if (sexFilter.equals("Dámské")){
                sexFilterId = 2;
            }
            else{
                sexFilterId = 0;
            }
        }
        
        // nacteni filtru skladu

        
                
                
        System.out.println("doFilter called !!!!!!!!!!!!!!!" + signFilterId);
        System.out.println("doFilter called !!!!!!!!!!!!!!!" + sexFilterId);
        System.out.println("doFilter called !!!!!!!!!!!!!!!" + werhauseFilter);
        return SUCCESS;
    }

    private String sexFilter;
    private List<String> sexList;
    private String signFilter;
    private int signFilterId;
    private int sexFilterId;
    private List<String> signList;
    private int werhauseFilter;

    public int getWerhauseFilter() {
        return werhauseFilter;
    }

    public void setWerhauseFilter(int werhauseFilter) {
        this.werhauseFilter = werhauseFilter;
    }
    
    
    public List<String> getSexList() {
        sexList = new ArrayList();
        sexList.add("Pánské");
        sexList.add("Dámské");
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
        List<Sign> tempSignList= dbProvider.getAllSigns();
        signList = new ArrayList();
        
        for (Sign item : tempSignList){
            signList.add(item.getName());
        }
        Collections.sort(signList);
        return signList;
    }

    public void setSignList(List<String> signList) {
        this.signList = signList;
    }

    
    public String loadProductsTable()
    {
        System.out.println("loadProductsTable called !!!!!!!!!!!!!!!");  
        if(this.subcat ==null && this.cat == null )
        {
            this.productList = dbProvider.getAllProducts();
            this.productInTableList = new ArrayList<ProductInTable>();
            for(Product prod : productList){
               ProductInTable pt = new ProductInTable();
               pt.setProduct(prod);
               pt.setImage(this.getImageToProduct(prod));
               this.productInTableList.add(pt);
            }
             return SUCCESS;
        }
    
        // category set
        if(this.subcat ==null && this.cat !=null)
        {
            this.productList = new ArrayList<Product>();
 
            List<Segment> segList = dbProvider.getSegmentsByCategory(dbProvider.getCategory(this.cat.intValue()));
          
           
            for(Segment seg: segList) {
                List<Product> tmpProd =  dbProvider.getProductsBySegment(seg);
                for(Product prod : tmpProd)
                {
                    if(!this.productList.contains(prod))
                    {
                        this.productList.add(prod);
                    }
                }
            }
            this.productInTableList = new ArrayList<ProductInTable>();
            for(Product prod : productList){
               ProductInTable pt = new ProductInTable();
               pt.setProduct(prod);
               pt.setImage(this.getImageToProduct(prod));
               this.productInTableList.add(pt);
            }
            return SUCCESS;
        }
         
        // subcategory set
        this.productList = dbProvider.getProductsBySegment(dbProvider.getSegment(this.subcat.intValue()));
        this.productInTableList = new ArrayList<ProductInTable>();
            for(Product prod : productList){
               ProductInTable pt = new ProductInTable();
               pt.setProduct(prod);
               pt.setImage(this.getImageToProduct(prod));
               this.productInTableList.add(pt);
            }
        return SUCCESS;
    }

     public List<ProductInTable> getProductInTableList() {
        return productInTableList;
    }
    private String getImageToProduct(Product prod){
        List<Picture> pic  = dbProvider.getPicturesByProduct(prod);
        if(pic != null && pic.size()>0)
        {
            return pic.get(0).getPath();
        }
        return null;
    }

    public void setProductInTableList(List<ProductInTable> productInTableList) {
        this.productInTableList = productInTableList;
    }
  
    
}

