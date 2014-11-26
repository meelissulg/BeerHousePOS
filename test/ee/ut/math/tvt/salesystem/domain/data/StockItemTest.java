package ee.ut.math.tvt.salesystem.domain.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	StockItem item;
	
	 @Before
	public void setUp() {
		item = new StockItem(85l, "testItem", "test", 9.0, 23);
	  }
	 
	@Test
	public void testClone(){
		StockItem asi = item.clone();
		assertEquals(asi.getName(), item.getName());
		assertEquals(asi.getDescription(), item.getDescription());
		assertEquals(asi.getPrice(), item.getPrice(), 0.005);
		assertEquals(asi.getQuantity(), item.getQuantity());
		assertThat(asi, is(not(item)));
		
	}
	@Test
	public void testGetColumn(){
		assertEquals(item.getColumn(3), 23);
	}

}
