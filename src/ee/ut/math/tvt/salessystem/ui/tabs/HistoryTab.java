package ee.ut.math.tvt.salessystem.ui.tabs;


import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.data.Order;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.OrderTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab extends JPanel  {
    
 
	private static final Logger log = Logger.getLogger(PurchaseTab.class);
	private final SalesDomainController domainController;
	private SalesSystemModel model;

	public HistoryTab(SalesDomainController controller, SalesSystemModel model) {
		this.domainController = controller;
		this.model = model;
	}

	public Component draw() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("History"));

		final JTable infoTable = new JTable(model.getHistoryTableModel());
		final PurchaseInfoTableModel itemsTableModel = new PurchaseInfoTableModel();
		final JTable itemsTable = new JTable(itemsTableModel);

		infoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = infoTable.getSelectedRow();
				if (selectedRow >= 0) {
					itemsTableModel.populateWithData(model
							.getHistoryTableModel().getOrders(selectedRow));
					System.out.println(selectedRow);
				}
			}

		});

		panel.add(new JScrollPane(infoTable), getBacketScrollPaneConstraints());
		panel.add(new JScrollPane(itemsTable), getBacketScrollPaneConstraints());

		return panel;
	}
	
	private GridBagConstraints getBacketScrollPaneConstraints() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		return gc;
	}
    
}
