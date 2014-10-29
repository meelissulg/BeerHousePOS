package ee.ut.math.tvt.salessystem.ui.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class OrderTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	protected List<Order> orders;
	protected List<String[]> rows;
	protected final String[] headers;

	public OrderTableModel() {
		headers = new String[] { "Date", "Time", "Total price" };
		rows = new ArrayList<String[]>();
		orders = new ArrayList<Order>();
	}

	public void addItem(final Order order) {
		String date = (new SimpleDateFormat("dd.MM.yyyy")).format(order
				.getDate());
		String time = (new SimpleDateFormat("HH:mm:ss")).format(order.getDate());
		rows.add(new String[] { date, time, getSoldItemsSum(order) });
		orders.add(order);
		fireTableDataChanged();
	}

	public List<SoldItem> getSaleItems(int selectedRow) {
		if (orders.size() > selectedRow && selectedRow >= 0)
			return orders.get(selectedRow).getSoldItems();
		return null;
	}
	
	public void populateWithData(List<Order> orderData) {
		for (Order sale: orderData)
			addItem(sale);
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return (rows.get(rowIndex)[columnIndex]);
	}

	@Override
	public String getColumnName(final int columnIndex) {
		return headers[columnIndex];
	}

	private String getSoldItemsSum(Order order) {
		return String.valueOf(order.getSum());
	}

}