import javax.swing.*;

public class VentanaRegistro {

    private final JFrame frame = new JFrame("Registro de Usuario - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JLabel lblNombre = new JLabel("Nombre completo:");
    private final JTextField txtNombre = new JTextField();
    private final JButton btnRegistrar = new JButton("Registrar");
    private final JButton btnVolver = new JButton("Volver al Login");

    public VentanaRegistro() {
        inicializarVentana();
        configurarEventos();
    }

    private void inicializarVentana() {
        frame.setSize(400, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        lblUsuario.setBounds(30, 30, 120, 25);
        txtUsuario.setBounds(160, 30, 180, 25);

        lblClave.setBounds(30, 70, 120, 25);
        txtClave.setBounds(160, 70, 180, 25);

        lblNombre.setBounds(30, 110, 120, 25);
        txtNombre.setBounds(160, 110, 180, 25);

        btnRegistrar.setBounds(50, 160, 120, 35);
        btnVolver.setBounds(200, 160, 120, 35);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(btnRegistrar);
        frame.add(btnVolver);
    }

    private void configurarEventos() {
        btnRegistrar.addActionListener(_ -> {
            String usuario = txtUsuario.getText().trim();
            String clave = new String(txtClave.getPassword()).trim();
            String nombre = txtNombre.getText().trim();


            if (usuario.isEmpty() || clave.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Por favor complete todos los campos",
                        "Campos incompletos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario nuevoUsuario = new Usuario(usuario, clave, nombre);
            VentanaLogin.USUARIOS.add(nuevoUsuario);


            JOptionPane.showMessageDialog(frame,
                    "Usuario registrado exitosamente."
                            ,
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);


            volverAlLogin();
        });

        btnVolver.addActionListener(_ -> volverAlLogin());
    }


    private void volverAlLogin() {
        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
