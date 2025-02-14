package com.kodnest.project;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Queue extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblSelectedMessage;
    private JTextField txtElement;
    private JTextField txtQueueDisplay;
    private JTextField txtSize;

    private int[] queue;
    private int front, rear, size;

    // Constructor accepting the message
    public Queue(String message) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400); // Increased height for better spacing
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label to show the message passed from the home screen
        lblSelectedMessage = new JLabel("Welcome To Queue:");
        lblSelectedMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSelectedMessage.setBounds(120, 10, 220, 30);
        contentPane.add(lblSelectedMessage);

        // Label for size of queue
        JLabel lblSize = new JLabel("Size of Queue:");
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSize.setBounds(30, 58, 120, 30);
        contentPane.add(lblSize);

        // Text field for queue size input
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

        // Text field to display queue contents
        txtQueueDisplay = new JTextField();
        txtQueueDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtQueueDisplay.setBounds(20, 257, 391, 52); // Adjusted width for better visibility
        contentPane.add(txtQueueDisplay);
        txtQueueDisplay.setColumns(10);
        txtQueueDisplay.setEditable(false); // Disable editing the display area

        // Create Queue button
        JButton btnCreate = new JButton("Create Queue");
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCreate.setBackground(new Color(34, 139, 34)); // Green color
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setBounds(281, 72, 130, 30);
        contentPane.add(btnCreate);

        // Enqueue button
        JButton btnEnqueue = new JButton("Enqueue");
        btnEnqueue.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEnqueue.setBackground(new Color(34, 139, 34)); // Green color
        btnEnqueue.setForeground(Color.WHITE);
        btnEnqueue.setBounds(20, 165, 110, 40);
        contentPane.add(btnEnqueue);

        // Dequeue button
        JButton btnDequeue = new JButton("Dequeue");
        btnDequeue.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDequeue.setBackground(new Color(255, 69, 0)); // Red color
        btnDequeue.setForeground(Color.WHITE);
        btnDequeue.setBounds(160, 165, 100, 40);
        contentPane.add(btnDequeue);

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
        btnDisplay.setBounds(160, 216, 100, 30);
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
                createQueue();
            }
        });

        btnEnqueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enqueueElement();
            }
        });

        btnDequeue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dequeueElement();
            }
        });

        btnPeek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                peekElement();
            }
        });

        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayQueue();
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

    // Method to create the queue
    private void createQueue() {
        try {
            size = Integer.parseInt(txtSize.getText());
            queue = new int[size];
            front = -1;
            rear = -1;
            txtQueueDisplay.setText("Queue created with size: " + size);
        } catch (NumberFormatException e) {
            txtQueueDisplay.setText("Invalid size input!");
        }
    }

    // Method to enqueue an element into the queue
    private void enqueueElement() {
        try {
            int element = Integer.parseInt(txtElement.getText());

            if (rear == size - 1) {
                txtQueueDisplay.setText("Queue is full!");
            } else {
                if (front == -1) {
                    front = 0; // If the queue is empty
                }
                queue[++rear] = element;
                txtQueueDisplay.setText("Enqueued " + element + " into the queue.");
            }
        } catch (NumberFormatException e) {
            txtQueueDisplay.setText("Invalid element input!");
        }
    }

    // Method to dequeue an element from the queue
    private void dequeueElement() {
        if (front == -1 || front > rear) {
            txtQueueDisplay.setText("Queue is empty!");
        } else {
            int dequeuedElement = queue[front++];
            txtQueueDisplay.setText("Dequeued " + dequeuedElement + " from the queue.");
        }
    }

    // Method to peek at the front element of the queue
    private void peekElement() {
        if (front == -1 || front > rear) {
            txtQueueDisplay.setText("Queue is empty!");
        } else {
            txtQueueDisplay.setText("Front element: " + queue[front]);
        }
    }

    // Method to display the current elements in the queue
    private void displayQueue() {
        if (front == -1 || front > rear) {
            txtQueueDisplay.setText("Queue is empty!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = front; i <= rear; i++) {
                sb.append(queue[i]).append(" ");
            }
            txtQueueDisplay.setText("Queue: " + sb.toString());
        }
    }
}
