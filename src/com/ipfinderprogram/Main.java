package com.ipfinderprogram;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class Main extends JFrame {
    private JButton btnSubmit;
    private JTextField fieldIp;
    private JLabel text, rensponse;

    Main() {
        setTitle("IP Finder");
        setSize(400, 200);
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        setLayout(null);

        text = new JLabel("Enter IP:");
        text.setBounds(10, 10, 80, 25); // Set the bounds (x, y, width, height)

        fieldIp = new JTextField(14);
        fieldIp.setBounds(100, 10, 160, 25);

        rensponse = new JLabel("");
        rensponse.setBounds(10, 80, 80, 25);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(10, 50, 80, 25);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = fieldIp.getText();
                try {
                    URI uri = new URI(url);
                    String hostname = uri.getHost();
                    InetAddress ipAddress = InetAddress.getByName(hostname);
                    String ip = ipAddress.getHostAddress();
                    rensponse.setText(ip);
                    System.out.println(ip);
                } catch (URISyntaxException | UnknownHostException ex) {
                    System.out.println("Unknown host: " + url);
                }

            }
        });

        add(rensponse);
        add(text);
        add(fieldIp);
        add(btnSubmit);
    }

    public static void main(String[] args) {
        new Main();
    }
}
