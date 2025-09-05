import javax.swing.*;
import java.awt.event.*;


public class VentanaSaludo {

    static JFrame ventana;
    static JTextField campoTexto;
    static JButton botonSaludar;
    static JLabel etiquetaSaludo;

    public static void main(String[] args) {
        ventana = new JFrame("App de Saludo ICC490");
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        componenteVisual();
        eventoBoton();
        ejecutarCodigo();
    }

    public static void componenteVisual() {
        campoTexto = new JTextField();
        campoTexto.setBounds(50, 30, 200, 25);

        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick();
                }
            }
        });

        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(270, 30, 100, 25);

        etiquetaSaludo = new JLabel(" ");
        etiquetaSaludo.setBounds(50, 80, 300, 25);
    }
    public static void eventoBoton() {

        botonSaludar.addActionListener(e -> {
            String nombre = campoTexto.getText();
            if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa tu nombre. ");
            } else {
                etiquetaSaludo.setText("Hola: " + nombre);
            }


        });
    }


    public static void ejecutarCodigo() {
        ventana.add(campoTexto);
        ventana.add(botonSaludar);
        ventana.add(etiquetaSaludo);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}