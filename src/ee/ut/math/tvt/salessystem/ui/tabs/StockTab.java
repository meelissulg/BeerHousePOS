package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.domain.exception.OutOfStockException;

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
import org.apache.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class StockTab {

  private JButton addItem;
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
    JPanel panell = new JPanel(); 
    panell.setLayout(new GridLayout(6, 2));
	panell.setBorder(BorderFactory.createTitledBorder("Add product"));
	
	// Initialize the textfields
	nameField = new JTextField();
	descField = new JTextField();
	priceField = new JTextField();
	quantityField = new JTextField();
	
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

			StockItem item = new StockItem();
			Boolean isError = true;

			try {
				item.setName(nameField.getText());
				item.setDescription(descField.getText());
				item.setPrice((double) Math.round(Double
						.parseDouble(priceField.getText()) * 10) / 10);
				item.setQuantity(Integer.parseInt(quantityField.getText()));
				isError = false;
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Please insert valid data", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

			if (!isError) {
				try {
//					Session session = HibernateUtil.currentSession();
//					session.beginTransaction();
//					session.persist(item);
//					session.getTransaction().commit();
					model.getWarehouseTableModel().addItem(item);
				} catch (Throwable t) {
					log.error("Could not save item to the database");
					t.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Database transaction failed", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	});
	panell.add(addItem);
	panel.add(panell, getDialogPaneConstraints());
	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	return panel;
	

//    GridBagConstraints gc = new GridBagConstraints();
//    GridBagLayout gb = new GridBagLayout();
//
//    panel.setLayout(gb);
//
//    gc.anchor = GridBagConstraints.NORTHWEST;
//    gc.weightx = 0;
//
//    JButton nupukene = new JButton("Add");
//    gc.gridwidth = GridBagConstraints.RELATIVE;
//    gc.weightx = 1.0;
//    panel.add(nupukene, gc);
//    nupukene.addActionListener(new ActionListener() {
//        public void actionPerformed(ActionEvent e) {
//          JFrame frame = new JFrame("Toote lisamine");
////          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
////          Dimension d = new Dimension(400,400);
////          frame.setPreferredSize(d);
////          frame.pack();
////          frame.setVisible(true);
//          frame.getContentPane().setLayout(new FlowLayout());
//          final JTextField PID = new JTextField("Product ID", 7);
//          frame.getContentPane().add(PID);
////          double PIDD = Long.parseLong(PID.getText());
//          final JTextField PName = new JTextField("Product Name", 7);
//          frame.getContentPane().add(PName);
////          String PName = textfield.getText();
//          final JTextField q = new JTextField("Desc", 6);
//          frame.getContentPane().add(q);
//          final JTextField t = new JTextField("Price", 3);
//          frame.getContentPane().add(t);
////          double tt = Double.parseDouble(t.getText());
//          final JTextField qua = new JTextField("Quantity", 3);
//          frame.getContentPane().add(t);
////          double quan = Double.parseDouble(qua.getText());
//          JButton nuperdis = new JButton("LISA");
//          frame.getContentPane().add(nuperdis);
////    										      nuperdis.addActionListener(new ActionListener() {
////							  public void actionPerformed(ActionEvent e) {
////								            	  StockItem(1,"lamp","2",1,1);
////								              }
////								          });
////          frame.getContentPane().add(new JTextField("Product ID"));
////          frame.getContentPane().add(new JTextField("Product Name", 8));
////          JTextField t = new JTextField("Price", 3);
////          t.setHorizontalAlignment(JTextField.RIGHT);
////          frame.getContentPane().add(t);
////          t = new JTextField("Quantity", 6);
////          t.setHorizontalAlignment(JTextField.CENTER);
////          frame.getContentPane().add(t);
////          frame.getContentPane().add(new JButton("LISA"));
////        frame.getContentPane().add(new JTextField("Text field 5", 3));
//         //Juhul, kui on vaja veel midagi lisada
//
//          frame.pack();
//          frame.setVisible(true);
//        }
//      });
//
//
//    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//    return panel;
  }


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
