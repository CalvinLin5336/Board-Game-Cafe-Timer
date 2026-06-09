package desk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.Timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Tables extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private Customer customer1 = new Customer();
	private Customer customer2 = new Customer();
	private Customer customer3 = new Customer();
	private Customer customer4 = new Customer();
	int tableNo=0;
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private JComboBox<String> comboBox3;
	private JComboBox<String> comboBox4;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tables frame = new Tables();
					
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
	public Tables() {
		setTitle("巨匠桌遊店——桌況收銀管理系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 979, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 722, 617);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 337, 282);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 314, 337, 282);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		

		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(375, 10, 337, 282);
		panel_1.add(panel_4);
		


		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(375, 314, 337, 282);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		
		JTextArea textArea1 = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		scrollPane1.setBounds(0, 0, 337, 257); 
		panel_2.add(scrollPane1); 
		
		JTextArea textArea2 = new JTextArea();
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setBounds(0, 0, 337, 257);
		panel_4.add(scrollPane2);
		
		JTextArea textArea3 = new JTextArea();
		JScrollPane scrollPane3 = new JScrollPane(textArea3);
		scrollPane3.setBounds(0, 0, 337, 257);
		panel_3.add(scrollPane3);
		
		JTextArea textArea4 = new JTextArea();
		JScrollPane scrollPane4 = new JScrollPane(textArea4);
		scrollPane4.setBounds(0, 0, 337, 257);
		panel_5.add(scrollPane4);
		
		JTextArea out = new JTextArea();
		out.setBounds(758, 10, 185, 311);
		panel.add(out);

		

		

		

			/******************EVENT*******************/
		
		
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(110, 259, 44, 23);
		panel_2.add(comboBox1);
		
		JButton t1Add = new JButton("桌1加人");
		t1Add.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				customer1.cusEnter();
				
				int currentSer = customer1.ser; 
				comboBox1.addItem(String.valueOf(currentSer)); 
				comboBox1.setSelectedItem(String.valueOf(currentSer));
					
				
			}
		});
		t1Add.setBounds(0, 259, 87, 23);
		panel_2.add(t1Add);
		
		JButton pay1 = new JButton("小計");
		pay1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int[] bill = customer1.getHours();
				int payment1=bill[0]*50;
				int payment2=bill[1]*100;
				int payment3=bill[2]*150;
				int payment4=bill[3]*200;
				int total=payment1+payment2+payment3+payment4;
				out.setText("============================\n" +
					    "        ★ 巨 匠 桌 遊 店 ★       \n" +
					    "============================\n" +
					    "結帳桌號：第 1 桌\n" +
					    "---------------------------------------------\n" +
					    " 項目        單價    人數     金額 \n" +
					    "---------------------------------------------\n" +
					    " 一小時      $50     "+ bill[0] +"  位   $" +payment1+"\n" +
					    " 兩小時      $100   "+ bill[1] +"  位   $" +payment2+"\n" +
					    " 三小時      $150   "+ bill[2] +"  位   $" +payment3+"\n" +
					    " 包日          $200   "+ bill[3] +"  位   $" +payment4+"\n" +
					    "---------------------------------------------\n\n" +
					    "【 應 付 總 金 額 】   $"+total+ "元\n\n" +
					    "============================\n" +
					    "    ※ 離開前請清點隨身物品 ※   \n" +
					    "        謝 謝 惠 顧 ， 歡 迎 再 來     \n" +
					    "============================\n");
				tableNo=1;
				
				
				
				
				
			}
		});
		pay1.setBounds(250, 259, 87, 23);
		panel_2.add(pay1);
		
		JButton btnNewButton_3 = new JButton("刪人");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedSer = comboBox1.getSelectedIndex();
				customer1.deleteCustomer(selectedSer);
				
				
			}
		});
		btnNewButton_3.setBounds(153, 259, 75, 23);
		panel_2.add(btnNewButton_3);
		
		

		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(109, 259, 44, 23);
		panel_4.add(comboBox2);
		
		JButton t2Add = new JButton("桌2加人");
		t2Add.setBounds(0, 259, 87, 23);
		t2Add.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				customer2.cusEnter();
				
				int currentSer = customer2.ser;
				comboBox2.addItem(String.valueOf(currentSer));
				comboBox2.setSelectedItem(String.valueOf(currentSer));
								
			}
		});
		panel_4.setLayout(null);
		panel_4.add(t2Add);
		
		JButton pay2 = new JButton("小計");
		pay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	
				
				int[] bill = customer2.getHours();
				int payment1=bill[0]*50;
				int payment2=bill[1]*100;
				int payment3=bill[2]*150;
				int payment4=bill[3]*200;
				int total=payment1+payment2+payment3+payment4;
				out.setText("============================\n" +
					    "        ★ 巨 匠 桌 遊 店 ★       \n" +
					    "============================\n" +
					    "結帳桌號：第 2 桌\n" +
					    "---------------------------------------------\n" +
					    " 項目        單價    人數     金額 \n" +
					    "---------------------------------------------\n" +
					    " 一小時      $50     "+ bill[0] +"  位   $" +payment1+"\n" +
					    " 兩小時      $100   "+ bill[1] +"  位   $" +payment2+"\n" +
					    " 三小時      $150   "+ bill[2] +"  位   $" +payment3+"\n" +
					    " 包日          $200   "+ bill[3] +"  位   $" +payment4+"\n" +
					    "---------------------------------------------\n\n" +
					    "【 應 付 總 金 額 】   $"+total+ "元\n\n" +
					    "============================\n" +
					    "    ※ 離開前請清點隨身物品 ※   \n" +
					    "        謝 謝 惠 顧 ， 歡 迎 再 來     \n" +
					    "============================\n");
				tableNo=2;
			}
		});
		pay2.setBounds(250, 259, 87, 23);
		panel_4.add(pay2);
		

		
		JButton btnNewButton_4 = new JButton("刪人");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedSer = comboBox2.getSelectedIndex();
				customer2.deleteCustomer(selectedSer);
				
			}
		});
		btnNewButton_4.setBounds(152, 259, 75, 23);
		panel_4.add(btnNewButton_4);
		

		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setBounds(110, 259, 44, 23);
		panel_3.add(comboBox3);
		
		JButton t3Add = new JButton("桌3加人");
		t3Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customer3.cusEnter();
				
				int currentSer = customer3.ser;
				comboBox3.addItem(String.valueOf(currentSer));
				comboBox3.setSelectedItem(String.valueOf(currentSer));
				
			}
		});
		t3Add.setBounds(0, 259, 87, 23);
		panel_3.add(t3Add);
		
		JButton pay3 = new JButton("小計");
		pay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	
	
				
				int[] bill = customer3.getHours();
				int payment1=bill[0]*50;
				int payment2=bill[1]*100;
				int payment3=bill[2]*150;
				int payment4=bill[3]*200;
				int total=payment1+payment2+payment3+payment4;
				out.setText("============================\n" +
					    "        ★ 巨 匠 桌 遊 店 ★       \n" +
					    "============================\n" +
					    "結帳桌號：第 3 桌\n" +
					    "---------------------------------------------\n" +
					    " 項目        單價    人數     金額 \n" +
					    "---------------------------------------------\n" +
					    " 一小時      $50     "+ bill[0] +"  位   $" +payment1+"\n" +
					    " 兩小時      $100   "+ bill[1] +"  位   $" +payment2+"\n" +
					    " 三小時      $150   "+ bill[2] +"  位   $" +payment3+"\n" +
					    " 包日          $200   "+ bill[3] +"  位   $" +payment4+"\n" +
					    "---------------------------------------------\n\n" +
					    "【 應 付 總 金 額 】   $"+total+ "元\n\n" +
					    "============================\n" +
					    "    ※ 離開前請清點隨身物品 ※   \n" +
					    "        謝 謝 惠 顧 ， 歡 迎 再 來     \n" +
					    "============================\n");
				tableNo=3;
				
			}
		});
		pay3.setBounds(250, 259, 87, 23);
		panel_3.add(pay3);
		

		
		JButton btnNewButton_5 = new JButton("刪人");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedSer = comboBox3.getSelectedIndex();
				customer3.deleteCustomer(selectedSer);
				
			}
		});
		btnNewButton_5.setBounds(153, 259, 75, 23);
		panel_3.add(btnNewButton_5);
		

		JComboBox comboBox4 = new JComboBox();
		comboBox4.setBounds(109, 259, 44, 23);
		panel_5.add(comboBox4);
		
		JButton t4Add = new JButton("桌4加人");
		t4Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				customer4.cusEnter();
				int currentSer = customer4.ser;
				comboBox4.addItem(String.valueOf(currentSer));
				comboBox4.setSelectedItem(String.valueOf(currentSer));
				
			}
		});
		t4Add.setBounds(0, 259, 87, 23);
		panel_5.add(t4Add);
		
		JButton pay4 = new JButton("小計");
		pay4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] bill = customer4.getHours();
				int payment1=bill[0]*50;
				int payment2=bill[1]*100;
				int payment3=bill[2]*150;
				int payment4=bill[3]*200;
				int total=payment1+payment2+payment3+payment4;
				out.setText("============================\n" +
					    "        ★ 巨 匠 桌 遊 店 ★       \n" +
					    "============================\n" +
					    "結帳桌號：第 4 桌\n" +
					    "---------------------------------------------\n" +
					    " 項目        單價    人數     金額 \n" +
					    "---------------------------------------------\n" +
					    " 一小時      $50     "+ bill[0] +"  位   $" +payment1+"\n" +
					    " 兩小時      $100   "+ bill[1] +"  位   $" +payment2+"\n" +
					    " 三小時      $150   "+ bill[2] +"  位   $" +payment3+"\n" +
					    " 包日          $200   "+ bill[3] +"  位   $" +payment4+"\n" +
					    "---------------------------------------------\n\n" +
					    "【 應 付 總 金 額 】   $"+total+ "元\n\n" +
					    "============================\n" +
					    "    ※ 離開前請清點隨身物品 ※   \n" +
					    "        謝 謝 惠 顧 ， 歡 迎 再 來     \n" +
					    "============================\n");
				tableNo=4;
				
			}
		});
		pay4.setBounds(250, 259, 87, 23);
		panel_5.add(pay4);
		

		
		JButton btnNewButton_6 = new JButton("刪人");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectSer = comboBox4.getSelectedIndex();
				customer4.deleteCustomer(selectSer);
			}
		});
		btnNewButton_6.setBounds(152, 259, 75, 23);
		panel_5.add(btnNewButton_6);
		

		
		
		//列印
		JButton btnNewButton = new JButton("結帳並列印");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
if (out.getText().trim().isEmpty()) {
					

					javax.swing.JOptionPane.showMessageDialog(
							Tables.this, 
							"請先按下 [小計]，確認明細後再按結帳！", 
							"系統提示", 
							javax.swing.JOptionPane.WARNING_MESSAGE
					);
					
					return; 
				}
				
				
				try {
					
					
					out.print();
					switch(tableNo){
					case 1:
						customer1.ser=0;
						out.setText("");
						break;
					case 2:
						customer2.ser=0;
						out.setText("");
						break;
					case 3:
						customer3.ser=0;
						out.setText("");
						break;
					case 4:
						customer4.ser=0;
						out.setText("");
				}

					
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(765, 341, 178, 82);
		panel.add(btnNewButton);
		
		//清除
		JButton btnNewButton_1 = new JButton("取消小計");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				out.setText("");	
				
			}
		});
		btnNewButton_1.setBounds(765, 433, 178, 82);
		panel.add(btnNewButton_1);
		
		//關閉
		JButton btnNewButton_2 = new JButton("關閉");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(765, 525, 178, 82);
		panel.add(btnNewButton_2);
		
		
		
		
		
		
		
		
		
		
		

		
		JLabel time2 = new JLabel("");
		time2.setBounds(758, 10, 211, 15);
		panel.add(time2);
		
			//測試
			String[] tables = { "請選擇桌號", "第 1 桌", "第 2 桌", "第 3 桌", "第 4 桌" };
			JComboBox comboBox = new JComboBox(tables);
			comboBox.setBounds(681, 643, 87, 23);
			contentPane.add(comboBox);
			
			
			JButton btnAddHour = new JButton("測試用:入場時間往前1小時");
			btnAddHour.setBounds(778, 637, 178, 35);
			contentPane.add(btnAddHour);
			
	
			btnAddHour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int selectedNo = comboBox.getSelectedIndex();
					
					
					
					switch(selectedNo) {
						case 1:
							customer1.passOneHour();
							break;
						case 2:
							customer2.passOneHour();
							break;
						case 3:
							customer3.passOneHour();
							break;
						case 4:
							customer4.passOneHour();
							break;
					}
					
					
				}
			});
		
		DateTimeFormatter now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Timer timer = new Timer(100, e ->{
			
		time2.setText("現在時間: " + LocalDateTime.now().format(now));
		customer1.refreshTable(textArea1);
	    customer2.refreshTable(textArea2);
	    customer3.refreshTable(textArea3);
	    customer4.refreshTable(textArea4);
		
		});
		timer.start();
		
	}
}
