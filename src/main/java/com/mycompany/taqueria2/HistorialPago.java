/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taqueria2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistorialPago extends JFrame {
    private JTextField historialIDField, clienteIDField, pedidoIDField, metodoPagoField, estadoPagoField, montoPagadoField, fechaField;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private JTable historialTable;
    private DefaultTableModel model;

    public HistorialPago() {
        setTitle("CRUD de Historial de Pagos - Taquería");
        setSize(800, 500);
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

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBackground(bgColor);

        formPanel.add(new JLabel("Historial ID:"));
        historialIDField = new JTextField();
        historialIDField.setEnabled(false);
        formPanel.add(historialIDField);

        formPanel.add(new JLabel("Cliente ID:"));
        clienteIDField = new JTextField();
        formPanel.add(clienteIDField);

        formPanel.add(new JLabel("Pedido ID:"));
        pedidoIDField = new JTextField();
        formPanel.add(pedidoIDField);

        formPanel.add(new JLabel("Método Pago:"));
        metodoPagoField = new JTextField();
        formPanel.add(metodoPagoField);

        formPanel.add(new JLabel("Estado Pago:"));
        estadoPagoField = new JTextField();
        formPanel.add(estadoPagoField);

        formPanel.add(new JLabel("Monto Pagado:"));
        montoPagadoField = new JTextField();
        formPanel.add(montoPagadoField);

        formPanel.add(new JLabel("Fecha:"));
        fechaField = new JTextField();
        formPanel.add(fechaField);

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

        model = new DefaultTableModel(new Object[]{"Historial ID", "Cliente ID", "Pedido ID", "Método Pago", "Estado Pago", "Monto Pagado", "Fecha"}, 0);
        historialTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(historialTable);

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
        addButton.addActionListener(e -> addHistorialPago());
        updateButton.addActionListener(e -> updateHistorialPago());
        deleteButton.addActionListener(e -> deleteHistorialPago());
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
        historialIDField.setText("");
        clienteIDField.setText("");
        pedidoIDField.setText("");
        metodoPagoField.setText("");
        estadoPagoField.setText("");
        montoPagadoField.setText("");
        fechaField.setText("");
    }

    private void addHistorialPago() {
        // Implementar la lógica para agregar historial de pago
    }

    private void updateHistorialPago() {
        // Implementar la lógica para actualizar historial de pago
    }

    private void deleteHistorialPago() {
        // Implementar la lógica para eliminar historial de pago
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HistorialPago crud = new HistorialPago();
            crud.setVisible(true);
        });
    }
}
