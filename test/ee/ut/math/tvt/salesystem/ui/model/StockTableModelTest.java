package ee.ut.math.tvt.salesystem.ui.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {
	StockTableModel stockTableModel;
	@Before
	public void setUp() throws Exception {
		StockItem stockItem1 = new StockItem((long) 1, "Lauaviin", "", 3.5, 100);
		StockItem stockItem2 = new StockItem((long) 2, "Hapukurk", "", 1.5, 10);
		
		stockTableModel = new StockTableModel();
		stockTableModel.addItem(stockItem1);
		stockTableModel.addItem(stockItem1);
		stockTableModel.addItem(stockItem2);
	}

	@Test
	public void testValidateNameUniqueness(){
		
	}
	public void testHasEnoughInStock(){
		List<StockItem> stockItems = stockTableModel.getTableRows();
		boolean hasEnoughInStock = true;
		
		for (StockItem stockItem: stockItems) {
			if (stockItem.getQuantity() <= 0) {
				hasEnoughInStock = false;
				break;
			}
		}

		assertTrue(hasEnoughInStock);
	}
	public void testGetItemByIdWhenItemExists(){
		StockItem stockItem = stockTableModel.getItemById(1);
		
		assertNotNull(stockItem);
	}
	public void testGetItemByIdWhenThrowsException(){
		StockItem stockItem = stockTableModel.getItemById(1000);
		
		assertNull(stockItem);
	}

}
