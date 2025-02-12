package com.kodnest.project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Arrays extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Labels to show size and position
    private JLabel lblSize;
    private JLabel lblPosition;

    // Button to insert an element
    private JButton btnInsert;
    private JTextField textField; // For array size
    private JTextField textField_1; // For position
    private JTextField textField_2; // For element to insert
    private JTextField txtDisplay; // For displaying output
    private JTextField textField_3; // For displaying array contents

    private int[] array; // The array to hold elements
    private int currentSize; // Current size of the array

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Arrays frame = new Arrays("No message");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * Pass the selected message as a parameter to show on the frame.
     */
    public Arrays(String message) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label to display the selected message
        JLabel lblSelectedMessage = new JLabel("Welcome To Array :");
        lblSelectedMessage.setBounds(121, 0, 201, 37);
        lblSelectedMessage.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblSelectedMessage);

        // Label for size
        lblSize = new JLabel("Array Size: ");
        lblSize.setBounds(10, 46, 112, 37);
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblSize);

        // Label for position
        lblPosition = new JLabel("Element: ");
        lblPosition.setBounds(234, 92, 88, 37);
        lblPosition.setBackground(new Color(240, 240, 240));
        lblPosition.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblPosition);

        // Create the Insert button
        btnInsert = new JButton("Insert");
        btnInsert.setBounds(21, 139, 120, 39);
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnInsert.setBackground(new Color(34, 139, 34)); // Green color
        btnInsert.setForeground(Color.WHITE);
        contentPane.add(btnInsert);

        // Action listener for the Insert button
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertElement();
            }
        });

        // Create the Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(336, 204, 88, 30);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBackground(new Color(255, 99, 71)); // Red shade
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);
        
        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBounds(256, 52, 120, 23);
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnCreate.setBackground(new Color(0, 128, 0)); // Green color
        btnCreate.setForeground(Color.WHITE);
        contentPane.add(btnCreate);
        
        JLabel lblNewLabel_1 = new JLabel("Position:");
        lblNewLabel_1.setBounds(10, 97, 98, 20);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField.setBounds(121, 48, 76, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(121, 97, 76, 30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(314, 92, 86, 30);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(170, 140, 98, 37);
        btnDelete.setBackground(new Color(255, 69, 0)); // Red shade
        btnDelete.setForeground(Color.WHITE);
        contentPane.add(btnDelete);
        
        JButton btnDisplay = new JButton("Display");
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDisplay.setBounds(302, 140, 98, 37);
        btnDisplay.setBackground(new Color(30, 144, 255)); // Blue color
        btnDisplay.setForeground(Color.WHITE);
        contentPane.add(btnDisplay);
        
        txtDisplay = new JTextField();
        txtDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtDisplay.setText("   Display");
        txtDisplay.setBounds(302, 147, 98, 30);
        contentPane.add(txtDisplay);
        txtDisplay.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textField_3.setBounds(21, 205, 305, 30);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

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

        // Action listener for the Create button
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createArray();
            }
        });

        // Action listener for the Delete button
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteElement();
            }
        });

        // Action listener for the Display button
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArray();
            }
        });
    }

    private void createArray() {
        try {
            int size = Integer.parseInt(textField.getText());
            array = new int[size];
            currentSize = 0; // Reset current size
            textField_3.setText("Array created with size: " + size);
        } catch (NumberFormatException e) {
            textField_3.setText("Invalid size input!");
        }
    }

    private void insertElement() {
        if (array == null) {
            textField_3.setText("Create an array first!");
            return;
        }
        try {
            int position = Integer.parseInt(textField_1.getText());
            int element = Integer.parseInt(textField_2.getText());

            if (position < 0 || position >= array.length) {
                textField_3.setText("Invalid position!");
                return;
            }

            if (currentSize < array.length) {
                array[position] = element;
                currentSize++;
                textField_3.setText("Inserted " + element + " at position " + position);
            } else {
                textField_3.setText("Array is full!");
            }
        } catch (NumberFormatException e) {
            textField_3.setText("Invalid input!");
        }
    }

    private void deleteElement() {
        if (array == null) {
            textField_3.setText("Create an array first!");
            return;
        }
        try {
            int position = Integer.parseInt(textField_1.getText());

            if (position < 0 || position >= array.length) {
                textField_3.setText("Invalid position!");
                return;
            }

            // Replace the element at the position with 0
            array[position] = 0;
            textField_3.setText("Element at position " + position + " replaced with 0");
        } catch (NumberFormatException e) {
            textField_3.setText("Invalid input!");
        }
    }

    private void displayArray() {
        if (array == null) {
            textField_3.setText("Create an array first!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }

        textField_3.setText("Array: " + sb.toString());
    }
}
