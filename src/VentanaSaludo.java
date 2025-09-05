import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaSaludo {

    private JFrame ventana;
    private JTextField campoTexto;
    private JButton botonSaludar;
    private JLabel etiquetaSaludo;

    public static void main(String[] args) {
        VentanaSaludo aplicacion = new VentanaSaludo();
        aplicacion.Visual();
        aplicacion.eventoBoton();
        aplicacion.ejecutarCodigo();
    }

    public void Visual() {

        ventana = new JFrame("App de Saludo ICC490");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        ventana.getContentPane().setBackground(new Color(220, 240, 255));

        campoTexto = new JTextField();
        campoTexto.setBounds(50, 30, 200, 25);
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));

        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick();
                }
            }
        });

        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(270, 30, 100, 25);
        botonSaludar.setFont(new Font("Inter", Font.BOLD, 14));

        etiquetaSaludo = new JLabel(" ");
        etiquetaSaludo.setBounds(50, 80, 300, 25);
    }
    public void eventoBoton() {

        botonSaludar.addActionListener(e -> {
            String nombre = campoTexto.getText();
            Usuario usuario = new Usuario(nombre);
            if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa tu nombre. ");
            } else {
                etiquetaSaludo.setText(usuario.getSaludo());
            }
        });
    }


    public void ejecutarCodigo() {
        ventana.add(campoTexto);
        ventana.add(botonSaludar);
        ventana.add(etiquetaSaludo);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}