
package restaurantes;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public final class ListaRestaurantes extends javax.swing.JFrame {
    
    public static final String URL = "jdbc:mysql://localhost/restaurantes";
    public static final String Username = "root";
    public static final String Password = "";
    Connection con = null;
    Statement stmt = null;
    String titulos[] = {"id","Razon Social","Nombre","Tipo","Ciudad","Hora de Apertura","Hora de Cierre"};
    String fila[] = new String [7];
    DefaultTableModel modelo;

    
    PreparedStatement ps;
    ResultSet rs;
    
    public static Connection getConnection(){
        Connection con=null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, Username, Password);
            JOptionPane.showMessageDialog(null, "Se ha realizado la conexion");
            
        }
        catch (HeadlessException | ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return con;
}
    
    private void limpiar(){
        txtRazonSocial.setText(null);
        txtNombreComercial.setText(null);
        cmbTipoRestaurante.setSelectedIndex(0);
        txtCiudad.setText(null);
        txtHoraA.setText(null);
        txtHoraC.setText(null);
    }

    
    public ListaRestaurantes() {
        initComponents();
        setSize(600,650);
        this.setTitle("Restaurantes");
        this.setLocation(400,40);
        
        try {
            String url = "jdbc:mysql://localhost/restaurantes";
            String usuario = "root";
            String contraseña = "";  
            
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection(url,usuario,contraseña);
               if (con!= null)
                   System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);
               
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("select* from restaurantes");
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("id");
                   fila[1] = rs.getString("RazonSocial");
                   fila[2] = rs.getString("Nombre");
                   fila[3] = rs.getString("Tipo");
                   fila[4] = rs.getString("Ciudad");
                   fila[5] = rs.getString("HoraApertura");
                   fila[6] = rs.getString("HoraCierre");
                   
                   modelo.addRow(fila);     
               }
               jTableRestaurantes.setModel(modelo);
                TableColumn ci = jTableRestaurantes.getColumn("id");
                ci.setMaxWidth(25);
                TableColumn cn = jTableRestaurantes.getColumn("Razon Social");
                cn.setMaxWidth(165);
                TableColumn cd = jTableRestaurantes.getColumn("Nombre");
                cd.setMaxWidth(160);
                TableColumn ct = jTableRestaurantes.getColumn("Tipo");
                ct.setMaxWidth(90);
                TableColumn cnick = jTableRestaurantes.getColumn("Ciudad");
                cnick.setMaxWidth(72);
                TableColumn cp = jTableRestaurantes.getColumn("Hora de Apertura");
                cp.setMaxWidth(72);
                TableColumn ctipo = jTableRestaurantes.getColumn("Hora de Cierre");
                ctipo.setMaxWidth(95);
               
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }


    }
    public void busqueda(String valor){
        try {
            String url = "jdbc:mysql://localhost/restaurantes";
            String usuario = "root";
            String contraseña = "";  
            
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection(url,usuario,contraseña);
               if (con!= null)
                   System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);
               
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("select* from restaurantes WHERE Nombre like'%"+valor+"'");
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("id");
                   fila[1] = rs.getString("RazonSocial");
                   fila[2] = rs.getString("Nombre");
                   fila[3] = rs.getString("Tipo");
                   fila[4] = rs.getString("Ciudad");
                   fila[5] = rs.getString("HoraApertura");
                   fila[6] = rs.getString("HoraCierre");
                   
                   modelo.addRow(fila);     
               }
               jTableRestaurantes.setModel(modelo);
                TableColumn ci = jTableRestaurantes.getColumn("id");
                ci.setMaxWidth(25);
                TableColumn cn = jTableRestaurantes.getColumn("Razon Social");
                cn.setMaxWidth(165);
                TableColumn cd = jTableRestaurantes.getColumn("Nombre");
                cd.setMaxWidth(160);
                TableColumn ct = jTableRestaurantes.getColumn("Tipo");
                ct.setMaxWidth(90);
                TableColumn cnick = jTableRestaurantes.getColumn("Ciudad");
                cnick.setMaxWidth(72);
                TableColumn cp = jTableRestaurantes.getColumn("Hora de Apertura");
                cp.setMaxWidth(72);
                TableColumn ctipo = jTableRestaurantes.getColumn("Hora de Cierre");
                ctipo.setMaxWidth(95);
               
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreComercial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoRestaurante = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHoraA = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHoraC = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRestaurantes = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btbAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Restaurantes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Razon Social");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 80, -1));

        txtRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSocialActionPerformed(evt);
            }
        });
        getContentPane().add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 240, -1));

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 80, -1));

        txtNombreComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreComercialActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 240, -1));

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 80, -1));

        cmbTipoRestaurante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vegetariano", "Vegano", "Carnes Rojas y Aves", "Pescados, Mariscos" }));
        cmbTipoRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoRestauranteActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 240, -1));

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 80, -1));
        getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 240, -1));

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 80, -1));

        txtHoraA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraAActionPerformed(evt);
            }
        });
        getContentPane().add(txtHoraA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 240, -1));

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 80, -1));

        txtHoraC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraCActionPerformed(evt);
            }
        });
        getContentPane().add(txtHoraC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 240, -1));

        jTableRestaurantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableRestaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRestaurantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableRestaurantes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 510, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 270, -1));

        btbAgregar.setText("Agregar");
        btbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 90, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 90, -1));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 90, -1));

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/20170717145948-restaurant.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, -200, 912, 1490));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Principal a=new Principal();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialActionPerformed

    private void cmbTipoRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoRestauranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoRestauranteActionPerformed

    private void txtHoraCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraCActionPerformed

    private void txtNombreComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreComercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreComercialActionPerformed

    private void txtHoraAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraAActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAgregarActionPerformed
        Connection con=null;
        try{
            
            con = getConnection();
            ps= con.prepareStatement("INSERT INTO restaurantes (RazonSocial,Nombre,Tipo,Ciudad,HoraApertura,HoraCierre) VALUES(?,?,?,?,?,?)");
            ps.setString(1, txtRazonSocial.getText());
            ps.setString(2, txtNombreComercial.getText());
            ps.setString(3, cmbTipoRestaurante.getSelectedItem().toString());
            ps.setString(4, txtCiudad.getText());
            ps.setString(5, txtHoraA.getText());
            ps.setString(6, txtHoraC.getText());
            
            int res=ps.executeUpdate();
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "Se han guardado los datos correctamente");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo guardar los datos");
                limpiar();
            }
            
            con.close();
                    
        }
        catch(HeadlessException | SQLException e){
            System.err.println(e);
        }
        
    }//GEN-LAST:event_btbAgregarActionPerformed

    private void jTableRestaurantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRestaurantesMouseClicked
        
        int filaSeleccionada=jTableRestaurantes.rowAtPoint(evt.getPoint());
        
        txtRazonSocial.setText(jTableRestaurantes.getValueAt(filaSeleccionada, 1).toString());
        txtNombreComercial.setText(jTableRestaurantes.getValueAt(filaSeleccionada, 2).toString());
        cmbTipoRestaurante.setSelectedItem(jTableRestaurantes.getValueAt(filaSeleccionada, 3));
        txtCiudad.setText(jTableRestaurantes.getValueAt(filaSeleccionada, 4).toString());
        txtHoraA.setText(jTableRestaurantes.getValueAt(filaSeleccionada, 5).toString());
        txtHoraC.setText(jTableRestaurantes.getValueAt(filaSeleccionada, 6).toString());
        
    }//GEN-LAST:event_jTableRestaurantesMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Connection con=null;
        try{
            
            con = getConnection();
            ps= con.prepareStatement("UPDATE restaurantes SET RazonSocial=?,Nombre=?,Tipo=?,Ciudad=?,HoraApertura=?,HoraCierre=? WHERE id=?");
            
            int filaSeleccionada=jTableRestaurantes.getSelectedRow();
            String uno=(String)jTableRestaurantes.getValueAt(filaSeleccionada, 0);
            ps.setString(1, txtRazonSocial.getText());
            ps.setString(2, txtNombreComercial.getText());
            ps.setString(3, cmbTipoRestaurante.getSelectedItem().toString());
            ps.setString(4, txtCiudad.getText());
            ps.setString(5, txtHoraA.getText());
            ps.setString(6, txtHoraC.getText());
            ps.setString(7, uno);
            
            int res=ps.executeUpdate();
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios");
                limpiar();
            }
            
            con.close();
                    
        }
        catch(HeadlessException | SQLException e){
            System.err.println(e);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        Connection con=null;
        try{
            
            con = getConnection();
            ps= con.prepareStatement("DELETE from restaurantes WHERE id=?");
            
            int filaSeleccionada=jTableRestaurantes.getSelectedRow();
            String uno=(String)jTableRestaurantes.getValueAt(filaSeleccionada, 0);
            
            ps.setInt(1, Integer.parseInt(uno));
            
            int res=ps.executeUpdate();
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "Se han eliminado los datos");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                limpiar();
            }
            
            con.close();
                    
        }
        catch(HeadlessException | SQLException e){
            System.err.println(e);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        busqueda(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaRestaurantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbAgregar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JComboBox<String> cmbTipoRestaurante;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRestaurantes;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtHoraA;
    private javax.swing.JTextField txtHoraC;
    private javax.swing.JTextField txtNombreComercial;
    private javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables
}
