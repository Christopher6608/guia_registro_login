import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Ventana de Inicio de Sesión en Java Swing.
 */
public class LoginGrafico extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;
    private JButton btnIrRegistro;

    public LoginGrafico() {
        setTitle("Inicio de Sesión Seguro");
        setSize(420, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));

        // Panel de contenido central
        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.setBackground(new Color(245, 247, 250));
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel de tarjeta blanca
        JPanel panelTarjeta = new JPanel(new BorderLayout());
        panelTarjeta.setBackground(Color.WHITE);
        panelTarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Encabezado
        JPanel panelEncabezado = new JPanel(new BorderLayout());
        panelEncabezado.setBackground(Color.WHITE);
        panelEncabezado.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel lblTitulo = new JLabel("Bienvenido");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(34, 47, 62));

        JLabel lblSubtitulo = new JLabel("Inicia sesión para continuar");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(108, 117, 125));

        JPanel panelTextoTitulo = new JPanel(new GridLayout(2, 1, 4, 4));
        panelTextoTitulo.setBackground(Color.WHITE);
        panelTextoTitulo.add(lblTitulo);
        panelTextoTitulo.add(lblSubtitulo);

        panelEncabezado.add(panelTextoTitulo, BorderLayout.WEST);

        // Avatar superior
        JLabel lblAvatar = new JLabel();
        ImageIcon avatar = loadIcon("candado.png", 70, 70);
        if (avatar != null) {
            lblAvatar.setIcon(avatar);
        }
        panelEncabezado.add(lblAvatar, BorderLayout.EAST);

        panelTarjeta.add(panelEncabezado, BorderLayout.NORTH);

        // Formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Campo Usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblUsuario.setForeground(new Color(63, 81, 181));
        panelFormulario.add(lblUsuario, gbc);

        gbc.gridx = 1;
        JLabel lblIconoUsuario = new JLabel();
        ImageIcon iconoUsuario = loadIcon("usuario.png", 20, 20);
        if (iconoUsuario != null) {
            lblIconoUsuario.setIcon(iconoUsuario);
        }
        panelFormulario.add(lblIconoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        txtUsuario = new JTextField();
        txtUsuario.setPreferredSize(new Dimension(260, 36));
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        panelFormulario.add(txtUsuario, gbc);

        // Campo Contraseña
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JLabel lblClave = new JLabel("Contraseña:");
        lblClave.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblClave.setForeground(new Color(63, 81, 181));
        panelFormulario.add(lblClave, gbc);

        gbc.gridx = 1;
        JLabel lblIconoLock = new JLabel();
        ImageIcon iconoLock = loadIcon("lock.png", 20, 20);
        if (iconoLock != null) {
            lblIconoLock.setIcon(iconoLock);
        }
        panelFormulario.add(lblIconoLock, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        txtClave = new JPasswordField();
        txtClave.setPreferredSize(new Dimension(260, 36));
        txtClave.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        panelFormulario.add(txtClave, gbc);

        // Botón Ingresar
        gbc.gridy = 4;
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(63, 81, 181));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnIngresar.addActionListener(this);
        panelFormulario.add(btnIngresar, gbc);

        // Botón Ir a Registro
        gbc.gridy = 5;
        btnIrRegistro = new JButton("¿No tienes cuenta? Regístrate");
        btnIrRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnIrRegistro.setForeground(new Color(25, 118, 210));
        btnIrRegistro.setContentAreaFilled(false);
        btnIrRegistro.setBorderPainted(false);
        btnIrRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIrRegistro.addActionListener(this);
        panelFormulario.add(btnIrRegistro, gbc);

        panelTarjeta.add(panelFormulario, BorderLayout.CENTER);
        panelContenedor.add(panelTarjeta, BorderLayout.CENTER);
        add(panelContenedor, BorderLayout.CENTER);
    }

    /**
     * Carga y escala una imagen desde varias rutas de recursos posibles.
     */
    private ImageIcon loadIcon(String fileName, int width, int height) {
        String[] posiblesRutas = {
            "EjerciciosJava/resources/" + fileName,
            "resources/" + fileName,
            "../EjerciciosJava/resources/" + fileName,
            fileName
        };
        for (String ruta : posiblesRutas) {
            File f = new File(ruta);
            if (f.exists()) {
                ImageIcon icono = new ImageIcon(ruta);
                Image imagen = icono.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(imagen);
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresar) {
            String usuario = txtUsuario.getText().trim();
            String clave = new String(txtClave.getPassword()).trim();

            if (usuario.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa tu usuario y contraseña.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (UsuarioDatos.validar(usuario, clave)) {
                VentanaBienvenida bienvenida = new VentanaBienvenida(usuario);
                bienvenida.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnIrRegistro) {
            FormularioRegistro registro = new FormularioRegistro();
            registro.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGrafico ventana = new LoginGrafico();
            ventana.setVisible(true);
        });
    }
}
