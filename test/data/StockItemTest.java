package data;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
//
public class StockItemTest {
	StockItem stockItem;
	
	public void setUp() {
		stockItem = new StockItem((long) 888, "Lauriviin", "test", 5.5, 3);
	}
	
	public void testClone(){
		assertEquals(stockItem.clone(),stockItem);
	}
	
	public void testGetColumn(){
		assertEquals(stockItem.getColumn(2),3);
	}
}
