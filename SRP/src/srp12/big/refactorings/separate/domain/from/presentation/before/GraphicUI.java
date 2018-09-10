package srp12.big.refactorings.separate.domain.from.presentation.before;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;

import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.Font;

@SuppressWarnings("serial")
public class GraphicUI extends JFrame
{
	private JTextField userCodeField;
	private JTextField nameField;
	private JTextField titleField;

	private JSpinner priceCodeSpinner;

	private JSpinner videoTypeSpinner;

	private JTextArea textArea;

	public void start()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public GraphicUI()
	{
		initialize();
	}

	private void initialize()
	{
		setBounds(100, 100, 619, 422);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textArea = new JTextArea(6, 80);
		textArea.setEditable ( false );
		textArea.setVisible(true);
	    JScrollPane scroll = new JScrollPane ( textArea );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    scroll.setBounds(18, 249, 583, 133);
	    getContentPane().add(scroll);

		JLabel lblWelcomeToSs = new JLabel("Welcome To SS Video Shop");
		lblWelcomeToSs.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWelcomeToSs.setBounds(208, 20, 194, 16);
		getContentPane().add(lblWelcomeToSs);

		makeButton("Register User", (e) -> registerUser(), 18, 54, 117, 29);

		makeLabel("User Code:", 147, 59, 75, 16);

		userCodeField = new JTextField();
		userCodeField.setBounds(218, 54, 130, 26);
		getContentPane().add(userCodeField);
		userCodeField.setColumns(10);

		makeLabel("Name:", 374, 59, 61, 16);

		nameField = new JTextField();
		nameField.setBounds(423, 54, 178, 26);
		getContentPane().add(nameField);
		nameField.setColumns(10);

		makeButton("Register Video", (e) -> registerVideo(), 18, 95, 117, 29);

		makeLabel("Title:", 147, 100, 61, 16);

		titleField = new JTextField();
		titleField.setBounds(182, 95, 144, 26);
		getContentPane().add(titleField);
		titleField.setColumns(10);

		makeLabel("Price Code:", 338, 100, 75, 16);

		String[] priceCodes = new String[] { "Regular", "New" };
		SpinnerListModel priceCodeModel = new SpinnerListModel(priceCodes);
		priceCodeSpinner = new JSpinner(priceCodeModel);
		priceCodeSpinner.setBounds(412, 95, 75, 26);
		getContentPane().add(priceCodeSpinner);

		makeLabel("Type:", 494, 100, 61, 16);

		String[] videoTypes = new String[] { "VHS", "CD", "DVD" };
		SpinnerListModel videoTypeModel = new SpinnerListModel(videoTypes);
		videoTypeSpinner = new JSpinner(videoTypeModel);
		videoTypeSpinner.setBounds(531, 95, 70, 26);
		getContentPane().add(videoTypeSpinner);

		makeSeparator(28, 136, 572, 1);
		makeSeparator(18, 128, 583, 16);

		makeButton("Rent", (e) -> rentVideo(), 18, 148, 117, 29);
		makeButton("Return", (e) -> returnVideo(), 136, 148, 117, 29);

		makeSeparator(18, 176, 583, 16);

		makeButton("List Customers", (e) -> listCustomers(), 18, 193, 130, 29);
		makeButton("List Videos", (e) -> listVideos(), 146, 193, 117, 29);
		makeButton("Customer Report", (e) -> getCustomerReport(), 297, 193, 138, 29);
		makeButton("Clear Customer Rentals", (e) -> clearRentals(), 427, 193, 174, 29);
		makeButton("Clear", (e) -> clear(), 484, 149, 117, 29);
	}
	
	private void clear()
	{
		nameField.setText("");
		userCodeField.setText("");
		titleField.setText("");
		textArea.setText("");
	}

	private void clearRentals()
	{
		
	}

	private void getCustomerReport()
	{
		
	}

	private void listVideos()
	{
		
	}

	private void listCustomers()
	{
		
	}

	private void returnVideo()
	{
		
	}

	private void rentVideo()
	{
		
	}

	private void registerUser() 
	{
		
	}
	
	private void registerVideo()
	{
		
	}

	private void makeButton(String title, ActionListener listener, int x, int y, int w, int h)
	{
		JButton button = new JButton(title);
		button.addActionListener(listener);
		button.setBounds(x, y, w, h);
		getContentPane().add(button);
	}

	private void makeLabel(String title, int x, int y, int w, int h)
	{
		JLabel label = new JLabel(title);
		label.setBounds(x, y, w, h);
		getContentPane().add(label);
	}

	private void makeSeparator(int x, int y, int w, int h)
	{
		JSeparator separator = new JSeparator();
		separator.setBounds(x, y, w, h);
		getContentPane().add(separator);
	}
}
