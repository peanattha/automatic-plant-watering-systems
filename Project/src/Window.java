import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import com.fazecast.jSerialComm.SerialPort;

public class Window extends JFrame {

	static SerialPort chosenPort;
	static int x = 0;
	public String[] info;
	private JPanel contentPane;
	private String currentDate;
	private String Humidity;
	private String Temperature;
	private String soilMosi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public Window() {
		setResizable(false);
		setTitle("Soil Moisture & Temperature Humidity In The Air");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> comboBoxPort = new JComboBox<String>();
		comboBoxPort.setBounds(528, 81, 94, 32);
		contentPane.add(comboBoxPort);
		
		SerialPort[] portNames = SerialPort.getCommPorts();
		for (int i = 0; i < portNames.length; i++) {
				comboBoxPort.addItem(portNames[i].getSystemPortName());
		}
		
		JLabel lblSubject = new JLabel("Soil Moisture & Temperature Humidity In The Air");
		lblSubject.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblSubject.setBounds(419, 46, 455, 25);
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSubject);
		
		JLabel lblDateTime = new JLabel("Date/Time : dd/MM/yyyy HH:mm:ss");
		lblDateTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateTime.setBounds(528, 216, 378, 25);
		contentPane.add(lblDateTime);
	
		JLabel lblTemperature = new JLabel("Temperature = Please Connect");
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTemperature.setBounds(541, 135, 262, 25);
		contentPane.add(lblTemperature);
		
		JLabel lblHumidity = new JLabel("Humidity = Please Connect");
		lblHumidity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHumidity.setBounds(551, 155, 221, 31);
		contentPane.add(lblHumidity);

		JLabel lblsoilMoisture = new JLabel("Soil moisture = Please Connect");
		lblsoilMoisture.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsoilMoisture.setBounds(545, 181, 258, 25);
		contentPane.add(lblsoilMoisture);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1266, 32);
		contentPane.add(menuBar);
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Search");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_Search seaech;
				seaech = new Window_Search();
				seaech.setVisible(true);
			}
		});
		menuFile.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Database");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_Database editData = new Window_Database();
				editData.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
				
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		JMenuItem mntmNewMenuItem = new JMenuItem("Version");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Verstion 1.0","About us",JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		mnHelp.add(mntmNewMenuItem);
		JMenu mnNewMenu = new JMenu("About us");
		mnHelp.add(mnNewMenu);
		
		JMenuItem mntmMember_1 = new JMenuItem("Member 1");
		mntmMember_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Student ID : 633020290-2 "+"\n"+"Name-Surname ","Member 1",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMember_1);

		JMenuItem mntmMember_2 = new JMenuItem("Member 2");
		mntmMember_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Student ID : 633020297-8 "+"\n"+"Name-Surname ","Member 2",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMember_2);
		
		JMenuItem mntmMember_3 = new JMenuItem("Member 3");
		mntmMember_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Student ID : 633020316-0 "+"\n"+"Name-Surname ","Member 3",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMember_3);
		
		JMenuItem mntmMember_4 = new JMenuItem("Member 4");
		mntmMember_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Student ID : 633020323-3 "+"\n"+"Name-Surname ","Member 4",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMember_4);
		
		JMenuItem mntmMember_5 = new JMenuItem("Member 5");
		mntmMember_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"Student ID : 633020452-2 "+"\n"+"Name-Surname ","Member 5",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnNewMenu.add(mntmMember_5);
	

		XYSeries series1 = new XYSeries("Temperature In The Air");

		XYSeries series2 = new XYSeries("Humidity In The Air");

		XYSeries series3 = new XYSeries("Soil Moisture");

		XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        
        
        JFreeChart chart = ChartFactory.createXYLineChart("Soil Moisture & Temperature Humidity In The Air","Time (seconds)", "Infomation", dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(41, 265, 1179, 467);
		contentPane.add(chartPanel);
		
		
		
		JButton connectButton = new JButton("Connect");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connectButton.getText().equals("Connect")) {
					chosenPort = SerialPort.getCommPort(comboBoxPort.getSelectedItem().toString());
					chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
					if(chosenPort.openPort()) {
						connectButton.setText("Disconnect");
						comboBoxPort.setEnabled(false);
					}
					
					Thread thread = new Thread(){
						public void run() {
							Scanner scanner = new Scanner(chosenPort.getInputStream());
							while(scanner.hasNextLine()) {
								try {
									String line = scanner.nextLine();
									String[] info = line.split(",");
									lblTemperature.setText("Temperature = "+info[1]+" *C");
									lblHumidity.setText("Humidity = "+info[0]+" %");
									lblsoilMoisture.setText("Soil moisture = "+info[2]+" %");
									System.out.println(info[0]+" "+info[1]+" "+info[2]);
									
									if (info[1].equals("nan") || info[0].equals("nan") || info[2].equals("nan")) {
										System.out.println("Infomation is nan");
									}else {
										Humidity = line.substring(0, 5);
										Temperature = line.substring(6, 11);
										soilMosi = line.substring(12);
									}
									
									Calendar c = Calendar.getInstance();
							        SimpleDateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
									currentDate = dateTime.format(c.getTime());
									lblDateTime.setText(" Date/Time : " + currentDate);
									
									double number = Double.parseDouble(info[1]);
									series1.add(x++, number);
									double number2 = Double.parseDouble(info[0]);
									series2.add(x++,number2);
									int number3 = Integer.parseInt(info[2]);
									series3.add(x++,number3);
									contentPane.repaint();
							
									String databaseURL = "jdbc:ucanaccess://D:/project 342118 and 342162/Project_1.accdb";
									try {
										Connection conn = DriverManager.getConnection(databaseURL);	
										Statement stment = conn.createStatement();
										System.out.println("Connect Successfully");

										String qry = "SELECT datetime FROM Info WHERE datetime = '"+currentDate+"'";
										ResultSet rs = stment.executeQuery(qry);
										
										if (rs.next()) {
											System.out.println("dateTime repeatedly");
											continue;
										}
										else {
											if (info[1].equals("nan") || info[0].equals("nan") || info[2].equals("nan")) {
												System.out.println("Infomation is nan");
												continue;
											}else {
												String sql = "INSERT INTO Info(datetime,soilMosi,Temperature,Humidity) VALUES  ('"+currentDate+"','"+soilMosi+"','"
														+Temperature+"','"+Humidity+"')";
												stment.execute(sql);
												System.out.println("Inserted Successfully");
											}
											
											
										}
										conn.close();
										stment.close();
									} catch (Exception e) {
										// TODO: handle exception
										e.printStackTrace();
									}

								}catch(Exception e) {}
							}
							scanner.close();
						}
					};
					thread.start();	
				}else {
					chosenPort.closePort();
					comboBoxPort.setEnabled(true);
					connectButton.setText("Connect");
					lblTemperature.setText("Temperature = Please Connect");
					lblHumidity.setText("Humidity = Please Connect");
					lblsoilMoisture.setText("Soil moisture = Please Connect");
					lblDateTime.setText("Date/Time : dd/MM/yyyy HH:mm:ss");
					contentPane.repaint();
				}
				
			}
		});
		connectButton.setBounds(642, 80, 131, 34);
		contentPane.add(connectButton);

	}
}
