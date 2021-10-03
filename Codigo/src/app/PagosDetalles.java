package app;

import static app.Consulta.txt_nivelP;
import static app.Consulta.txt_nombreP;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PagosDetalles extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/Teocalli";
    public static final String Username = "root";
    public static final String Password = "";
    static Connection con = null;
    static String path;

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, Username, Password);
           // JOptionPane.showMessageDialog(null, "Conexión exitosa");

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return con;
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imageLabelP.getWidth(), imageLabelP.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void limpiarCajas() {
        //txtClaveRegistro.setText(null);

    }

    public PagosDetalles() {
        initComponents();
        getConection();
        pagosconsulta();

    }

    public void removeIndexs(int num) {

        if (num != 12) {
            for (int i = num; i >= 1; i--) {
                cbxMesPagos.removeItemAt(i);
            }
        }

    }

    public void pagosconsulta() {
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String where = "";
        if (!"".equals(txtClaveP.getText().toString())) {
            where = "WHERE clave= '" + Pagos.txtClaveRegistroP.getText() + "'";
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT  mes, monto_debido, liquidado FROM  pagos " + where + " and id=(SELECT max(id) FROM pagos)";
        System.out.println(sql);

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            String liquidado;

           // System.out.println("consulta "  + rs.getInt("mes"));
            
            if (rs.next()) {

                System.out.println("dentro en if)");
                liquidado = rs.getString("liquidado");

                int mes = rs.getInt("mes");
                
                System.out.println("mes: " + mes);

                if (liquidado.equals("no")) {

                    switch (mes) {
                        case 1:
                            cbxMesPagos.setSelectedIndex(1);
                            break;
                        case 2:
                            cbxMesPagos.setSelectedIndex(2);
                            break;
                        case 3:
                            cbxMesPagos.setSelectedIndex(3);
                            break;
                        case 4:
                            cbxMesPagos.setSelectedIndex(4);
                            break;
                        case 5:
                            cbxMesPagos.setSelectedIndex(5);
                            break;
                        case 6:
                            cbxMesPagos.setSelectedIndex(6);
                            break;
                        case 7:
                            cbxMesPagos.setSelectedIndex(7);
                            break;
                        case 8:
                            cbxMesPagos.setSelectedIndex(8);
                            break;
                        case 9:
                            cbxMesPagos.setSelectedIndex(9);
                            break;
                        case 10:
                            cbxMesPagos.setSelectedIndex(10);
                            break;
                        case 11:
                            cbxMesPagos.setSelectedIndex(11);
                            break;
                        case 12:
                            cbxMesPagos.setSelectedIndex(12);
                            break;
                        default:
                            break;
                    }

                    cbxMesPagos.setEnabled(false);
                    txtMontoDebido.setEditable(false);

                    txtMontoDebido.setText(rs.getString("monto_debido"));
                    txtMes.setText("Mes a pagar: " + cbxMesPagos.getSelectedItem().toString());
                    txtMonto.setText("Monto que se quedo debiendo");

                } else {

                    removeIndexs(mes);
                    txtMes.setText("Inserta el mes a pagar");
                    txtMonto.setText("Inserta el monto a pagar");
                }
            } else {
                txtMes.setText("Inserta el mes a pagar");
                txtMonto.setText("Inserta el monto a pagar");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PagosDetalles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRegistro1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imageLabelP = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNivelP = new javax.swing.JLabel();
        txtMontoDebido = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        txtMontoPagado = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        txtClaveP = new javax.swing.JLabel();
        cbxMesPagos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JLabel();
        txtMes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(912, 180));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_48px_1.png"))); // NOI18N
        jLabel15.setText("Confirmar Pago");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel5.setMinimumSize(new java.awt.Dimension(912, 180));
        jPanel5.setPreferredSize(new java.awt.Dimension(912, 180));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistro1.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistro1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistro1.setForeground(new java.awt.Color(44, 62, 80));
        btnRegistro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistro1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistro1MouseClicked(evt);
            }
        });
        btnRegistro1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("EMAIL");
        btnRegistro1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jLabel13.setBackground(new java.awt.Color(44, 62, 80));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 62, 80));
        jLabel13.setText("Cancelar");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        btnRegistro1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel5.add(btnRegistro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 504, 170, 40));

        btnRegistro.setBackground(new java.awt.Color(26, 188, 156));
        btnRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistro.setForeground(new java.awt.Color(44, 62, 80));
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistroMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
        });
        btnRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("EMAIL");
        btnRegistro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jLabel12.setBackground(new java.awt.Color(44, 62, 80));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(44, 62, 80));
        jLabel12.setText("Confirmar");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        btnRegistro.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel5.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 504, 170, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imageLabelP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabelP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group_52px_1.png"))); // NOI18N
        imageLabelP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabelP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabelP, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 30, -1, -1));

        txtNombreP.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtNombreP.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreP.setText("Kevin David Molina Gomez");
        jPanel5.add(txtNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 240, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Nombre:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Nivel:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 282, -1, -1));

        txtNivelP.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtNivelP.setForeground(new java.awt.Color(204, 204, 204));
        txtNivelP.setText("Compañia Mayor");
        jPanel5.add(txtNivelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 282, -1, -1));

        txtMontoDebido.setBackground(new java.awt.Color(36, 47, 65));
        txtMontoDebido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtMontoDebido.setForeground(new java.awt.Color(255, 255, 255));
        txtMontoDebido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoDebido.setBorder(null);
        txtMontoDebido.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMontoDebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoDebidoFocusGained(evt);
            }
        });
        txtMontoDebido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMontoDebidoMouseClicked(evt);
            }
        });
        jPanel5.add(txtMontoDebido, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 272, 270, 30));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 302, 270, 10));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("Costo de Mensualidad");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, -1, -1));

        txtMontoPagado.setBackground(new java.awt.Color(36, 47, 65));
        txtMontoPagado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtMontoPagado.setForeground(new java.awt.Color(255, 255, 255));
        txtMontoPagado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoPagado.setText("Ingrese el monto");
        txtMontoPagado.setBorder(null);
        txtMontoPagado.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMontoPagado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoPagadoFocusGained(evt);
            }
        });
        txtMontoPagado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMontoPagadoMouseClicked(evt);
            }
        });
        txtMontoPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoPagadoActionPerformed(evt);
            }
        });
        jPanel5.add(txtMontoPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 354, 270, 30));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 384, 270, 10));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setText("Monto a Abonar");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        txtClaveP.setForeground(new java.awt.Color(44, 62, 80));
        txtClaveP.setText("jLabel1");
        jPanel5.add(txtClaveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        cbxMesPagos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Ocutubre", "Noviembre", "Diciembre" }));
        cbxMesPagos.setMinimumSize(new java.awt.Dimension(133, 30));
        cbxMesPagos.setPreferredSize(new java.awt.Dimension(133, 32));
        cbxMesPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMesPagosActionPerformed(evt);
            }
        });
        jPanel5.add(cbxMesPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 354, 272, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Mes a pagar");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 322, -1, -1));

        txtMonto.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(0, 204, 204));
        txtMonto.setText("Monto que quedo debiendo");
        jPanel5.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        txtMes.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txtMes.setForeground(new java.awt.Color(0, 204, 204));
        txtMes.setText("Ya se habia efectutado un pago");
        jPanel5.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 326, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        // TODO add your handling code here:

        // toFront();
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMousePressed

//cambios
        double pagado = Double.parseDouble(txtMontoPagado.getText());

        double debido = Double.parseDouble(txtMontoDebido.getText());

        if (pagado <= debido) {

            try {

                ps = con.prepareStatement("INSERT INTO pagos (clave, mes,  monto_pagar, monto_debido, monto_pagado, fecha, hora, liquidado) VALUES (?,?,?,?,?,?,?,?)");

                Double montoDebido = Double.valueOf(txtMontoDebido.getText());
                Double montoPagado = Double.valueOf(txtMontoPagado.getText());
                ps.setString(1, String.valueOf(txtClaveP.getText()));

                String elMes = String.valueOf(cbxMesPagos.getSelectedItem());
                //Selecciona, Enero, Febrero, Marzo, Abril, Mayo, Junio, , , ,, , 
                switch (elMes) {
                    case "Enero": {
                        ps.setString(2, "1");
                        break;
                    }
                    case "Febrero": {
                        ps.setString(2, "2");

                        break;
                    }
                    case "Marzo": {
                        ps.setString(2, "3");
                        break;
                    }
                    case "Abril": {
                        ps.setString(2, "4");
                        break;
                    }
                    case "Mayo": {
                        ps.setString(2, "5");
                        break;
                    }
                    case "Junio": {
                        ps.setString(2, "6");
                        break;
                    }
                    case "Julio": {
                        ps.setString(2, "7");
                        break;
                    }
                    case "Agosto": {
                        ps.setString(2, "8");
                        break;
                    }
                    case "Septiembre": {
                        ps.setString(2, "9");
                        break;
                    }
                    case "Ocutubre": {
                        ps.setString(2, "10");
                        break;
                    }
                    case "Noviembre": {
                        ps.setString(2, "11");
                        break;
                    }
                    case "Diciembre": {
                        ps.setString(2, "12");
                        break;
                    }

                }

                ps.setString(3, String.valueOf(montoDebido - montoPagado));
                ps.setString(4, String.valueOf(montoDebido - montoPagado));
                ps.setString(5, txtMontoPagado.getText());
                ps.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
                ps.setTimestamp(7, getCurrentTimeStamp());

                System.out.println("resultado: " + (debido - pagado));

                if ((debido - pagado) == 0) {
                    ps.setString(8, "si");
                } else {
                    ps.setString(8, "no");
                }

                int res = ps.executeUpdate();

                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Pago Registrado");

                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar el pago");

                }

                con.close();

                this.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(AsistenciaDetalles.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "El Monto a pagar es incorrecto, no puede ser mayor al Monto debido");
            txtMontoPagado.setText("Ingrese el Monto a Pagar");
        }


    }//GEN-LAST:event_btnRegistroMousePressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        btnRegistro.action(null, null);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void imageLabelPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelPMouseClicked


    }//GEN-LAST:event_imageLabelPMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       new Pagos().setVisible(true);
       dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void btnRegistro1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistro1MousePressed
          new Pagos().setVisible(true);
          dispose();
    }//GEN-LAST:event_btnRegistro1MousePressed

    private void btnRegistro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistro1MouseClicked

    }//GEN-LAST:event_btnRegistro1MouseClicked

    private void txtMontoDebidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoDebidoFocusGained
 //   txtMontoDebido.setText("");
    }//GEN-LAST:event_txtMontoDebidoFocusGained

    private void txtMontoDebidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoDebidoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMontoDebidoMouseClicked

    private void txtMontoPagadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoPagadoFocusGained
        txtMontoPagado.setText("");
    }//GEN-LAST:event_txtMontoPagadoFocusGained

    private void txtMontoPagadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoPagadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPagadoMouseClicked

    private void txtMontoPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoPagadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPagadoActionPerformed

    private void cbxMesPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMesPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMesPagosActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PagosDetalles().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnRegistro;
    private javax.swing.JPanel btnRegistro1;
    public static javax.swing.JComboBox<String> cbxMesPagos;
    public static javax.swing.JLabel imageLabelP;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    public static javax.swing.JLabel txtClaveP;
    public static javax.swing.JLabel txtMes;
    public static javax.swing.JLabel txtMonto;
    public static javax.swing.JTextField txtMontoDebido;
    private javax.swing.JTextField txtMontoPagado;
    public static javax.swing.JLabel txtNivelP;
    public static javax.swing.JLabel txtNombreP;
    // End of variables declaration//GEN-END:variables

}
