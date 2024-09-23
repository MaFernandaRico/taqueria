package com.mycompany.taqueria2;


import com.mycompany.taqueria2.HistorialPago;
import com.mycompany.taqueria2.Inventario;
import com.mycompany.taqueria2.MetodoPago;
import com.mycompany.taqueria2.Pedido;
import com.mycompany.taqueria2.Promocion;
import com.mycompany.taqueria2.Recompensa;
import com.mycompany.taqueria2.Repartidor;
import com.mycompany.taqueria2.Sucursal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taqueria2 extends JFrame {

    private JButton sucursalButton, pedidoButton, recompensaButton, promocionButton, repartidorButton, historialPagoButton, metodoPagoButton, inventarioButton, salirButton;

    public Taqueria2() {
        setTitle("Menú Principal - Taquería");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 1, 10, 10));
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo claro

        // Botón para abrir la interfaz CRUD de Sucursal
        sucursalButton = createButton("Gestionar Sucursales", new Color(33, 150, 243)); // Azul
        add(sucursalButton);

        // Botón para abrir la interfaz CRUD de Pedido
        pedidoButton = createButton("Gestionar Pedidos", new Color(76, 175, 80)); // Verde
        add(pedidoButton);

        // Botón para abrir la interfaz CRUD de Recompensas
        recompensaButton = createButton("Gestionar Recompensas", new Color(255, 193, 7)); // Amarillo
        add(recompensaButton);

        // Botón para abrir la interfaz CRUD de Promociones
        promocionButton = createButton("Gestionar Promociones", new Color(156, 39, 176)); // Púrpura
        add(promocionButton);

        // Botón para abrir la interfaz CRUD de Repartidores
        repartidorButton = createButton("Gestionar Repartidores", new Color(63, 81, 181)); // Azul oscuro
        add(repartidorButton);

        // Botón para abrir la interfaz CRUD de Historial de Pagos
        historialPagoButton = createButton("Gestionar Historial de Pagos", new Color(255, 87, 34)); // Naranja
        add(historialPagoButton);

        // Botón para abrir la interfaz CRUD de Métodos de Pago
        metodoPagoButton = createButton("Gestionar Métodos de Pago", new Color(76, 175, 80)); // Verde
        add(metodoPagoButton);

        // Botón para abrir la interfaz CRUD de Inventario
        inventarioButton = createButton("Gestionar Inventario", new Color(33, 150, 243)); // Azul
        add(inventarioButton);

        // Botón para salir de la aplicación
        salirButton = createButton("Salir", new Color(244, 67, 54)); // Rojo
        add(salirButton);

        // Acciones de los botones
        sucursalButton.addActionListener(e -> openNewWindow(new Sucursal()));
        pedidoButton.addActionListener(e -> openNewWindow(new Pedido()));
        recompensaButton.addActionListener(e -> openNewWindow(new Recompensa()));
        promocionButton.addActionListener(e -> openNewWindow(new Promocion()));
        repartidorButton.addActionListener(e -> openNewWindow(new Repartidor()));
        historialPagoButton.addActionListener(e -> openNewWindow(new HistorialPago()));
        metodoPagoButton.addActionListener(e -> openNewWindow(new MetodoPago()));
        inventarioButton.addActionListener(e -> openNewWindow(new Inventario()));
        salirButton.addActionListener(e -> System.exit(0)); // Cierra la aplicación
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        return button;
    }

    private void openNewWindow(JFrame frame) {
        dispose(); // Cierra el menú principal
        frame.setVisible(true); // Abre la nueva ventana
    }

    public static void main(String[] args) {
        // Ejecuta el menú principal
        SwingUtilities.invokeLater(() -> new Taqueria2().setVisible(true));
    }
    
}
