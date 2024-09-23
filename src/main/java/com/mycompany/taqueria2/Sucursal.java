/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taqueria2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Sucursal extends JFrame {
    private JTextField sucursalIDField, nombreField, direccionField, telefonoField;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private JTable sucursalTable;
    private DefaultTableModel model;

    public Sucursal() {
        setTitle("CRUD de Sucursales - Taquería");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Colores y fuentes para el estilo minimalista
        Color bgColor = new Color(240, 248, 255);  // Color de fondo claro (Alice Blue)
        Color buttonColor = new Color(0, 150, 136);  // Verde Azulado
        Color buttonHoverColor = new Color(38, 166, 154);
        Color textColor = Color.WHITE;
        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(bgColor);

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(bgColor);

        formPanel.add(new JLabel("Sucursal ID:"));
        sucursalIDField = new JTextField();
        sucursalIDField.setEnabled(false); // El ID es autoincremental
        formPanel.add(sucursalIDField);

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        formPanel.add(direccionField);

        formPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        formPanel.add(telefonoField);

        // Botón Limpiar
        clearButton = createButton("Limpiar", buttonColor, textColor, buttonHoverColor, buttonFont);
        formPanel.add(clearButton);

        // Panel de botones CRUD
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(bgColor);

        addButton = createButton("Añadir", buttonColor, textColor, buttonHoverColor, buttonFont);
        buttonPanel.add(addButton);

        updateButton = createButton("Actualizar", buttonColor, textColor, buttonHoverColor, buttonFont);
        buttonPanel.add(updateButton);

        deleteButton = createButton("Eliminar", buttonColor, textColor, buttonHoverColor, buttonFont);
        buttonPanel.add(deleteButton);

        // Panel de la tabla
        model = new DefaultTableModel(new Object[]{"Sucursal ID", "Nombre", "Dirección", "Teléfono"}, 0);
        sucursalTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(sucursalTable);

        // Botón Regresar
        backButton = createButton("Regresar al Menú Principal", new Color(255, 87, 34), textColor, new Color(244, 81, 30), buttonFont);
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setBackground(bgColor);
        backButtonPanel.add(backButton);

        // Agregar paneles al JFrame
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(tableScrollPane, BorderLayout.SOUTH);
        add(backButtonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Acciones de los botones
        clearButton.addActionListener(e -> clearFields());
        addButton.addActionListener(e -> addSucursal());
        updateButton.addActionListener(e -> updateSucursal());
        deleteButton.addActionListener(e -> deleteSucursal());
        backButton.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            new Taqueria2().setVisible(true); // Regresa al menú principal
        });
    }

    // Método para crear un botón con estilo
    private JButton createButton(String text, Color bgColor, Color textColor, Color hoverColor, Font font) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setFont(font);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Cambiar color al pasar el cursor
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
        sucursalIDField.setText("");
        nombreField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
    }

    private void addSucursal() {
        String nombre = nombreField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        if (!nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()) {
            model.addRow(new Object[]{model.getRowCount() + 1, nombre, direccion, telefono});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSucursal() {
        int selectedRow = sucursalTable.getSelectedRow();
        if (selectedRow != -1) {
            model.setValueAt(nombreField.getText(), selectedRow, 1);
            model.setValueAt(direccionField.getText(), selectedRow, 2);
            model.setValueAt(telefonoField.getText(), selectedRow, 3);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSucursal() {
        int selectedRow = sucursalTable.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main para mostrar la ventana de CRUD
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sucursal crud = new Sucursal();
            crud.setVisible(true);
        });
    }
}



    
