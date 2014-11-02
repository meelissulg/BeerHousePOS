package ee.ut.math.tvt.salessystem.ui.tabs;

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
    
 
	private SalesSystemModel model;
	
	
    public HistoryTab() {
    	
    	super(new GridLayout(1,0));
    		
   
    } 
    
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
//        panel.add(drawStockMainPane(), gc);
       
        return panel;
    }
    
    private Component drawStockMenuPane() {
        JPanel panel = new JPanel();

        GridBagConstraints gc = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();

        panel.setLayout(gb);

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = 0;

       
        gc.gridwidth = GridBagConstraints.RELATIVE;
        gc.weightx = 1.0;
       

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel;
      }
    
//    private Component drawStockMainPane() {
//        JPanel panel = new JPanel();
//
//        
//		JTable table = new JTable(model.getHistoryTableModel());
//		
//		table.addMouseListener(new MouseAdapter() {
//			  public void mouseClicked(MouseEvent e) {
//			    if (e.getClickCount() == 1) {
//			      JTable target = (JTable)e.getSource();
//			      int row = target.getSelectedRow();
//			      
//			    }
//			  }
//		});
//			  
//        JTableHeader header = table.getTableHeader();
//        header.setReorderingAllowed(false);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        GridBagConstraints gc = new GridBagConstraints();
//        GridBagLayout gb = new GridBagLayout();
//        gc.fill = GridBagConstraints.BOTH;
//        gc.weightx = 1.0;
//        gc.weighty = 1.0;
//
//        panel.setLayout(gb);
//        panel.add(scrollPane, gc);
//
//        panel.setBorder(BorderFactory.createTitledBorder("History of orders"));
//        return panel;
//        
//      }
    
}
