package com.kodnest.project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LinearDataStructersHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Ensure that Swing components are created on the Event Dispatch Thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			     		// Instantiate the frame
				     	LinearDataStructersHome frame = new LinearDataStructersHome();
			     		frame.setVisible(true); // Make the frame visible
				} catch (Exception e) {
					e.printStackTrace(); // Print the exception if it occurs
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LinearDataStructersHome() {
		setTitle("Home.java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// Set background color of the content pane to light pink (softer shade)
		getContentPane().setBackground(new Color(255, 200, 210)); // Softer light pink background

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Message label at the top
		lblMessage = new JLabel("Change your DS");
		lblMessage.setForeground(Color.CYAN);
		lblMessage.setBounds(119, 11, 195, 39);
		lblMessage.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		contentPane.add(lblMessage);

		JButton btnArray = new JButton("ARRAY");
		btnArray.setBounds(50, 61, 120, 30);
		btnArray.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnArray.setBackground(new Color(70, 130, 180)); // Steel blue button background
		btnArray.setForeground(Color.WHITE); // White text
		contentPane.add(btnArray);
		btnArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Arrays.java frame and pass the message
				Arrays arrayFrame = new Arrays("You selected: Array");
				arrayFrame.setVisible(true);
				// Optionally, hide the current window
				setVisible(false);
			}
		});

		// Button for Stack
		JButton btnStack = new JButton("STACK");
		btnStack.setBounds(231, 61, 120, 30);
		btnStack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStack.setBackground(new Color(255, 99, 71)); // Tomato color button background
		btnStack.setForeground(Color.WHITE); // White text
		contentPane.add(btnStack);
		btnStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Stack.java frame and pass the message
				Stack stackFrame = new Stack("You selected: Stack");
				stackFrame.setVisible(true);
				// Optionally, hide the current window
				setVisible(false);
			}
		});

		// Button for Queue
		JButton btnQueue = new JButton("QUEUE");
		btnQueue.setBounds(50, 120, 120, 30);
		btnQueue.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQueue.setBackground(new Color(34, 139, 34)); // green button background
		btnQueue.setForeground(Color.WHITE); // White text
		contentPane.add(btnQueue);
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Queue.java frame and pass the message
				Queue queueFrame = new Queue("You selected: Queue");
				queueFrame.setVisible(true);
				// Optionally,hide the current window
				setVisible(false);
			}
		});

		// Button for Circular Queue
		JButton btnCircularQueue = new JButton("CIRCULAR QUEUE");
		btnCircularQueue.setBounds(131, 171, 172, 30);
		btnCircularQueue.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCircularQueue.setBackground(new Color(255, 165, 0)); // Orange button background
		btnCircularQueue.setForeground(Color.WHITE); // White text
		contentPane.add(btnCircularQueue);
		btnCircularQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open CircularQueue.java frame and pass the message
				CircularQueue circularQueueFrame = new CircularQueue("You selected: Circular Queue");
				circularQueueFrame.setVisible(true);
				// Optionally, hide the current window
				setVisible(false);
			}
		});

		// Button for LinkedList
		JButton btnLinkedList = new JButton("LINKEDLIST");
		btnLinkedList.setBounds(231, 120, 131, 30);
		btnLinkedList.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLinkedList.setBackground(new Color(255, 223, 0)); // Yellow button background
		btnLinkedList.setForeground(Color.WHITE); // White text
		contentPane.add(btnLinkedList);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sohail Shaik\\Downloads\\check2.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
		btnLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open LinkedList.java frame and pass the message
				LinkedList linkedListFrame = new LinkedList("You selected: LinkedList");
				linkedListFrame.setVisible(true);
				// Optionally, hide the current window
				setVisible(false);
			}
		});

	}
}
