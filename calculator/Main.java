package com.calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private Process process;
	private JLabel lblDisplayInput;

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
	public Main() {
		setResizable(false);
		setTitle("Calculator Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 492);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDisplayInput = new JLabel("");
		lblDisplayInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayInput.setBounds(10, 11, 543, 26);
		contentPane.add(lblDisplayInput);
		
		txtInput = new JTextField();
		txtInput.setText("0");
		txtInput.setEditable(false);
		txtInput.setHorizontalAlignment(SwingConstants.RIGHT);
		txtInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtInput.setBounds(10, 38, 543, 50);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 99, 543, 343);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 5, 10, 10));
		
		JButton btnReset = new JButton("AC");
		btnReset.addActionListener(e -> reset());
		btnReset.setFocusable(false);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBackground(new Color(255, 160, 122));
		panel.add(btnReset);
		
		JButton btnSign = new JButton("+/-");
		btnSign.addActionListener(e -> 
				txtInput.setText(process.addSign(txtInput.getText())));
		btnSign.setFocusable(false);
		btnSign.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSign.setBackground(new Color(255, 160, 122));
		panel.add(btnSign);
		
		JButton btnModulo = new JButton("%");
		btnModulo.addActionListener(e -> equation(e));
		btnModulo.setFocusable(false);
		btnModulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModulo.setBackground(new Color(255, 160, 122));
		panel.add(btnModulo);
		
		JButton btnMultiplication = new JButton("*");
		btnMultiplication.addActionListener(e -> equation(e));
		btnMultiplication.setFocusable(false);
		btnMultiplication.setBackground(new Color(255, 160, 122));
		btnMultiplication.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnMultiplication);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(e -> numberInput(e));
		btn7.setFocusable(false);
		btn7.setBackground(new Color(210, 180, 140));
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(e -> numberInput(e));
		btn8.setFocusable(false);
		btn8.setBackground(new Color(210, 180, 140));
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(e -> numberInput(e));
		btn9.setFocusable(false);
		btn9.setBackground(new Color(210, 180, 140));
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn9);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(e -> equation(e));
		btnDivision.setFocusable(false);
		btnDivision.setBackground(new Color(255, 160, 122));
		btnDivision.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnDivision);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(e -> numberInput(e));
		btn4.setFocusable(false);
		btn4.setBackground(new Color(210, 180, 140));
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(e -> numberInput(e));
		btn5.setFocusable(false);
		btn5.setBackground(new Color(210, 180, 140));
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(e -> numberInput(e));
		btn6.setFocusable(false);
		btn6.setBackground(new Color(210, 180, 140));
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn6);
		
		JButton btnAddition = new JButton("+");
		btnAddition.addActionListener(e -> equation(e));
		btnAddition.setFocusable(false);
		btnAddition.setBackground(new Color(255, 160, 122));
		btnAddition.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnAddition);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(e -> numberInput(e));
		btn1.setFocusable(false);
		btn1.setBackground(new Color(210, 180, 140));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(e -> numberInput(e));
		btn2.setFocusable(false);
		btn2.setBackground(new Color(210, 180, 140));
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(e -> numberInput(e));
		btn3.setFocusable(false);
		btn3.setBackground(new Color(210, 180, 140));
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn3);
		
		JButton btnSubtraction = new JButton("-");
		btnSubtraction.addActionListener(e -> equation(e));
		btnSubtraction.setFocusable(false);
		btnSubtraction.setBackground(new Color(255, 160, 122));
		btnSubtraction.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnSubtraction);
		
		JButton btnDelete = new JButton("DEL.");
		btnDelete.addActionListener(e -> 
				  txtInput.setText(process.reduceString(txtInput.getText())));
		btnDelete.setBackground(new Color(255, 160, 122));
		btnDelete.setFocusable(false);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnDelete);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(e -> numberInput(e));
		btn0.setFocusable(false);
		btn0.setBackground(new Color(210, 180, 140));
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btn0);
		
		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(e -> 
				   txtInput.setText(process.addDecimal(txtInput.getText())));
		btnDecimal.setBackground(new Color(255, 160, 122));
		btnDecimal.setFocusable(false);
		btnDecimal.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnDecimal);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(e -> result());
		btnEqual.setFocusable(false);
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEqual.setBackground(new Color(255, 160, 122));
		panel.add(btnEqual);
		
		process = new Process();
	} 
	// Methods.
	private String getResult() {
		return process.getResult(Double.parseDouble(process.getInput()),
				Double.parseDouble(txtInput.getText()),
				process.getEquation());
	}
	
	private void result() {
		lblDisplayInput.setText(getResult());
		txtInput.setText(getResult());
		process.setIsResult(true);
		process.setEquation(' ');
	}
	
	private void numberInput(ActionEvent e) {
		if (process.getIsResult()) {
			process.setIsResult(false);
			txtInput.setText("0");
		}
		txtInput.setText(process.displayInput(txtInput.getText() +
				e.getActionCommand()));
	}
	
	private void equation(ActionEvent e) {
		String string;
		
		if (process.getEquation() == ' ') {
			string = "0";
			process.setInput(Double.parseDouble(txtInput.getText()));
		} else {
			process.setIsResult(true);
			string = getResult();
			process.setInput(Double.parseDouble(string));
			process.setEquation(' ');
		}
		
		process.setEquation(e.getActionCommand().charAt(0));
		txtInput.setText(string);
		lblDisplayInput.setText(process.getInput() + " " + process.getEquation());
	}
	
	private void reset() {
		txtInput.setText("0");
		lblDisplayInput.setText("0");
		process.setEquation(' ');
	}
}
