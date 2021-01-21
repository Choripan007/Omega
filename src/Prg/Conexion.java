package Prg;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Conexion {

    private static Conexion instanciaConexion;

    private Connection Conexion = null;
    public String bde = "omega";
    public String login = "postgres";
    public String password = "12345";
    public final String CONTROLADOR_JDBC = "org.postgresql.Driver";
    public Statement st;
    public ResultSet rs;

    private Conexion() {
        String URL_BASEDEDATOS = "jdbc:postgresql://localhost:5432/" + bde;

        try {
            Class.forName(CONTROLADOR_JDBC);
            Conexion = DriverManager.getConnection(URL_BASEDEDATOS, login, password);
            System.out.println("Conexion Exitosa");

        } catch (ClassNotFoundException e) {
            // Generico_Excepcion Errores = new Generico_Excepcion(e,"Error Durante Verificacion del Driver");
            System.out.println("Error Durante Verificacion del Driver");
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            //JOptionPane.showMessageDialog(null, "Error Durante Verificacion del Driver", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
//            System.out.println(Arrays.toString(e.getStackTrace()));
            //Generico_Excepcion Errores = new Generico_Excepcion(e,"Error Durante la Conecion");
            JOptionPane.showMessageDialog(null, "Error Durante la Conexion", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Conexion getInstanciaConexion() {
        if (instanciaConexion == null) {
            instanciaConexion = new Conexion();
        }
        return instanciaConexion;
    }

    public Connection obtenerRutaConeccion() {
        return Conexion;
    }

    public void deshabilitar_btn(JButton btnuevo,
            JButton btmodificar,
            JButton bteliminar,
            JButton btgrabar
    ) {
        btnuevo.setEnabled(false);
        btmodificar.setEnabled(false);
        bteliminar.setEnabled(false);
        btgrabar.setEnabled(true);
    }

    public void habilitar_btn(JButton btnuevo,
            JButton btmodificar,
            JButton bteliminar,
            JButton btgrabar
    ) {
        btnuevo.setEnabled(true);
        btmodificar.setEnabled(true);
        bteliminar.setEnabled(true);
        btgrabar.setEnabled(false);
    }

    public void autonumerico(
            String condicion,
            String tabla,
            JTextField texto) {
        try {
            st = obtenerRutaConeccion().createStatement();
            rs = st.executeQuery("select coalesce(max(" + condicion + "),0) + 1 as cod\n"
                    + "from " + tabla + "");
            if (rs.next()) {
                texto.setText(rs.getString("cod"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error en autonumerico " + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void no_letras(KeyEvent evt) {
        char c = evt.getKeyChar();
        //false seria letras
        //true seria numeros
        if (Character.isDigit(c) == false) {
            evt.consume();//borra el caracter
        }
    }

    public void listar_datos(String sql) {
        try {
            st = obtenerRutaConeccion().createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al listar " + e);
        }
    }

    
}
