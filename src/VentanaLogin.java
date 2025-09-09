import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    public static void main(String[] args) {
        new VentanaLogin().mostrarVentana();
    }

    public static final List<Usuario> USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("login");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");


    public VentanaLogin() {
        inicializarUsuarios();
        inicializarVentana();
        configurarEventos();
    }

    private void inicializarUsuarios() {
        USUARIOS.add(new Usuario("daniel", "1111", "Daniel Lincopi"));
    }

    private void inicializarVentana() {
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame. setLocationRelativeTo(null);

        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(120, 30, 130, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(120, 70, 130, 25);
        btnIngresar.setBounds(40, 120, 100, 30);


        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);


    }
    private void configurarEventos() {
        btnIngresar.addActionListener(_ -> {
            String usuarioIngresado = txtUsuario.getText();
            String claveIngresada = new String(txtClave.getPassword());

            if (!validarCredenciales(usuarioIngresado, claveIngresada).isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Login exitoso");
                frame.dispose();

                VentanaSaludo saludo = new VentanaSaludo();
                saludo.iniciar();
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Usuario o clave incorrectos");
            }
        });
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }


    private String validarCredenciales(String u, String p) {
        for (Usuario user : USUARIOS) {
            if (user.validarCredenciales(u, p)) {
                return user.getNombre();
            }
        }
        return "";
    }

}