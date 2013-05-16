package net.gjashop.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import net.gjashop.custom.HibernateUtil;
import net.gjashop.custom.OperationProvider;
import net.gjashop.entities.Picture;
import net.gjashop.entities.Product;


/**
 *
 * @author lacoret
 */
public class ProductAction extends ActionSupport{
    private Product product;
    private String image;
    private List<Product> productList;
    private Long id;
    
    private OperationProvider dbProvider  = new OperationProvider(HibernateUtil.getSessionFactory().openSession());

    public String execute() throws Exception {
       //image = "hello.png";
       System.out.println("eeeeeeeeaaaaaaaeeeeeeeeeeeeeeeeee " ); 
       this.productList = dbProvider.getAllProducts();
       return super.execute();
    }

    public String getImage() {
       return image;
    }
    
    public String setProduct(Product prodctObject)
    {
        this.product       = prodctObject;
        List<Picture> pic  = dbProvider.getPicturesByProduct(this.product);
        if(pic != null && pic.size()>0)
        {
            this.image   = pic.get(0).getPath();
        }
        return SUCCESS;
    }
    public Product getProduct()
    {
        return this.product;
    }
    
    public String loadProduct()
    {
        return SUCCESS;
    }
       
    public List<Product> getProductList() {
        return this.productList;
    }
    public void setProductList(List<Product> products )
    {
        this.productList = products;
    }
    
    public long getId() {
        return id;
    }
     public void setId(Long id) {
        this.id = id;
    }
    
    public String loadProductTable()
    {
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeee " );
        this.productList = dbProvider.getAllProducts();
        System.out.println("ee "+ this.productList.size()  );
        return SUCCESS;
    }
}
