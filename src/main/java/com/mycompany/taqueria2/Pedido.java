/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taqueria2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pedido extends JFrame {
    private JTextField pedidoIDField, clienteIDField, productoIDField, sucursalIDField, repartidorIDField, estadoField, formaPagoField, tipoPedidoField, montoTotalField, tarifaEntregaField, horaEntregaField, fechaHoraField;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private JTable pedidoTable;
    private DefaultTableModel model;

    public Pedido() {
        setTitle("CRUD de Pedidos - Taquería");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo claro

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Fondo claro

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(12, 2, 10, 10));
        formPanel.setBackground(new Color(245, 245, 245)); // Fondo claro

        // Etiquetas y campos de texto para el formulario
        formPanel.add(new JLabel("Pedido ID:"));
        pedidoIDField = new JTextField();
        pedidoIDField.setEnabled(false); // Se deshabilita porque es autoincremental
        formPanel.add(pedidoIDField);

        formPanel.add(new JLabel("Cliente ID:"));
        clienteIDField = new JTextField();
        formPanel.add(clienteIDField);

        formPanel.add(new JLabel("Producto ID:"));
        productoIDField = new JTextField();
        formPanel.add(productoIDField);

        formPanel.add(new JLabel("Sucursal ID:"));
        sucursalIDField = new JTextField();
        formPanel.add(sucursalIDField);

        formPanel.add(new JLabel("Repartidor ID:"));
        repartidorIDField = new JTextField();
        formPanel.add(repartidorIDField);

        formPanel.add(new JLabel("Estado:"));
        estadoField = new JTextField();
        formPanel.add(estadoField);

        formPanel.add(new JLabel("Forma de Pago:"));
        formaPagoField = new JTextField();
        formPanel.add(formaPagoField);

        formPanel.add(new JLabel("Tipo de Pedido:"));
        tipoPedidoField = new JTextField();
        formPanel.add(tipoPedidoField);

        formPanel.add(new JLabel("Monto Total:"));
        montoTotalField = new JTextField();
        formPanel.add(montoTotalField);

        formPanel.add(new JLabel("Tarifa de Entrega:"));
        tarifaEntregaField = new JTextField();
        formPanel.add(tarifaEntregaField);

        formPanel.add(new JLabel("Hora de Entrega:"));
        horaEntregaField = new JTextField();
        formPanel.add(horaEntregaField);

        formPanel.add(new JLabel("Fecha y Hora del Pedido:"));
        fechaHoraField = new JTextField();
        formPanel.add(fechaHoraField);

        // Añadir el panel de formulario al panel principal
        panel.add(formPanel, BorderLayout.NORTH);

        // Panel de botones CRUD
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(245, 245, 245)); // Fondo claro

        addButton = new JButton("Añadir");
        addButton.setBackground(new Color(76, 175, 80)); // Verde
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(addButton);

        updateButton = new JButton("Actualizar");
        updateButton.setBackground(new Color(33, 150, 243)); // Azul
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(updateButton);

        deleteButton = new JButton("Eliminar");
        deleteButton.setBackground(new Color(244, 67, 54)); // Rojo
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(deleteButton);

        clearButton = new JButton("Limpiar");
        clearButton.setBackground(new Color(224, 224, 224)); // Gris claro
        clearButton.setForeground(Color.DARK_GRAY);
        clearButton.setFocusPainted(false);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 14));
        buttonPanel.add(clearButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Tabla para mostrar pedidos
        model = new DefaultTableModel(new Object[]{"PedidoID", "ClienteID", "ProductoID", "SucursalID", "RepartidorID", "Estado", "FormaPago", "TipoPedido", "MontoTotal", "TarifaEntrega", "HoraEntrega", "FechaHora"}, 0);
        pedidoTable = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(pedidoTable);
        panel.add(tableScrollPane, BorderLayout.SOUTH);

        // Botón para regresar al menú principal
        backButton = new JButton("Regresar al Menú Principal");
        backButton.setBackground(new Color(255, 152, 0)); // Naranja
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(backButton, BorderLayout.SOUTH);

        // Añadir el panel principal al JFrame
        add(panel);

        // Acción de limpiar campos
        clearButton.addActionListener(e -> clearFields());

        // Acción de añadir pedido
        addButton.addActionListener(e -> addPedido());

        // Acción de actualizar pedido
        updateButton.addActionListener(e -> updatePedido());

      /*  // Acción de eliminar pedido
        deleteButton.addActionListener(e -> deletePedido());*/

        // Acción de regresar al menú principal
        backButton.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            new Taqueria2().setVisible(true); // Suponiendo que tienes un JFrame para el menú principal
        });
    }

    private void clearFields() {
        pedidoIDField.setText("");
        clienteIDField.setText("");
        productoIDField.setText("");
        sucursalIDField.setText("");
        repartidorIDField.setText("");
        estadoField.setText("");
        formaPagoField.setText("");
        tipoPedidoField.setText("");
        montoTotalField.setText("");
        tarifaEntregaField.setText("");
        horaEntregaField.setText("");
        fechaHoraField.setText("");
    }

    private void addPedido() {
        String clienteID = clienteIDField.getText();
        String productoID = productoIDField.getText();
        String sucursalID = sucursalIDField.getText();
        String repartidorID = repartidorIDField.getText();
        String estado = estadoField.getText();
        String formaPago = formaPagoField.getText();
        String tipoPedido = tipoPedidoField.getText();
        String montoTotal = montoTotalField.getText();
        String tarifaEntrega = tarifaEntregaField.getText();
        String horaEntrega = horaEntregaField.getText();
        String fechaHora = fechaHoraField.getText();

        if (!clienteID.isEmpty() && !productoID.isEmpty() && !sucursalID.isEmpty() && !repartidorID.isEmpty()) {
            model.addRow(new Object[]{model.getRowCount() + 1, clienteID, productoID, sucursalID, repartidorID, estado, formaPago, tipoPedido, montoTotal, tarifaEntrega, horaEntrega, fechaHora});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePedido() {
        int selectedRow = pedidoTable.getSelectedRow();
        if (selectedRow != -1) {
            model.setValueAt(clienteIDField.getText(), selectedRow, 1);
            model.setValueAt(productoIDField.getText(), selectedRow, 2);
            model.setValueAt(sucursalIDField.getText(), selectedRow, 3);
            model.setValueAt(repartidorIDField.getText(), selectedRow, 4);
            model.setValueAt(estadoField.getText(), selectedRow, 5);
            model.setValueAt(formaPagoField.getText(), selectedRow, 6);
            model.setValueAt(tipoPedidoField.getText(), selectedRow, 7);
            model.setValueAt(montoTotalField.getText(), selectedRow, 8);
            model.setValueAt(tarifaEntregaField.getText(), selectedRow, 9);
            model.setValueAt(horaEntregaField.getText(), selectedRow, 10);
            model.setValueAt(fechaHoraField.getText(), selectedRow, 11);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }}

  /*  private void deletePedido() {
        int selectedRow = pedidoTable.getSelectedRow();
        if (selectedRow != -1) {
            model.remove*/
