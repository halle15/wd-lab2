package music.models;

import java.io.Serializable;

public class CartEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    Product product;
    int qty;
    
    public CartEntry(Product product, int qty) {
    	this.qty = qty;
    	this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }
    public void setProduct(Product product) {
    	this.product = product;
    }
    public int getQty() {
        return this.qty;
    }
    public void setQty(int qty) {
    	this.qty = qty;
    }
}
