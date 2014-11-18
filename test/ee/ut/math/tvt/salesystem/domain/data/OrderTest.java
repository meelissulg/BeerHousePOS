package ee.ut.math.tvt.salesystem.domain.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class OrderTest {
	SoldItem soldItem;

	@Before
	public void setUp() throws Exception {
		soldItem = new SoldItem(
				new StockItem((long) 1, "Lauaviin", "", 3.5, 100), 2);
	}

	@Test
	public void testAddSoldItem(){
		Order order = new Order();
		order.addSoldItem(soldItem);
		
		assertEquals(order.getNrOfSoldItems(), 1);
	}
	public void testGetSumWithNoItems(){
		Order order = new Order();
		assertEquals(0.0, order.getSum(), 0.0001);
	}
	public void testGetSumWithOneItem(){
		Order order = new Order();
		order.addSoldItem(soldItem);
		
		assertEquals(7.0, order.getSum(), 0.0001);
	}
	public void testGetSumWithMultipleItems(){
		Order order = new Order();
		
		order.addSoldItem(soldItem);
		order.addSoldItem(soldItem);
		
		assertEquals(14.0, order.getSum(), 0.0001);
	}

}
