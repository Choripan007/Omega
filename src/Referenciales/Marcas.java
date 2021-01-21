/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referenciales;

import Prg.Conexion;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kiel
 */
public class Marcas extends javax.swing.JDialog {

    String vcondicion = "";
    int autonum;

    public Marcas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Conexion.getInstanciaConexion();  //para conectar a la base de datos
        setTitle("Mantener Marcas");
        cargar_tabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnuevo = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        btsalir = new javax.swing.JButton();
        btgrabar = new javax.swing.JButton();
        txtdescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnuevo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnuevo.setForeground(new java.awt.Color(0, 153, 204));
        btnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btnuevo.setText("NUEVO");
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnuevo);
        btnuevo.setBounds(40, 280, 108, 50);

        btmodificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btmodificar.setForeground(new java.awt.Color(0, 153, 204));
        btmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btmodificar.setText("MODIFICAR");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btmodificar);
        btmodificar.setBounds(190, 280, 123, 50);

        bteliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bteliminar.setForeground(new java.awt.Color(0, 153, 204));
        bteliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.png"))); // NOI18N
        bteliminar.setText("ELMINAR");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bteliminar);
        bteliminar.setBounds(360, 280, 110, 50);

        btcancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btcancelar.setForeground(new java.awt.Color(0, 153, 204));
        btcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Redo_h.png"))); // NOI18N
        btcancelar.setText("CANCELAR");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btcancelar);
        btcancelar.setBounds(560, 280, 130, 50);

        btsalir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btsalir.setForeground(new java.awt.Color(0, 153, 204));
        btsalir.setText("SALIR");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir);
        btsalir.setBounds(740, 280, 80, 50);

        btgrabar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btgrabar.setForeground(new java.awt.Color(0, 153, 204));
        btgrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        btgrabar.setText("GRABAR");
        btgrabar.setEnabled(false);
        btgrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btgrabar);
        btgrabar.setBounds(730, 160, 110, 60);

        txtdescripcion.setEnabled(false);
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyPressed(evt);
            }
        });
        getContentPane().add(txtdescripcion);
        txtdescripcion.setBounds(180, 120, 460, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripcion:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 130, 80, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("BUSCAR");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 370, 120, 29);

        jLabel5.setFont(new java.awt.Font("Centaur", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("MARCAS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 40, 160, 40);

        txtobs.setColumns(20);
        txtobs.setRows(5);
        txtobs.setEnabled(false);
        jScrollPane1.setViewportView(txtobs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(180, 170, 460, 90);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 430, 960, 403);

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar);
        txtbuscar.setBounds(0, 400, 960, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Observacion:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 200, 80, 15);

        setSize(new java.awt.Dimension(976, 877));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
        
        
        // desactivar los botones
        Conexion.getInstanciaConexion().deshabilitar_btn(btnuevo, btmodificar, bteliminar, btgrabar);
        Conexion.getInstanciaConexion().autonumerico("id_marca", "marcas", autonum);
        System.out.println(autonum);
        vcondicion = "nuevo";
        txtdescripcion.setEnabled(true); //para habilitar txt
        txtdescripcion.requestFocus();   // para enviar el cursos al txt
    }//GEN-LAST:event_btnuevoActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        
        String vobs = "", vdescri = "";
        vdescri = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
        vobs = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
        txtdescripcion.setText(vdescri);
        txtobs.setText(vdescri);
        if (!autonum==isEmpty()) {
            vcondicion = "modificar";
            txtdescripcion.setEnabled(true);
            txtdescripcion.requestFocus();
        }
    }//GEN-LAST:event_btmodificarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
       
        if (!autonum.isEmpty()) {
            vcondicion = "eliminar";
            int mensaj = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro seleccionado?", "Atencion!!", JOptionPane.YES_NO_OPTION);
            if (mensaj == 0) {
                try {
                    if (Conexion.getInstanciaConexion().obtenerRutaConeccion().getAutoCommit()) {
                        Conexion.getInstanciaConexion().obtenerRutaConeccion().setAutoCommit(false);
                    }

                    PreparedStatement pe = Conexion.getInstanciaConexion().obtenerRutaConeccion().prepareStatement(""
                            + " delete from marcas where id_marca = ?");
                    pe.setInt(1, Integer.parseInt(autonum));
                    pe.execute();
                    Conexion.getInstanciaConexion().obtenerRutaConeccion().commit();
                    btcancelar.doClick();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar registro" + e);
                    try {
                        Conexion.getInstanciaConexion().obtenerRutaConeccion().rollback();
                    } catch (SQLException ex) {
                        Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_bteliminarActionPerformed

    private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
        
        txtdescripcion.setText("");
        txtobs.setText("");
        vcondicion = "";
        txtdescripcion.setEnabled(false);
        txtobs.setEnabled(false);
        Conexion.getInstanciaConexion().habilitar_btn(btnuevo, btmodificar, bteliminar, btgrabar);
    }//GEN-LAST:event_btcancelarActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btsalirActionPerformed

    private void btgrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgrabarActionPerformed
        // si el txt esta vacio
        if (txtdescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la Descripion", "Atencion!!", JOptionPane.WARNING_MESSAGE);
            txtdescripcion.requestFocus();
            return; //ejecuta solo hasta aqui
        }

        int mensaje = JOptionPane.showConfirmDialog(null, "Desea Grabar?", "Atencion!!", JOptionPane.YES_NO_OPTION);
        //num 0 es si preisona Si
        //num 1 es si presiona No

        if (mensaje == 0) {
            if (vcondicion.equals("nuevo")) {
                // va a insertar un nuevo registro
                try {
                    //si todo esta correcto
                    if (Conexion.getInstanciaConexion().obtenerRutaConeccion().getAutoCommit()) {
                        Conexion.getInstanciaConexion().obtenerRutaConeccion().setAutoCommit(false);
                    }
                    PreparedStatement p = Conexion.getInstanciaConexion().obtenerRutaConeccion().prepareStatement("INSERT INTO marcas(\n"
                            + "            id_marca, descripcion,obs)\n"
                            + "    VALUES (?, ?, ?);");
                    p.setInt(1, Integer.parseInt(autonum));
                    p.setString(2, txtdescripcion.getText().trim().toUpperCase());
                    p.setString(3, txtobs.getText());
                    p.execute();
                    Conexion.getInstanciaConexion().obtenerRutaConeccion().commit();
                    btcancelar.doClick();
                } catch (Exception e) {
                    try {
                        JOptionPane.showMessageDialog(null, "Error al Grabar Nuevo" + e);
                        Conexion.getInstanciaConexion().obtenerRutaConeccion().rollback();
                    } catch (SQLException ex) {
                        Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                //va a modificar el registro
                try {
                    //si todo esta correcto
                    if (Conexion.getInstanciaConexion().obtenerRutaConeccion().getAutoCommit()) {
                        Conexion.getInstanciaConexion().obtenerRutaConeccion().setAutoCommit(false);
                    }
                    PreparedStatement p = Conexion.getInstanciaConexion().obtenerRutaConeccion().prepareStatement("UPDATE marcas\n"
                            + "   SET descripcion=?, obs=?\n"
                            + " WHERE id_marca=?");

                    p.setString(1, txtdescripcion.getText().trim().toUpperCase());
                    p.setString(2, txtobs.getText());
                    p.setInt(3, Integer.parseInt(autonum));
                    p.execute();
                    Conexion.getInstanciaConexion().obtenerRutaConeccion().commit();
                    btcancelar.doClick();
                } catch (Exception e) {
                    try {
                        JOptionPane.showMessageDialog(null, "Error al Grabar Datos Modificados" + e);
                        Conexion.getInstanciaConexion().obtenerRutaConeccion().rollback();
                    } catch (SQLException ex) {
                        Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }

    }//GEN-LAST:event_btgrabarActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //hacer un click para grabar
            txtobs.setEnabled(true);
            txtobs.requestFocus();
        }
    }//GEN-LAST:event_txtdescripcionKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        cargar_tabla();
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        btnuevo.setEnabled(false);
    }//GEN-LAST:event_tablaMouseClicked

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Marcas dialog = new Marcas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btgrabar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton btnuevo;
    private javax.swing.JButton btsalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtdescripcion;
    public static javax.swing.JTextArea txtobs;
    // End of variables declaration//GEN-END:variables

    private void cargar_tabla() {
        DefaultTableModel tab = (DefaultTableModel) tabla.getModel();
        tab.setRowCount(0);
        try {
            Conexion.getInstanciaConexion().listar_datos("select id_marca,descripcion,obs"
                    + " from marcas "
                    + "where descripcion ilike '%" + txtbuscar.getText() + "%' "
                    + "order by marcas asc ");
            while (Conexion.getInstanciaConexion().rs.next()) {
                tab.addRow(new Object[]{
                    Conexion.getInstanciaConexion().rs.getString("descripcion"),
                    Conexion.getInstanciaConexion().rs.getString("obs")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla" + e);
        }
    }
}
