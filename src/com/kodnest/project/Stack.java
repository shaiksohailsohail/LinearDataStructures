package com.kodnest.project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class Stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSelectedMessage;
	private JTextField txtElement;
	private JTextField txtStackDisplay;
	private JTextField txtSize;

	private int[] stack;
	private int top;

	// Constructor accepting the message
	public Stack(String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400); // Increased height for better spacing
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Label to show the message passed from the home screen
		lblSelectedMessage = new JLabel("Welcome To Stack:");
		lblSelectedMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectedMessage.setBounds(106, 11, 234, 29);
		contentPane.add(lblSelectedMessage);

		// Label for size of stack
		JLabel lblSize = new JLabel("Size of Stack:");
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSize.setBounds(30, 58, 120, 30);
		contentPane.add(lblSize);

		// Text field for stack size input
		txtSize = new JTextField();
		txtSize.setBounds(160, 58, 100, 30);
		contentPane.add(txtSize);
		txtSize.setColumns(10);

		// Label for element input
		JLabel lblElement = new JLabel("Element:");
		lblElement.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblElement.setBounds(30, 99, 120, 30);
		contentPane.add(lblElement);

		// Text field for element input
		txtElement = new JTextField();
		txtElement.setBounds(160, 101, 100, 30);
		contentPane.add(txtElement);
		txtElement.setColumns(10);

		// Text field to display stack contents
		txtStackDisplay = new JTextField();
		txtStackDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtStackDisplay.setBounds(20, 264, 391, 50); // Adjusted width for better visibility
		contentPane.add(txtStackDisplay);
		txtStackDisplay.setColumns(10);
		txtStackDisplay.setEditable(false); // Disable editing the display area

		// Create Stack button
		JButton btnCreate = new JButton("Create Stack");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreate.setBackground(new Color(34, 139, 34)); // Green color
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBounds(281, 72, 130, 40);
		contentPane.add(btnCreate);

		// Push button
		JButton btnPush = new JButton("Push");
		btnPush.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPush.setBackground(new Color(34, 139, 34)); // Green color
		btnPush.setForeground(Color.WHITE);
		btnPush.setBounds(20, 165, 110, 40);
		contentPane.add(btnPush);

		// Pop button
		JButton btnPop = new JButton("Pop");
		btnPop.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPop.setBackground(new Color(255, 69, 0)); // Red color
		btnPop.setForeground(Color.WHITE);
		btnPop.setBounds(160, 165, 100, 40);
		contentPane.add(btnPop);

		// Peek button
		JButton btnPeek = new JButton("Peek");
		btnPeek.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPeek.setBackground(new Color(30, 144, 255)); // Blue color
		btnPeek.setForeground(Color.WHITE);
		btnPeek.setBounds(300, 165, 100, 40);
		contentPane.add(btnPeek);

		// Display button
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplay.setBackground(new Color(30, 144, 255)); // Blue color
		btnDisplay.setForeground(Color.WHITE);
		btnDisplay.setBounds(160, 216, 100, 37);
		contentPane.add(btnDisplay);

		// Back button
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(255, 99, 71)); // Red shade
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(323, 320, 88, 30);
		contentPane.add(btnBack);

		// Action listeners for buttons
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStack();
			}
		});

		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pushElement();
			}
		});

		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popElement();
			}
		});

		btnPeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peekElement();
			}
		});

		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayStack();
			}
		});

		// Action listener for the Back button
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Close the current frame
				setVisible(false);

				// Create and show the Home page (LinearDataStructersHome)
				LinearDataStructersHome homeFrame = new LinearDataStructersHome();
				homeFrame.setVisible(true);
			}
		});
	}

	// Method to create the stack
	private void createStack() {
		try {
			int size = Integer.parseInt(txtSize.getText());
			stack = new int[size];
			top = -1;
			txtStackDisplay.setText("Stack created with size: " + size);
		} catch (NumberFormatException e) {
			txtStackDisplay.setText("Invalid size input!");
		}
	}

	// Method to push an element onto the stack
	private void pushElement() {
		try {
			int element = Integer.parseInt(txtElement.getText());

			if (top == stack.length - 1) {
				txtStackDisplay.setText("Stack is full!");
			} else {
				stack[++top] = element;
				txtStackDisplay.setText("Pushed " + element + " onto the stack.");
			}
		} catch (NumberFormatException e) {
			txtStackDisplay.setText("Invalid element input!");
		}
	}

	// Method to pop an element from the stack
	private void popElement() {
		if (top == -1) {
			txtStackDisplay.setText("Stack is empty!");
		} else {
			int poppedElement = stack[top--];
			txtStackDisplay.setText("Popped " + poppedElement + " from the stack.");
		}
	}

	// Method to peek the top element of the stack
	private void peekElement() {
		if (top == -1) {
			txtStackDisplay.setText("Stack is empty!");
		} else {
			txtStackDisplay.setText("Top element: " + stack[top]);
		}
	}

	// Method to display the current elements in the stack
	private void displayStack() {
		if (top == -1) {
			txtStackDisplay.setText("Stack is empty!");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= top; i++) {
				sb.append(stack[i]).append(" ");
			}
			txtStackDisplay.setText("Stack: " + sb.toString());
		}
	}
}
