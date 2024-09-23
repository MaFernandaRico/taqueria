/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taqueria2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Recompensa extends JFrame {
    private JTextField recompensaIdField, clienteIdField, nivelClienteField, puntosAcumuladosField, fechaActualizacionField;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private JTable recompensaTable;
    private DefaultTableModel model;

    public Recompensa() {
        setTitle("CRUD de Recompensas - Taquería");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Color bgColor = new Color(240, 248, 255);
        Color buttonColor = new Color(0, 150, 136);
        Color buttonHoverColor = new Color(38, 166, 154);
        Color textColor = Color.WHITE;
        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(bgColor);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(bgColor);

        formPanel.add(new JLabel("Recompensa ID:"));
        recompensaIdField = new JTextField();
        recompensaIdField.setEnabled(false);
        formPanel.add(recompensaIdField);

        formPanel.add(new JLabel("Cliente ID:"));
        clienteIdField = new JTextField();
        formPanel.add(clienteIdField);

        formPanel.add(new JLabel("Nivel Cliente:"));
        nivelClienteField = new JTextField();
        formPanel.add(nivelClienteField);

        formPanel.add(new JLabel("Puntos Acumulados:"));
        puntosAcumuladosField = new JTextField();
        formPanel.add(puntosAcumuladosField);

        formPanel.add(new JLabel("Fecha Actualización:"));
        fechaActualizacionField = new JTextField();
        formPanel.add(fechaActualizacionField);

        clearButton = createButton("Limpiar", buttonColor, textColor, buttonHoverColor, buttonFont);
        formPanel.add(clearButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(bgColor);

        addButton = createButton("Añadir", buttonColor, textColor, buttonHoverColor, buttonFont);
        buttonPanel.add(addButton);

        updateButton = createButton("Actualizar", buttonColor, textColor, buttonHoverColor, buttonFont);
        buttonPanel.add(updateButton);

        deleteButton = createButton("Eliminar", buttonColor, textColor, buttonHoverColor, buttonFont);
        buttonPanel.add(deleteButton);

        model = new DefaultTableModel(new Object[]{"Recompensa ID", "Cliente ID", "Nivel Cliente", "Puntos Acumulados", "Fecha Actualización"}, 0);
        recompensaTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(recompensaTable);

        backButton = createButton("Regresar", new Color(255, 87, 34), textColor, new Color(244, 81, 30), buttonFont);
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setBackground(bgColor);
        backButtonPanel.add(backButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(tableScrollPane, BorderLayout.SOUTH);
        add(backButtonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Acciones de los botones
        clearButton.addActionListener(e -> clearFields());
        addButton.addActionListener(e -> addRecompensa());
        updateButton.addActionListener(e -> updateRecompensa());
        deleteButton.addActionListener(e -> deleteRecompensa());
        backButton.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            new Taqueria2().setVisible(true); // Regresa al menú principal
        });
    }

    private JButton createButton(String text, Color bgColor, Color textColor, Color hoverColor, Font font) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setFont(font);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }

    private void clearFields() {
        recompensaIdField.setText("");
        clienteIdField.setText("");
        nivelClienteField.setText("");
        puntosAcumuladosField.setText("");
        fechaActualizacionField.setText("");
    }

    private void addRecompensa() {
        // Implementar la lógica para agregar recompensa
    }

    private void updateRecompensa() {
        // Implementar la lógica para actualizar recompensa
    }

    private void deleteRecompensa() {
        // Implementar la lógica para eliminar recompensa
    }

  
    }


