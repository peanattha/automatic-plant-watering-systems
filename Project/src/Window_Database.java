import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class Window_Database extends JFrame {

	private JPanel contentPane;
	private JTextField tfSoilMoi;
	private JTextField tfTem;
	private JTextField tfHimdi;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBoxhh;
	private JComboBox comboBoxminis;
	private JComboBox comboBoxss;
	private JComboBox comboBoxdd;
	private JComboBox comboBoxmm;
	private JComboBox comboBoxyyyy;
	public JButton btnOK;
	public JButton btnCancel;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private String databaseURL;
	private Connection conn;
	private Statement stment;
	private ResultSet rs;
	private String qry;
	private int rowSize;
	private JButton btFrist;
	private JButton btPrevious;
	private JButton btNext;
	private JButton btLast;
	private String InsertDatabase = "Insert Database";
	private String DeletDatabase = "Delete Database";
	private String EditDatabase = "Edit Database";
	private JButton btnEditDatabase;
	private JRadioButton rdbtnNewRadioButton_2;
	private JLabel lblcount;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_Database frame = new Window_Database();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window_Database() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			databaseURL = "jdbc:ucanaccess://Project_1.accdb";
			conn = DriverManager.getConnection(databaseURL);
			stment= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("Connect Successfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		tfSoilMoi = new JTextField();
		tfSoilMoi.setBounds(318, 179, 130, 25);
		contentPane.add(tfSoilMoi);
		tfSoilMoi.setColumns(10);
		
		tfTem = new JTextField();
		tfTem.setBounds(318, 227, 130, 25);
		contentPane.add(tfTem);
		tfTem.setColumns(10);
		
		tfHimdi = new JTextField();
		tfHimdi.setBounds(318, 272, 130, 25);
		contentPane.add(tfHimdi);
		tfHimdi.setColumns(10);
		
		comboBoxhh = new JComboBox();
		comboBoxhh.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00"}));
		comboBoxhh.setBounds(318, 132, 53, 21);
		contentPane.add(comboBoxhh);
		
		comboBoxminis = new JComboBox();
		comboBoxminis.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "00"}));
		comboBoxminis.setBounds(381, 132, 54, 21);
		contentPane.add(comboBoxminis);
		
		comboBoxss = new JComboBox();
		comboBoxss.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "00"}));
		comboBoxss.setBounds(445, 132, 59, 21);
		contentPane.add(comboBoxss);
		
		comboBoxdd = new JComboBox();		
		comboBoxdd.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxdd.setBounds(318, 84, 53, 21);
		contentPane.add(comboBoxdd);
		
		comboBoxmm = new JComboBox();
		comboBoxmm.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxmm.setBounds(381, 84, 54, 21);
		contentPane.add(comboBoxmm);
		
		Calendar c = Calendar.getInstance();
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
		String currentDate = year.format(c.getTime());
		int yearr = Integer.parseInt(currentDate);

		comboBoxyyyy = new JComboBox();
		comboBoxyyyy.setModel(new DefaultComboBoxModel(new String[] {"2560", "2562", "2563", "2564"}));
		comboBoxyyyy.setBounds(445, 84, 59, 21);
		contentPane.add(comboBoxyyyy);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Insert Database");
		rdbtnNewRadioButton.setBounds(563, 197, 124, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Delete Database");
		rdbtnNewRadioButton_1.setBounds(563, 229, 124, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setEnabled(false);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Edit Database");
		rdbtnNewRadioButton_2.setBounds(563, 262, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setEnabled(false);
		
		rdbtnNewRadioButton.setActionCommand("Insert Database");
		rdbtnNewRadioButton_1.setActionCommand("Delete Database");
		rdbtnNewRadioButton_2.setActionCommand("Edit Database");
		final ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);

		
		JLabel lblnoti = new JLabel("");
		lblnoti.setHorizontalAlignment(SwingConstants.CENTER);
		lblnoti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnoti.setBounds(245, 403, 239, 40);
		contentPane.add(lblnoti);
				
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String infoDatetime = ((String) comboBoxdd.getSelectedItem()+"/"+comboBoxmm.getSelectedItem()+"/"+comboBoxyyyy.getSelectedItem()
				+" "+comboBoxhh.getSelectedItem()+":"+comboBoxminis.getSelectedItem()+":"+comboBoxss.getSelectedItem());

				if (group.getSelection().getActionCommand().equals(InsertDatabase)) {
					try {
						
						qry = "SELECT* FROM Info WHERE datetime = '"+infoDatetime+"'";
						rs = stment.executeQuery(qry);
						
						if (rs.next()) {
							System.out.println("Information repeatedly");
						}
						else {
							qry = "INSERT INTO Info(datetime,soilMosi,Temperature,Humidity) VALUES  ('"+infoDatetime+"','"+tfSoilMoi.getText()+"','"
							+tfTem.getText()+"','"+tfHimdi.getText()+"')";
							stment.executeUpdate(qry);
							lblnoti.setText("Inserted Successfully");
							System.out.println("Inserted Successfully");
							
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				else if (group.getSelection().getActionCommand().equals(DeletDatabase) && (JOptionPane.showConfirmDialog( null, "DELET YES or NO ?","Delet", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)) {
					try {	
						conn = DriverManager.getConnection(databaseURL);
						qry = "DELETE FROM Info where datetime = '"+infoDatetime+"' and soilMosi = '"+tfSoilMoi.getText()+"'and Temperature = '"+tfTem.getText()+"' and Humidity = '"+tfHimdi.getText()+"'";
						stment.executeUpdate(qry);
						lblnoti.setText("Delet Successfully");
						System.out.println("Delet Successfully");
		
					} catch (Exception e2) {
						// TODO: handle exception
					}
				
					
				}else if (EditDatabase.equals(group.getSelection().getActionCommand())) {
					try {
						qry = "UPDATE Info SET soilMosi = '"+tfSoilMoi.getText()+"', Temperature = '"+tfTem.getText()+"', Humidity = '"+tfHimdi.getText()+"' where datetime = '"+infoDatetime+"'";
						stment.executeUpdate(qry);
						lblnoti.setText("Edit Successfully");
						System.out.println("Edit Successfully");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
			}
		});
		btnOK.setBounds(233, 453, 91, 36);
		contentPane.add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfSoilMoi.setText("");
				tfTem.setText("");
				tfHimdi.setText("");
				btFrist.setEnabled(false);
				btLast.setEnabled(false);
				btPrevious.setEnabled(false);
				btNext.setEnabled(false);
				rdbtnNewRadioButton.setEnabled(true);
				
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(394, 453, 96, 36);
		contentPane.add(btnCancel);
		
		lblNewLabel = new JLabel("Date dd/mm/yyyy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(165, 82, 130, 21);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Time HH:mm:ss");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(165, 129, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Soil Moisture");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(188, 179, 107, 21);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Temperature");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(153, 225, 142, 25);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Humidity");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(199, 273, 96, 19);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(459, 185, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*C");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(458, 233, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("%");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(458, 278, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		btFrist = new JButton("|<");
		btFrist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (rs.first()) {
						String info = rs.getString("datetime");
						String[] splinfodatetime = info.split(" ");
						String[] spldate = splinfodatetime[0].split("/");
						String[] spltime = splinfodatetime[1].split(":");
						
						comboBoxdd.setSelectedItem(spldate[0]);
						comboBoxmm.setSelectedItem(spldate[1]);
						comboBoxyyyy.setSelectedItem(spldate[2]);

						comboBoxhh.setSelectedItem(spltime[0]);
						comboBoxminis.setSelectedItem(spltime[1]);
						comboBoxss.setSelectedItem(spltime[2]);
						
						tfSoilMoi.setText(rs.getString("soilMosi"));
						tfTem.setText(rs.getString("Temperature"));
						tfHimdi.setText(rs.getString("Humidity"));
					}else {
						rs.first();
					}
					lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btFrist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btFrist.setBounds(178, 336, 59, 47);
		contentPane.add(btFrist);
		btFrist.setEnabled(false);
		
		btPrevious = new JButton("<");
		btPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (rs.previous()) {
						String info = rs.getString("datetime");
						String[] splinfodatetime = info.split(" ");
						String[] spldate = splinfodatetime[0].split("/");
						String[] spltime = splinfodatetime[1].split(":");
						
						comboBoxdd.setSelectedItem(spldate[0]);
						comboBoxmm.setSelectedItem(spldate[1]);
						comboBoxyyyy.setSelectedItem(spldate[2]);

						comboBoxhh.setSelectedItem(spltime[0]);
						comboBoxminis.setSelectedItem(spltime[1]);
						comboBoxss.setSelectedItem(spltime[2]);
						
						tfSoilMoi.setText(rs.getString("soilMosi"));
						tfTem.setText(rs.getString("Temperature"));
						tfHimdi.setText(rs.getString("Humidity"));
					}else {
						rs.first();

					}
					lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btPrevious.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btPrevious.setBounds(245, 336, 59, 47);
		contentPane.add(btPrevious);
		btPrevious.setEnabled(false);
		
		btNext = new JButton(">");
		btNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (rs.next()) {
						String info = rs.getString("datetime");
						String[] splinfodatetime = info.split(" ");
						String[] spldate = splinfodatetime[0].split("/");
						String[] spltime = splinfodatetime[1].split(":");
						
						comboBoxdd.setSelectedItem(spldate[0]);
						comboBoxmm.setSelectedItem(spldate[1]);
						comboBoxyyyy.setSelectedItem(spldate[2]);

						comboBoxhh.setSelectedItem(spltime[0]);
						comboBoxminis.setSelectedItem(spltime[1]);
						comboBoxss.setSelectedItem(spltime[2]);
						
						tfSoilMoi.setText(rs.getString("soilMosi"));
						tfTem.setText(rs.getString("Temperature"));
						tfHimdi.setText(rs.getString("Humidity"));
					}else {
						rs.last();

					}
					lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btNext.setBounds(399, 336, 66, 47);
		contentPane.add(btNext);
		btNext.setEnabled(false);

		
		btLast = new JButton(">|");
		btLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (rs.last()) {
						String info = rs.getString("datetime");
						String[] splinfodatetime = info.split(" ");
						String[] spldate = splinfodatetime[0].split("/");
						String[] spltime = splinfodatetime[1].split(":");
						
						comboBoxdd.setSelectedItem(spldate[0]);
						comboBoxmm.setSelectedItem(spldate[1]);
						comboBoxyyyy.setSelectedItem(spldate[2]);

						comboBoxhh.setSelectedItem(spltime[0]);
						comboBoxminis.setSelectedItem(spltime[1]);
						comboBoxss.setSelectedItem(spltime[2]);
						
						tfSoilMoi.setText(rs.getString("soilMosi"));
						tfTem.setText(rs.getString("Temperature"));
						tfHimdi.setText(rs.getString("Humidity"));
					}else {
						rs.last();
					}
					lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btLast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLast.setBounds(475, 336, 66, 47);
		contentPane.add(btLast);
		btLast.setEnabled(false);
		
		
		btnEditDatabase = new JButton("Edit Database");
		btnEditDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btFrist.setEnabled(true);
				btLast.setEnabled(true);
				btPrevious.setEnabled(true);
				btNext.setEnabled(true);
				rdbtnNewRadioButton.setEnabled(false);
				rdbtnNewRadioButton_1.setEnabled(true);
				rdbtnNewRadioButton_2.setEnabled(true);
				
				try {
					qry = "SELECT* FROM Info";
					rs = stment.executeQuery(qry);
					
					if (rs.next()) {
						rs.last();
						rowSize = rs.getRow();
						rs.beforeFirst();
					}
					
					if (rs.next()) {
						String info = rs.getString("datetime");
						String[] splinfodatetime = info.split(" ");
						String[] spldate = splinfodatetime[0].split("/");
						String[] spltime = splinfodatetime[1].split(":");
						
						comboBoxdd.setSelectedItem(spldate[0]);
						comboBoxmm.setSelectedItem(spldate[1]);
						comboBoxyyyy.setSelectedItem(spldate[2]);

						comboBoxhh.setSelectedItem(spltime[0]);
						comboBoxminis.setSelectedItem(spltime[1]);
						comboBoxss.setSelectedItem(spltime[2]);
						
						tfSoilMoi.setText(rs.getString("soilMosi"));
						tfTem.setText(rs.getString("Temperature"));
						tfHimdi.setText(rs.getString("Humidity"));
						
					}
					lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditDatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditDatabase.setBounds(563, 289, 124, 36);
		contentPane.add(btnEditDatabase);
		
		lblcount = new JLabel("0/0");
		lblcount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcount.setBounds(344, 340, 59, 38);
		contentPane.add(lblcount);
		
		JButton btnNewButton = new JButton("Disconnect Database");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
					stment.close();
					System.out.println("Disconnect Database");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(555, 497, 156, 32);
		contentPane.add(btnNewButton);
	}
}
