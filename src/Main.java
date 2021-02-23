import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cmbThuatToan;
	private JTextArea txtChuoi;
	private JTextArea txtKQ;
	private JTextArea txtKeyDec;
	private JTextArea txtKeyEnc;
	private String chuoiMH;
	private String chuoiGM;
	private String keyMH;
	private String keyGM;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1070, 812);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ch\u1ECDn thu\u1EADt to\u00E1n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 310, 129, 25);
		contentPane.add(lblNewLabel);
		
		txtChuoi = new JTextArea();
		txtChuoi.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtChuoi.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtChuoi.setBounds(12, 60, 1028, 128);
		contentPane.add(txtChuoi);
		
		txtKQ = new JTextArea();
		txtKQ.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtKQ.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtKQ.setBounds(12, 401, 1028, 230);
		contentPane.add(txtKQ);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp chu\u1ED7i c\u1EA7n m\u00E3 h\u00F3a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 13, 305, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 372, 118, 25);
		contentPane.add(lblNewLabel_2);
		
		DefaultComboBoxModel<String> type = new DefaultComboBoxModel<String>();
		type.addElement("Hill Cipher");
		type.addElement("Mono Alphabetic Cipher");
		type.addElement("Transposition Cipher");
		type.addElement("Vigenere Cipher");
		type.addElement("Ceasar");
		
		cmbThuatToan = new JComboBox<String>(type);
		cmbThuatToan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmbThuatToan.getSelectedIndex() == 1) {
					txtKeyEnc.setEnabled(false);
					txtKeyEnc.setBackground(Color.LIGHT_GRAY);
					txtKeyDec.setEnabled(false);
					txtKeyDec.setBackground(Color.LIGHT_GRAY);
				}
				else {
					txtKeyEnc.setEnabled(true);
					txtKeyEnc.setBackground(Color.WHITE);
					txtKeyDec.setEnabled(true);
					txtKeyDec.setBackground(Color.WHITE);
				}
			}
		});
		cmbThuatToan.setForeground(Color.WHITE);
		cmbThuatToan.setBackground(Color.DARK_GRAY);
		cmbThuatToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbThuatToan.setBounds(12, 337, 230, 22);
		contentPane.add(cmbThuatToan);
		
		JButton btnEncrypt = new JButton("Encryption");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEncryptactionPerformed(e);
			}
		});
		btnEncrypt.setForeground(Color.WHITE);
		btnEncrypt.setBackground(Color.DARK_GRAY);
		btnEncrypt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEncrypt.setBounds(254, 336, 137, 25);
		contentPane.add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("Decryption");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDecryptactionPerformed(e);
			}
		});
		btnDecrypt.setForeground(Color.WHITE);
		btnDecrypt.setBackground(Color.DARK_GRAY);
		btnDecrypt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDecrypt.setBounds(403, 337, 137, 25);
		contentPane.add(btnDecrypt);
		
		JLabel lblNewLabel_2_1 = new JLabel("Key (nếu có)");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(12, 644, 118, 25);
		contentPane.add(lblNewLabel_2_1);
		
		txtKeyDec = new JTextArea();
		txtKeyDec.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtKeyDec.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtKeyDec.setBounds(12, 673, 1028, 79);
		contentPane.add(txtKeyDec);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Key (nếu có)");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(12, 201, 118, 25);
		contentPane.add(lblNewLabel_2_1_1);
		
		txtKeyEnc = new JTextArea();
		txtKeyEnc.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtKeyEnc.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtKeyEnc.setBounds(12, 230, 1028, 79);
		contentPane.add(txtKeyEnc);
		
		JButton btnSwap = new JButton("Hoán đổi");
		btnSwap.setForeground(Color.WHITE);
		btnSwap.setBackground(Color.DARK_GRAY);
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSwapactionPerformed(e);
			}
		});
		btnSwap.setBounds(930, 337, 97, 25);
		contentPane.add(btnSwap);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtChuoi.setText("");
				txtKeyDec.setText("");
				txtKeyEnc.setText("");
				txtKQ.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(Color.DARK_GRAY);
		btnClear.setBounds(821, 337, 97, 25);
		contentPane.add(btnClear);
	}
	
	
	private void HillCipher() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần mã hóa trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else {
			
			HillCipher hillcipher = new HillCipher();
	        double sq = Math.sqrt(keyMH.length());
	        if (sq != (long) sq)
	            JOptionPane.showMessageDialog(null, "Invalid key length!!! Does not form a square matrix...");
	        else
	        {
	            int s = (int) sq;
	            if (hillcipher.check(keyMH, s))
	            {
	                hillcipher.divide(chuoiMH, s);
	                hillcipher.cofact(hillcipher.keymatrix, s);
	                chuoiGM = hillcipher.kq;
	                keyGM = hillcipher.key;
	                txtKQ.setText(chuoiGM);
	                txtKeyDec.setText(keyGM);
	            }
	        }
		}
	}
	
	
	private void doEncMonoalphabeticCipher() {
		chuoiMH = txtChuoi.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần mã hóa trước!");
		}
		else {
			
			MonoalphabeticCipher mono = new MonoalphabeticCipher();
	        chuoiGM = mono.doEncryption(chuoiMH.toLowerCase());
	        txtKQ.setText(chuoiGM);
	        
		}
	}
	
	
	private void doDecMonoalphabeticCipher() {
		chuoiMH = txtChuoi.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần giải mã trước!");
		}
		else {
			
			MonoalphabeticCipher mono = new MonoalphabeticCipher();
	        chuoiGM = mono.doDecryption(chuoiMH);
	        txtKQ.setText(chuoiGM);
	        
		}
	}
	
	
	private void doEncTranspositionCipher() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần mã hóa trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else {
			
			TranspositionCipher tc = new TranspositionCipher(keyMH);
	        chuoiGM = tc.doEncryption(chuoiMH);
	        txtKQ.setText(chuoiGM);
	        keyGM = keyMH;
	        txtKeyDec.setText(keyGM);
		}
	}
	
	
	private void doDecTranspositionCipher() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần giải mã trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else {
			
			TranspositionCipher tc = new TranspositionCipher(keyMH);
	        chuoiGM = tc.doDecryption(chuoiMH);
	        txtKQ.setText(chuoiGM);
	        keyGM = keyMH;
	        txtKeyDec.setText(keyGM);
		}
	}
	
	
	private void doEncVigenereCipher() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần mã hóa trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else {
			
			VigenereCipher vc = new VigenereCipher(keyMH);
	        chuoiGM = vc.encrypt(chuoiMH);
	        txtKQ.setText(chuoiGM);
	        keyGM = keyMH;
	        txtKeyDec.setText(keyGM);
		}
	}
	
	
	private void doDecVigenereCipher() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần giải mã trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else {
			
			VigenereCipher vc = new VigenereCipher(keyMH);
	        chuoiGM = vc.decrypt(chuoiMH);
	        txtKQ.setText(chuoiGM);
	        keyGM = keyMH;
	        txtKeyDec.setText(keyGM);
		}
	}
	
	private void doEncCeasar() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		int k = 0;
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần mã hóa trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else if(!keyMH.isEmpty()) {
			try {
				k = Integer.parseInt(keyMH);
				Ceasar cs = new Ceasar();
		        chuoiGM = cs.encrypt(chuoiMH, k);
		        txtKQ.setText(chuoiGM);
		        keyGM = keyMH;
		        txtKeyDec.setText(keyMH);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Key phải là một số!");
			}
		}
	}
	
	public void doDecCeasar() {
		chuoiMH = txtChuoi.getText();
		keyMH = txtKeyEnc.getText();
		int k = 0;
		if(chuoiMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mời nhập vào chuỗi cần giải mã trước!");
		}
		else if(keyMH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập key!");
		}
		else if(!keyMH.isEmpty()) {
			try {
				k = Integer.parseInt(keyMH);
				Ceasar cs = new Ceasar();
		        chuoiGM = cs.decrypt(chuoiMH, k);
		        txtKQ.setText(chuoiGM);
		        keyGM = keyMH;
		        txtKeyDec.setText(keyMH);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Key phải là một số!");
			}
		}
	}
	
	
	private void btnEncryptactionPerformed(ActionEvent e) {
		int choise = cmbThuatToan.getSelectedIndex();
		if(choise != -1) {
			switch (choise){
			case 0:
				this.HillCipher();
				break;
			case 1:
				this.doEncMonoalphabeticCipher();
				break;
			case 2:
				this.doEncTranspositionCipher();
				break;
			case 3:
				this.doEncVigenereCipher();
				break;
			case 4:
				this.doEncCeasar();
				break;
			default:
				break;
			}
		}
	}
	
	
	private void btnDecryptactionPerformed(ActionEvent e) {
		int choise = cmbThuatToan.getSelectedIndex();
		if(choise != -1) {
			switch (choise){
			case 0:
				this.HillCipher();
				break;
			case 1:
				this.doDecMonoalphabeticCipher();
				break;
			case 2:
				this.doDecTranspositionCipher();
				break;
			case 3:
				this.doDecVigenereCipher();
				break;
			case 4:
				this.doDecCeasar();
				break;
			default:
				break;
			}
		}
	}
	
	private void btnSwapactionPerformed(ActionEvent e) {
		txtChuoi.setText(chuoiGM);
		txtKeyEnc.setText(keyGM);
//		txtKQ.setText(chuoiMH);
//		txtKeyDec.setText(keyMH);
		
	}
	
	public Main() {
		setTitle("Mã Hóa");
		initComponent();
	}
}
