/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taqueria2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Promocion extends JFrame {
    private JTextField promocionIDField, sucursalIDField, descripcionField, porcentajeDescuentoField, codigoPromocionField, fechaFinField, fechaInicioField, montoMinimoField, descuentoFijoField;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private JTable promocionTable;
    private DefaultTableModel model;

    public Promocion() {
        setTitle("CRUD de Promociones - Taquería");
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

        JPanel formPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        formPanel.setBackground(bgColor);

        formPanel.add(new JLabel("Promoción ID:"));
        promocionIDField = new JTextField();
        promocionIDField.setEnabled(false);
        formPanel.add(promocionIDField);

        formPanel.add(new JLabel("Sucursal ID:"));
        sucursalIDField = new JTextField();
        formPanel.add(sucursalIDField);

        formPanel.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        formPanel.add(descripcionField);

        formPanel.add(new JLabel("Porcentaje Descuento:"));
        porcentajeDescuentoField = new JTextField();
        formPanel.add(porcentajeDescuentoField);

        formPanel.add(new JLabel("Código Promoción:"));
        codigoPromocionField = new JTextField();
        formPanel.add(codigoPromocionField);

        formPanel.add(new JLabel("Fecha Fin:"));
        fechaFinField = new JTextField();
        formPanel.add(fechaFinField);

        formPanel.add(new JLabel("Fecha Inicio:"));
        fechaInicioField = new JTextField();
        formPanel.add(fechaInicioField);

        formPanel.add(new JLabel("Monto Mínimo:"));
        montoMinimoField = new JTextField();
        formPanel.add(montoMinimoField);

        formPanel.add(new JLabel("Descuento Fijo:"));
        descuentoFijoField = new JTextField();
        formPanel.add(descuentoFijoField);

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

        model = new DefaultTableModel(new Object[]{"Promoción ID", "Sucursal ID", "Descripción", "Porcentaje Descuento", "Código Promoción", "Fecha Fin", "Fecha Inicio", "Monto Mínimo", "Descuento Fijo"}, 0);
        promocionTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(promocionTable);

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
        addButton.addActionListener(e -> addPromocion());
        updateButton.addActionListener(e -> updatePromocion());
        deleteButton.addActionListener(e -> deletePromocion());
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
        promocionIDField.setText("");
        sucursalIDField.setText("");
        descripcionField.setText("");
        porcentajeDescuentoField.setText("");
        codigoPromocionField.setText("");
        fechaFinField.setText("");
        fechaInicioField.setText("");
        montoMinimoField.setText("");
        descuentoFijoField.setText("");
    }

    private void addPromocion() {
        // Implementar la lógica para agregar promoción
    }

    private void updatePromocion() {
        // Implementar la lógica para actualizar promoción
    }

    private void deletePromocion() {
        // Implementar la lógica para eliminar promoción
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Promocion crud = new Promocion();
            crud.setVisible(true);
        });
    }
}
