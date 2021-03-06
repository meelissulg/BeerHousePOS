package ee.ut.math.tvt.salessystem.domain.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ORDER_DATE")
	private Date date;

	@OneToMany(mappedBy = "order")
	private List<SoldItem> soldItems;
	
	public Order() {
		soldItems = new ArrayList<SoldItem>();
		date = new Date();
	}
	
	public Order(List<SoldItem> soldItems) {
		this.soldItems = soldItems;
		this.date = new Date();
		//for (SoldItem soldItem : soldItems)
			//soldItem.setSale(this);
	}

	public Date getDate() {
		return date;
	}

	public List<SoldItem> getSoldItems() {
		return soldItems;
	}

	public Long getID() {
		return id;
	}
	
	public void addSoldItem(SoldItem soldItem) {
		soldItems.add(soldItem);
		//soldItem.setSale(this);
	}
	
	public int getNrOfSoldItems() {
		return soldItems.size();
	}
	
	public double getSum() {
		double sum = 0.0;
		for (SoldItem soldItem: soldItems)
			sum += soldItem.getSum();
		
		return sum;
	}
	
}