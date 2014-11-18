package ee.ut.math.tvt.salesystem.domain.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class OrderTest {
	StockItem stockItem1 = new StockItem((long)47, "TestProduct1", "RandomDisc1", 3.5);
	StockItem stockItem2 = new StockItem((long)48, "TestProduct2", "RandomDisc2", 5.5);
	StockItem stockItem3 = new StockItem((long)49, "TestProduct3", "RandomDisc3", 2.5);
	
	SoldItem soldItem1 = new SoldItem(stockItem1, 2);
	SoldItem soldItem2 = new SoldItem(stockItem2, 1);
	SoldItem soldItem3 = new SoldItem(stockItem3, 3);
	
	SoldItem[] soldProducts = {soldItem1, soldItem2, soldItem3};
	SoldItem[] soldProductsEmpty = {};
	
	Order order1; 
	Order order2;

	@Before
	public void setUp() throws Exception {
		order1 = new Order(Arrays.asList(soldProducts));
		order2 = new Order(Arrays.asList(soldProductsEmpty));
	}

	@Test
	public void testAddSoldItem(){
		
	}
	public void testGetSumWithNoItems(){
		
	}
	public void testGetSumWithOneItem(){
		
	}
	public void testGetSumWithMultipleItems(){
		
	}

}
