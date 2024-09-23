/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taqueria2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Repartidor extends JFrame {
    private JTextField repartidorIDField, pedidoIDField, nombreField, telefonoField;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private JTable repartidorTable;
    private DefaultTableModel model;

    public Repartidor() {
        setTitle("CRUD de Repartidores - Taquería");
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

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(bgColor);

        formPanel.add(new JLabel("Repartidor ID:"));
        repartidorIDField = new JTextField();
        repartidorIDField.setEnabled(false);
        formPanel.add(repartidorIDField);

        formPanel.add(new JLabel("Pedido ID:"));
        pedidoIDField = new JTextField();
        formPanel.add(pedidoIDField);

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        formPanel.add(telefonoField);

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

        model = new DefaultTableModel(new Object[]{"Repartidor ID", "Pedido ID", "Nombre", "Teléfono"}, 0);
        repartidorTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(repartidorTable);

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
        addButton.addActionListener(e -> addRepartidor());
        updateButton.addActionListener(e -> updateRepartidor());
        deleteButton.addActionListener(e -> deleteRepartidor());
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
        repartidorIDField.setText("");
        pedidoIDField.setText("");
        nombreField.setText("");
        telefonoField.setText("");
    }

    private void addRepartidor() {
        // Implementar la lógica para agregar repartidor
    }

    private void updateRepartidor() {
        // Implementar la lógica para actualizar repartidor
    }

    private void deleteRepartidor() {
        // Implementar la lógica para eliminar repartidor
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Repartidor crud = new Repartidor();
            crud.setVisible(true);
        });
    }
}
