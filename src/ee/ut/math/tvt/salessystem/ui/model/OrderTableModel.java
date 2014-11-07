package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class OrderTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(PurchaseInfoTableModel.class);
    protected List<List<SoldItem>> orders;
    protected List<String[]> rows;
    protected final String[] headers;
	
	public OrderTableModel() {
		headers = new String[] { "Date", "Time", "Total price" };
		rows = new ArrayList<String[]>();
		orders = new ArrayList<List<SoldItem>>();
	}

    public void addItem(final List<SoldItem> items) {
    	String date = (new SimpleDateFormat("dd.MM.yyyy")).format(new Date());
    	String time = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
        rows.add(new String[] { date, time, getItemsSum(items) });
        orders.add(items);
        fireTableDataChanged();
    }

	public List<SoldItem> getOrders(int selectedRow) {
		return orders.get(selectedRow);
	}
    

	public int getRowCount() {
		return rows.size();
	}


	public int getColumnCount() {
		return headers.length;
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		return (rows.get(rowIndex)[columnIndex]);
	}
	

    public String getColumnName(final int columnIndex) {
        return headers[columnIndex];
    }
    
    private String getItemsSum(List<SoldItem> items) {
    	double sum = 0;
    	
    	for (int i=0; i<items.size(); i++) {
    		sum += items.get(i).getSum();
    	}
    	
    	return "" + sum;
    }
    


}