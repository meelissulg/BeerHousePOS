package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.domain.exception.OutOfStockException;
import ee.ut.math.tvt.salessystem.domain.controller.impl.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class StockTab {

  private JButton addItem;
  private JTextField idField;
  private JTextField quantityField;
  private JTextField nameField;
  private JTextField priceField;
  private JTextField descField;
  private SalesSystemModel model;
  private static final Logger log = Logger.getLogger(StockTab.class);
  public StockTab(SalesSystemModel model) {
    this.model = model;
    
  }

  // warehouse stock tab - consists of a menu and a table
  public Component draw() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    panel.setLayout(gb);

    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private GridBagConstraints getDialogPaneConstraints() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.anchor = GridBagConstraints.WEST;
		gc.weightx = 0.2;
		gc.weighty = 0d;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.fill = GridBagConstraints.NONE;

		return gc;
	}
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel(); 
    panel.setLayout(new GridBagLayout());

	// Create the panel
	JPanel panell = new JPanel();
	panell.setLayout(new GridLayout(8, 2));
//	panell.setBorder(BorderFactory.createTitledBorder("Add product"));
	// Initialize the textfields
	idField = new JTextField();
	nameField = new JTextField();
	descField = new JTextField();
	priceField = new JTextField();
	quantityField = new JTextField();
	
	// - ID
	panell.add(new JLabel("ID: "));
	panell.add(idField);
	
	
	// - name
	panell.add(new JLabel("Name: "));
	panell.add(nameField);

	// - description
	panell.add(new JLabel("Description: "));
	panell.add(descField);

	// - price
	panell.add(new JLabel("Price: "));
	panell.add(priceField);

	// - amount
	panell.add(new JLabel("Amount: "));
	panell.add(quantityField);
	
	addItem = new JButton("A.D.D");
	addItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			StockItem item2 = new StockItem();
			int kasonhea=0;
			long esimene = 0;
			try{
				esimene=Long.parseLong(idField.getText());

			}
			catch(java.lang.NumberFormatException f){
				kasonhea=1;
				final JPanel panel = new JPanel();

                JOptionPane.showMessageDialog(panel, "Vale sisend", "Warning",
                    JOptionPane.WARNING_MESSAGE);
			}
			double price=0;
			try{

				price=(double) Math.round(Double.parseDouble(priceField.getText()) * 10) / 10;
			}
			catch(java.lang.NumberFormatException f){
				final JPanel panel = new JPanel();
				kasonhea=1;

                JOptionPane.showMessageDialog(panel, "Vale sisend", "Warning",
                    JOptionPane.WARNING_MESSAGE);
			}
			
			
			int quant=0;
			try{
				quant=Integer.parseInt(quantityField.getText());
			}
			catch(java.lang.NumberFormatException f){
				final JPanel panel = new JPanel();
				kasonhea=1;
                JOptionPane.showMessageDialog(panel, "Vale sisend", "Warning",
                    JOptionPane.WARNING_MESSAGE);
			}
			
			if (kasonhea==0){
			StockItem item2 = new StockItem(esimene,nameField.getText(),
				descField.getText(),price,quant);
				System.out.println("YOYOYOYO");
			model.getWarehouseTableModel().addItem(item2);
			}
			

		}
	});
	
	panell.add(addItem);
	panel.add(panell, getDialogPaneConstraints());
	panel.setBorder(BorderFactory.createLineBorder(Color.RED));
	return panel;
	
	
  }
//  public static List<StockItem> loadddd() {
//		List<StockItem> dataset = new ArrayList<StockItem>();
//
//		StockItem chips = new StockItem(1l, "Hays chips", "Potato chips", 11.0, 5);
//		StockItem chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0, 8);
//	    StockItem frankfurters = new StockItem(3l, "Frankfurters", "Beer sauseges", 15.0, 12);
//	    StockItem beer = new StockItem(4l, "Free Beer", "Student's delight", 0.0, 100);
//
//		dataset.add(chips);
//		dataset.add(chupaChups);
//		dataset.add(frankfurters);
//		dataset.add(beer);
//		
//		return dataset;
//	}


  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);

    JScrollPane scrollPane = new JScrollPane(table);

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    gc.fill = GridBagConstraints.BOTH;
    gc.weightx = 1.0;
    gc.weighty = 1.0;

    panel.setLayout(gb);
    panel.add(scrollPane, gc);

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}


