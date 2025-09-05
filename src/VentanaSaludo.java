import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaSaludo {

    private JFrame ventana;
    private JTextField campoTexto;
    private JButton botonSaludar;
    private JLabel etiquetaSaludo;
    private JButton botonLimpiar;


    public static void main(String[] args) {
        VentanaSaludo aplicacion = new VentanaSaludo();
        aplicacion.Visual();
        aplicacion.eventoBoton();
        aplicacion.agregarVentana();
    }

    //Define el tamaño, fuente y color de la ventana
    public void Visual() {

        ventana = new JFrame("App de Saludo ICC490");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        ventana.getContentPane().setBackground(new Color(177, 177, 177));

        campoTexto = new JTextField();
        campoTexto.setBounds(50, 30, 200, 25);
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));


        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(270, 30, 100, 25);
        botonSaludar.setFont(new Font("Inter", Font.BOLD, 14));
        etiquetaSaludo = new JLabel(" ");
        etiquetaSaludo.setBounds(50, 80, 300, 25);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(270, 80, 100, 25);
        botonLimpiar.setFont(new Font("Inter", Font.BOLD, 14));

    }

    // Hace que el boton funcione, que se pueda usar
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
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick();
                }
            }
        });
        botonLimpiar.addActionListener(e -> {
            campoTexto.setText("");
            etiquetaSaludo.setText(" ");
        });
    }

    // agrega los botones, texto a la ventana
    public void agregarVentana() {
        ventana.add(campoTexto);
        ventana.add(botonSaludar);
        ventana.add(botonLimpiar);
        ventana.add(etiquetaSaludo);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}