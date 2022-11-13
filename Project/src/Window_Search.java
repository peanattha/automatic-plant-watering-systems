import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Window_Search extends Window {

	private JPanel contentPane;
	public JTextField textFielddd;
	private JTextField textFieldhh;
	private JTextField textFieldmm;
	private JTextField textFieldyy;
	private JTextField textFieldmin;
	private JTextField textFieldss;
	private Connection conn;
	private Statement stment;
	private String qry;
	private ResultSet rs;
	private String databaseURL;
	String infoday;
	String infomm;
	String infoyy;
	String infohh;
	String infomin;
	String infoss;
	private int rowSize;
	private JLabel lblcount;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_Search frame = new Window_Search();
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
	public Window_Search() {
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
			stment = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("Connect Successfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JComboBox<String> cbOp = new JComboBox<String>();
		cbOp.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
		cbOp.setModel(new DefaultComboBoxModel<String>(new String[] {"ทั้งหมด", "วันเดือนปีเวลา"}));
		cbOp.setSelectedIndex(0);
		cbOp.setBounds(321, 45, 107, 32);
		contentPane.add(cbOp);
		
		textFielddd = new JTextField();
		textFielddd.setBounds(337, 102, 37, 32);
		contentPane.add(textFielddd);
		textFielddd.setColumns(10);
		
		textFieldhh = new JTextField();
		textFieldhh.setBounds(337, 144, 37, 32);
		contentPane.add(textFieldhh);
		textFieldhh.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(214, 353, 331, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxTemperature = new JCheckBox("Temperature");
		chckbxTemperature.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTemperature.setBounds(314, 182, 114, 21);
		contentPane.add(chckbxTemperature);
		
		JCheckBox chckbxHumidity = new JCheckBox("Humidity");
		chckbxHumidity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHumidity.setBounds(314, 205, 122, 21);
		contentPane.add(chckbxHumidity);
		
		JCheckBox chckbxSoilMoisture = new JCheckBox("Soil Moisture");		
		chckbxSoilMoisture.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxSoilMoisture.setBounds(314, 228, 114, 21);
		contentPane.add(chckbxSoilMoisture);
		
		JLabel lblTem = new JLabel("");
		lblTem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTem.setBounds(10, 21, 299, 32);
		panel.add(lblTem);
		lblTem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblHimid = new JLabel("");
		lblHimid.setHorizontalAlignment(SwingConstants.CENTER);
		lblHimid.setBounds(20, 72, 282, 32);
		panel.add(lblHimid);
		lblHimid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSoil = new JLabel("");
		lblSoil.setBounds(15, 123, 294, 31);
		panel.add(lblSoil);
		lblSoil.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblcount = new JLabel("0/0");
		lblcount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcount.setBounds(364, 311, 45, 32);
		contentPane.add(lblcount);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				infoday = textFielddd.getText();
				infomm = textFieldmm.getText();
				infoyy = textFieldyy.getText();
				infohh = textFieldhh.getText();
				infomin = textFieldmin.getText();
				infoss = textFieldss.getText();
				
				String Searchinfo = (infoday+"/"+infomm+"/"+infoyy+" "+infohh+":"+infomin+":"+infoss);
				
				try {			
					
					switch (cbOp.getSelectedIndex()) {
					case 0:
						qry = "SELECT * FROM Info";
						break;
					case 1:
						qry = "SELECT* FROM Info WHERE datetime = '"+Searchinfo+"'";
						break;
					}
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
						
						textFielddd.setText(spldate[0]);
						textFieldmm.setText(spldate[1]);
						textFieldyy.setText(spldate[2]);

						textFieldhh.setText(spltime[0]);
						textFieldmin.setText(spltime[1]);
						textFieldss.setText(spltime[2]);
						
						if (chckbxSoilMoisture.isSelected()==true) {
							String infoSoil = rs.getString("soilMosi");
							lblSoil.setText("Soil moisture = "+infoSoil+" %");
						}else {
							lblSoil.setText(" Please select ");

						}if (chckbxTemperature.isSelected()==true) {
							String infoTem = rs.getString("Temperature");
							lblTem.setText("Temperature = "+infoTem+" *c");
						}else {
							lblTem.setText(" Please select ");

						}if (chckbxHumidity.isSelected()==true) {
							String infoHumi = rs.getString("Humidity");
							lblHimid.setText("Humidity = "+infoHumi+" %");
						}else {
							lblHimid.setText(" Please select ");
						}
						lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
						System.out.println("Output Databaes Successfully");
					}else {
						lblSoil.setText(" ");
						lblTem.setText(" ");
						lblHimid.setText(" ");
						textFielddd.setText("");
						textFieldmm.setText("");
						textFieldyy.setText("");
						textFieldmin.setText("");
						textFieldss.setText("");
						textFieldhh.setText("");
						chckbxTemperature.setSelected(false);
						chckbxHumidity.setSelected(false);
						chckbxSoilMoisture.setSelected(false);
						JOptionPane.showMessageDialog(btnSearch, "NOT INFOMATION");
					}
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	
			}
		});
		btnSearch.setBounds(232, 255, 114, 39);
		contentPane.add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSoil.setText(" ");
				lblTem.setText(" ");
				lblHimid.setText(" ");
				textFielddd.setText("");
				textFieldmm.setText("");
				textFieldyy.setText("");
				textFieldmin.setText("");
				textFieldss.setText("");
				textFieldhh.setText("");
				chckbxTemperature.setSelected(false);
				chckbxHumidity.setSelected(false);
				chckbxSoilMoisture.setSelected(false);
			}
		});
		btnClear.setBounds(399, 255, 114, 39);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Search dd/MM/yyyy HH:mm:ss");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(259, 10, 244, 25);
		contentPane.add(lblNewLabel);
		

		
		JLabel lblNewLabel_1 = new JLabel("DATE dd/mm/yyyy");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(198, 104, 122, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TIME HH:mm:ss");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(214, 153, 114, 23);
		contentPane.add(lblNewLabel_2);
		
		textFieldmm = new JTextField();
		textFieldmm.setBounds(399, 102, 37, 32);
		contentPane.add(textFieldmm);
		textFieldmm.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(376, 104, 19, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("/");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(438, 104, 19, 22);
		contentPane.add(lblNewLabel_3_1);
		
		textFieldyy = new JTextField();
		textFieldyy.setBounds(461, 102, 52, 32);
		contentPane.add(textFieldyy);
		textFieldyy.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel(":");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(376, 146, 24, 22);
		contentPane.add(lblNewLabel_4);
		
		textFieldmin = new JTextField();
		textFieldmin.setBounds(399, 144, 37, 32);
		contentPane.add(textFieldmin);
		textFieldmin.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel(":");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(438, 146, 24, 22);
		contentPane.add(lblNewLabel_4_1);
		
		textFieldss = new JTextField();
		textFieldss.setBounds(461, 144, 52, 32);
		contentPane.add(textFieldss);
		textFieldss.setColumns(10);
		
		JButton btFrist = new JButton("|<");
		btFrist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.first()) {						
						String info = rs.getString("datetime");
						String[] splinfodatetime = info.split(" ");
						String[] spldate = splinfodatetime[0].split("/");
						String[] spltime = splinfodatetime[1].split(":");
						
						textFielddd.setText(spldate[0]);
						textFieldmm.setText(spldate[1]);
						textFieldyy.setText(spldate[2]);

						textFieldhh.setText(spltime[0]);
						textFieldmin.setText(spltime[1]);
						textFieldss.setText(spltime[2]);

						if (chckbxSoilMoisture.isSelected()==true) {
							String infoSoil = rs.getString("soilMosi");
							lblSoil.setText("Soil moisture = "+infoSoil+" %");
						}else {
							lblSoil.setText(" Please select ");

						}if (chckbxTemperature.isSelected()==true) {
							String infoTem = rs.getString("Temperature");
							lblTem.setText("Temperature = "+infoTem+" *c");
						}else {
							lblTem.setText(" Please select ");

						}if (chckbxHumidity.isSelected()==true) {
							String infoHumi = rs.getString("Humidity");
							lblHimid.setText("Humidity = "+infoHumi+" %");
						}else {
							lblHimid.setText(" Please select ");
						}

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
		btFrist.setBounds(184, 304, 65, 39);
		contentPane.add(btFrist);
		
		JButton btPrevious = new JButton("<");
		btPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String info = rs.getString("datetime");
					String[] splinfodatetime = info.split(" ");
					String[] spldate = splinfodatetime[0].split("/");
					String[] spltime = splinfodatetime[1].split(":");
					
					textFielddd.setText(spldate[0]);
					textFieldmm.setText(spldate[1]);
					textFieldyy.setText(spldate[2]);

					textFieldhh.setText(spltime[0]);
					textFieldmin.setText(spltime[1]);
					textFieldss.setText(spltime[2]);
					
					if (rs.previous()) {
						if (chckbxSoilMoisture.isSelected()==true) {
							String infoSoil = rs.getString("soilMosi");
							lblSoil.setText("Soil moisture = "+infoSoil+" %");
						}else {
							lblSoil.setText(" Please select ");

						}if (chckbxTemperature.isSelected()==true) {
							String infoTem = rs.getString("Temperature");
							lblTem.setText("Temperature = "+infoTem+" *c");
						}else {
							lblTem.setText(" Please select ");

						}if (chckbxHumidity.isSelected()==true) {
							String infoHumi = rs.getString("Humidity");
							lblHimid.setText("Humidity = "+infoHumi+" %");
						}else {
							lblHimid.setText(" Please select ");
						}
						lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
					}else {
						rs.first();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btPrevious.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btPrevious.setBounds(259, 304, 65, 39);
		contentPane.add(btPrevious);
		
		JButton btNext = new JButton(">");
		btNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String info = rs.getString("datetime");
					String[] splinfodatetime = info.split(" ");
					String[] spldate = splinfodatetime[0].split("/");
					String[] spltime = splinfodatetime[1].split(":");
					
					textFielddd.setText(spldate[0]);
					textFieldmm.setText(spldate[1]);
					textFieldyy.setText(spldate[2]);

					textFieldhh.setText(spltime[0]);
					textFieldmin.setText(spltime[1]);
					textFieldss.setText(spltime[2]);
					
					if (rs.next()) {
						if (chckbxSoilMoisture.isSelected()==true) {
							String infoSoil = rs.getString("soilMosi");
							lblSoil.setText("Soil moisture = "+infoSoil+" %");
						}else {
							lblSoil.setText(" Please select ");

						}if (chckbxTemperature.isSelected()==true) {
							String infoTem = rs.getString("Temperature");
							lblTem.setText("Temperature = "+infoTem+" *c");
						}else {
							lblTem.setText(" Please select ");

						}if (chckbxHumidity.isSelected()==true) {
							String infoHumi = rs.getString("Humidity");
							lblHimid.setText("Humidity = "+infoHumi+" %");
						}else {
							lblHimid.setText(" Please select ");
						}
						lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
					}else {
						rs.last();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btNext.setBounds(421, 304, 65, 39);
		contentPane.add(btNext);
		
		JButton btLast = new JButton(">|");
		btLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					String info = rs.getString("datetime");
					String[] splinfodatetime = info.split(" ");
					String[] spldate = splinfodatetime[0].split("/");
					String[] spltime = splinfodatetime[1].split(":");
					
					textFielddd.setText(spldate[0]);
					textFieldmm.setText(spldate[1]);
					textFieldyy.setText(spldate[2]);

					textFieldhh.setText(spltime[0]);
					textFieldmin.setText(spltime[1]);
					textFieldss.setText(spltime[2]);
					
					if (rs.last()) {
						if (chckbxSoilMoisture.isSelected()==true) {
							String infoSoil = rs.getString("soilMosi");
							lblSoil.setText("Soil moisture = "+infoSoil+" %");
						}else {
							lblSoil.setText(" Please select ");

						}if (chckbxTemperature.isSelected()==true) {
							String infoTem = rs.getString("Temperature");
							lblTem.setText("Temperature = "+infoTem+" *c");
						}else {
							lblTem.setText(" Please select ");

						}if (chckbxHumidity.isSelected()==true) {
							String infoHumi = rs.getString("Humidity");
							lblHimid.setText("Humidity = "+infoHumi+" %");
						}else {
							lblHimid.setText(" Please select ");
						}
						lblcount.setText(Integer.toString(rs.getRow())+"/"+Integer.toString(rowSize));	
					}else {
						rs.last();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btLast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLast.setBounds(500, 304, 65, 39);
		contentPane.add(btLast);
		
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
