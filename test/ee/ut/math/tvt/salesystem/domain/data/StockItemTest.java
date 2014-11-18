package ee.ut.math.tvt.salesystem.domain.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	StockItem item;
	
	 @Before
	public void setUp() {
		 StockItem item = new StockItem(85l, "testItem", "test", 9, 23);
	  }
	 
	@Test
	public void testClone(){
		assertEquals(item.clone(), item);
	}
	
	public void testGetColumn(){
		assertEquals(item.getColumn(3), 23);
	}

}
