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

public class LinkedList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JLabel lblSelectedMessage;
    private JTextField txtElement;
    private JTextField txtDisplay;

    // Node class for linked list
    class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor accepting the message
    public LinkedList(String message) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400); // Increased height for better spacing
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label to show the message passed from the home screen
        lblSelectedMessage = new JLabel("Welcome To LinkedList:");
        lblSelectedMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSelectedMessage.setBounds(105, 10, 235, 40);
        contentPane.add(lblSelectedMessage);

        // Label for element input
        JLabel lblElement = new JLabel("Element:");
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblElement.setBounds(32, 75, 120, 30);
        contentPane.add(lblElement);

        // Text field for element input
        txtElement = new JTextField();
        txtElement.setBounds(160, 72, 100, 40);
        contentPane.add(txtElement);
        txtElement.setColumns(10);

        // Text field to display the list contents
        txtDisplay = new JTextField();
        txtDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtDisplay.setBounds(20, 257, 391, 45); // Adjusted width for better visibility
        contentPane.add(txtDisplay);
        txtDisplay.setColumns(10);
        txtDisplay.setEditable(false); // Disable editing the display area

        // Insert button
        JButton btnInsert = new JButton("Insert");
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnInsert.setBackground(new Color(34, 139, 34)); // Green color
        btnInsert.setForeground(Color.WHITE);
        btnInsert.setBounds(20, 150, 110, 40);
        contentPane.add(btnInsert);

        // Delete button
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBackground(new Color(255, 69, 0)); // Red color
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(160, 150, 100, 40);
        contentPane.add(btnDelete);

        // Display button
        JButton btnDisplay = new JButton("Display");
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDisplay.setBackground(new Color(30, 144, 255)); // Blue color
        btnDisplay.setForeground(Color.WHITE);
        btnDisplay.setBounds(160, 209, 100, 37);
        contentPane.add(btnDisplay);

        // Search button
        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSearch.setBackground(new Color(30, 144, 255)); // Blue color
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(300, 150, 100, 30);
        contentPane.add(btnSearch);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBackground(new Color(255, 99, 71)); // Red shade
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(336, 320, 88, 30);
        contentPane.add(btnBack);

        // Action listeners for buttons
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertElement();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteElement();
            }
        });

        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayList();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchElement();
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

    // Method to insert an element at the end of the list
    private void insertElement() {
        try {
            int element = Integer.parseInt(txtElement.getText());

            Node newNode = new Node(element);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            txtDisplay.setText("Inserted " + element + " into the linked list.");
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid element input!");
        }
    }

    // Method to delete an element from the list
    private void deleteElement() {
        try {
            if (head == null) {
                txtDisplay.setText("The list is empty!");
            } else {
                int deletedElement = head.data;
                head = head.next;
                txtDisplay.setText("Deleted element: " + deletedElement);
            }
        } catch (Exception e) {
            txtDisplay.setText("Error deleting element!");
        }
    }

    // Method to display the entire list
    private void displayList() {
        if (head == null) {
            txtDisplay.setText("The list is empty!");
        } else {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }
            txtDisplay.setText("List: " + sb.toString());
        }
    }

    // Method to search for an element in the list
    private void searchElement() {
        try {
            int element = Integer.parseInt(txtElement.getText());

            Node current = head;
            while (current != null) {
                if (current.data == element) {
                    txtDisplay.setText("Found element: " + element);
                    return;
                }
                current = current.next;
            }

            txtDisplay.setText("Element not found!");
        } catch (NumberFormatException e) {
            txtDisplay.setText("Invalid element input!");
        }
    }
}
