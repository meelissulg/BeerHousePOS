package ee.ut.math.tvt.salessystem.domain.data;

import java.util.Date;



/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */
public class SoldItem implements Cloneable, DisplayableItem {

    @Override
	public String toString() {
		return "SoldItem [id=" + id + ", stockItem=" + stockItem + ", name="
				+ name + ", quantity=" + quantity + ", price=" + price
				+ ", date=" + date + ", order=" + order + "]";
	}

	private Long id;
    private StockItem stockItem;
    
    private String name;
    private Integer quantity;
    private double price;
    private Date date;
    
    private Order order;
    
    public SoldItem(StockItem stockItem, int quantity) {
        this.stockItem = stockItem;
        this.name = stockItem.getName();
        this.price = stockItem.getPrice();
        this.quantity = quantity;
        this.date = new Date();
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return price * ((double) quantity);
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
    
    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
    
}
