package com.kodnest.project;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Label to show the selected message
    private JLabel lblSelectedMessage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LinkedList frame = new LinkedList("No message");
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
    public LinkedList(String message) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblSelectedMessage = new JLabel(message);  // Set the passed message
        lblSelectedMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSelectedMessage.setBounds(100, 100, 300, 30); // Set the position of the label
        contentPane.add(lblSelectedMessage);
        
        // Create the Back button
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBounds(150, 150, 120, 30); // Set button position and size
        contentPane.add(btnBack);

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
}

        
        
 

