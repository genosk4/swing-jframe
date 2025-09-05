import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaSaludo {

    private JFrame ventana;
    private JTextField campoTexto;
    private JButton botonSaludar;
    private JLabel etiquetaSaludo;
    private JButton botonLimpiar;

    // Main
    public static void main(String[] args) {
        VentanaSaludo aplicacion = new VentanaSaludo();
        aplicacion.Visual();
        aplicacion.eventoBoton();
        aplicacion.agregarVentana();
    }

    //Define el tamaño, fuente y color de la ventana
    private void Visual() {

        ventana = new JFrame("App de Saludo ICC490");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        ventana.getContentPane().setBackground(new Color(255, 255, 240));

        campoTexto = new JTextField();
        campoTexto.setBounds(50, 30, 200, 25);
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        campoTexto.setBackground(new Color(255, 255, 240));



        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(270, 30, 100, 25);
        botonSaludar.setFont(new Font("Inter", Font.BOLD, 14));
        botonSaludar.setBackground(new Color(129, 181, 119));
        botonSaludar.setBorder(BorderFactory.createRaisedBevelBorder());
        botonSaludar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        etiquetaSaludo = new JLabel(" ");
        etiquetaSaludo.setBounds(50, 80, 300, 25);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(270, 80, 100, 25);
        botonLimpiar.setFont(new Font("Inter", Font.BOLD, 14));
        botonLimpiar.setBackground(new Color(129, 181, 119));
        botonLimpiar.setBorder(BorderFactory.createRaisedBevelBorder());
        botonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    // Hace que el boton funcione, que se pueda usar
    private void eventoBoton() {

        botonSaludar.addActionListener(_ -> {
            String nombre = campoTexto.getText();
            Usuario usuario = new Usuario(nombre);
            if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa tu nombre. ");
            } else {
                etiquetaSaludo.setText(usuario.getSaludo());
            }
        });
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick();
                }
            }
        });
        botonLimpiar.addActionListener(_ -> {
            campoTexto.setText("");
            etiquetaSaludo.setText(" ");
        });
    }

    // agrega los botones, texto a la ventana
    private void agregarVentana() {
        ventana.add(campoTexto);
        ventana.add(botonSaludar);
        ventana.add(botonLimpiar);
        ventana.add(etiquetaSaludo);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}