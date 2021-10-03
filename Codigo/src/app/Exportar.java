package app;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exportar extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/Teocalli";
    public static final String Username = "root";
    public static final String Password = "";
    static Connection con = null;
    private static String path;
    private static Workbook book;
    //private static Workbook bookPagos;
    //private static Workbook bookAsistencias;
    private static Sheet sheet;
    private static Sheet sheetPagos;
    private static Sheet sheetAsistencias;

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, Username, Password);
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return con;
    }

    private void limpiarCajas() {
        //txtClaveRegistro.setText(null);

    }

    public Exportar() {
        initComponents();
        getConection();

        try {
            FileInputStream stream = new FileInputStream(new File("C:\\\\Users\\\\teocali\\\\Documents\\\\Archivos Teocalli\\\\reporte.xlsx"));

            try {
                book = new XSSFWorkbook(stream);

            } catch (IOException ex) {

                Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }

        //bookPagos = new XSSFWorkbook();
        //bookAsistencias = new XSSFWorkbook();
    }

    public void crearExcel() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        /*int tabla = cbxTablaExportar.getSelectedIndex();
        int nivel = cbxNivelExportar.getSelectedIndex();
        int mes = cbxMesExportar.getSelectedIndex();*/
        int mes = cbxMesExportar.getSelectedIndex();

        String whereMes = "";
        if (!"".equals(mes)) {
            whereMes = "WHERE mes= '" + mes + "'";
            System.out.println(whereMes);
        }

        String tabla = cbxTablaExportar.getSelectedItem().toString();
        String whereTabla = "";
        if (!"".equals(tabla)) {
            whereTabla = "WHERE tabla= '" + tabla + "'";
            System.out.println(whereTabla);
        }

        String nivel = cbxNivelExportar.getSelectedItem().toString();
        String whereNivel = "";
        if (!"".equals(nivel)) {
            whereNivel = "WHERE nivel= '" + nivel + "'";
            System.out.println(whereNivel);
        }

        System.out.println("Tabla Seleccionada: " + tabla);

        try {

            if (tabla == "Bailarin") {

                sheet = book.getSheetAt(0);

                int rows = sheet.getPhysicalNumberOfRows();

                System.out.println("Numero de renglones detectados: " + rows);

                for (int i = 9; i < rows; i++) {
                    sheet.removeRow(sheet.getRow(i));
                }

                String sqlTabla = "";

                if (cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && !cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM bailarin " + whereNivel + " ORDER BY nombre ASC";
                } else if (!cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM bailarin ORDER BY nombre ASC";
                } else if (cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM bailarin ORDER BY nombre ASC";
                } else if (!cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && !cbxMesExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM bailarin ORDER BY nombre ASC" + whereNivel;
                }

                System.out.println(sqlTabla);

                ps = con.prepareStatement(sqlTabla);
                rs = ps.executeQuery();
                
              

                int numCol = rs.getMetaData().getColumnCount();

                int i = 8;
                
                ResultSet res = rs;

                   

                while (rs.next()) {

                    i++;

                    Row filaDatos = sheet.createRow(i);

                    for (int a = 0; a < numCol; a++) {

                        int k = 0;

                        if (a == 2) {
                            k = 1;
                            //sheet.addMergedRegion(new CellRangeAddress(1, i, 2, i));
                        }

                        if (a >= 3) {
                            k = 2;
                        }

                        if (a == 3) {
                            // sheet.addMergedRegion(new CellRangeAddress(3, i, 3, i));
                        }

                        Cell celDatos = filaDatos.createCell(a + k);

                        if (a == 6) {
                            celDatos.setCellValue(rs.getDate(a + 1).toString());
                        } else {
                            celDatos.setCellValue(rs.getString(a + 1));
                        }

                    }

                }
   


                FileOutputStream fileout = new FileOutputStream(new File("C:\\Users\\teocali\\Documents\\Archivos Teocalli\\reporte.xlsx"));
                book.write(fileout);
                fileout.close();
                
                JOptionPane.showMessageDialog(this, "Archivo Exportado");
                
            }

            if (tabla == "Pagos") {

                sheetPagos = book.getSheetAt(1);

                int rows = sheetPagos.getPhysicalNumberOfRows();

                for (int i = 9; i < rows; i++) {
                    sheetPagos.removeRow(sheetPagos.getRow(i));
                }

                String sqlTabla = "";

                if (cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && !cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT pagos.* , bailarin.nivel FROM pagos INNER JOIN bailarin ON pagos.clave = bailarin.clave " + whereNivel;
                } else if (!cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT pagos.* , bailarin.nivel FROM pagos INNER JOIN bailarin ON pagos.clave = bailarin.clave " + whereMes;
                } else if (cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT pagos.* , bailarin.nivel  FROM pagos INNER JOIN bailarin ON pagos.clave = bailarin.clave";
                } else if (!cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && !cbxMesExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT pagos.* , bailarin.nivel FROM pagos INNER JOIN bailarin ON pagos.clave = bailarin.clave " + "WHERE mes='" + mes + "' AND nivel ='" + nivel + "'";
                }
                //sqlTabla = "SELECT pagos.* , bailarin.nivel FROM pagos, bailarin " + whereNivel;
                System.out.println(sqlTabla);

                ps = con.prepareStatement(sqlTabla);
                rs = ps.executeQuery();

                int numCol = rs.getMetaData().getColumnCount();

                int i = 8;

                while (rs.next()) {

                    i++;
                    Row filaDatos = sheetPagos.createRow(i);

                    for (int a = 0; a < numCol; a++) {
                        Cell celDatos = filaDatos.createCell(a);

                        if (a == 7) {
                            celDatos.setCellValue(rs.getDate(a + 1).toString());
                        } else {
                            celDatos.setCellValue(rs.getString(a + 1));
                        }

                    }

                }

                FileOutputStream fileoutPagos = new FileOutputStream("C:\\Users\\teocali\\Documents\\Archivos Teocalli\\reporte.xlsx");
                book.write(fileoutPagos);
                fileoutPagos.close();
                
                JOptionPane.showMessageDialog(this, "Archivo Exportado");
            }

            if (tabla == "Asistencias") {

                sheetAsistencias = book.getSheetAt(2);

                int rows = sheetAsistencias.getPhysicalNumberOfRows();

                for (int i = 9; i < rows; i++) {
                    sheetAsistencias.removeRow(sheetAsistencias.getRow(i));
                }

                String sqlTabla = "";

                if (cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && !cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT asistencias.* , bailarin.nivel FROM asistencias INNER JOIN bailarin ON asistencias.clave = bailarin.clave " + whereNivel;
                } else if (!cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT asistencias.* , bailarin.nivel FROM asistencias INNER JOIN bailarin ON asistencias.clave = bailarin.clave " + whereMes;
                } else if (cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && cbxNivelExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT asistencias.* , bailarin.nivel FROM asistencias INNER JOIN bailarin ON asistencias.clave = bailarin.clave ";
                } else if (!cbxMesExportar.getSelectedItem().toString().equals("Seleccione") && !cbxMesExportar.getSelectedItem().toString().equals("Seleccione")) {
                    sqlTabla = "SELECT asistencias.* , bailarin.nivel FROM asistencias INNER JOIN bailarin ON asistencias.clave = bailarin.clave " + "WHERE mes='" + mes + "' AND nivel ='" + nivel + "'";
                }

                System.out.println(sqlTabla);

                ps = con.prepareStatement(sqlTabla);
                rs = ps.executeQuery();

                int numCol = rs.getMetaData().getColumnCount();

                int i = 8;

                while (rs.next()) {

                    i++;
                    Row filaDatos = sheetAsistencias.createRow(i);

                    for (int a = 0; a < numCol; a++) {
                        
                          Cell celDatos;
                        if(a>=3 && a<4){
                            celDatos = filaDatos.createCell(a+1);
                        }else if(a>=4 && a<5){
                            celDatos = filaDatos.createCell(a+2);
                        }
                        else if(a>=5){
                            celDatos = filaDatos.createCell(a+3);
                        }
                        else {
                            celDatos = filaDatos.createCell(a);
                        }
                         

                        if (a == 7) {
                            celDatos.setCellValue(rs.getDate(a + 1).toString());
                        } else {
                            celDatos.setCellValue(rs.getString(a + 1));
                        }

                    }

                }

                FileOutputStream fileoutAsistencias = new FileOutputStream("C:\\Users\\teocali\\Documents\\Archivos Teocalli\\reporte.xlsx");
                book.write(fileoutAsistencias);
                fileoutAsistencias.close();
                
                JOptionPane.showMessageDialog(this, "Archivo Exportado");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
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
        btnExportar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JLabel();
        txtNivelP = new javax.swing.JLabel();
        txtClaveP = new javax.swing.JLabel();
        cbxTablaExportar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMes = new javax.swing.JLabel();
        txtNivelP1 = new javax.swing.JLabel();
        cbxNivelExportar = new javax.swing.JComboBox<>();
        txtNivelP2 = new javax.swing.JLabel();
        cbxMesExportar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(912, 180));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_48px_1.png"))); // NOI18N
        jLabel15.setText("Exportar");

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

        btnExportar.setBackground(new java.awt.Color(26, 188, 156));
        btnExportar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportar.setForeground(new java.awt.Color(44, 62, 80));
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExportarMousePressed(evt);
            }
        });
        btnExportar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("EMAIL");
        btnExportar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jLabel12.setBackground(new java.awt.Color(44, 62, 80));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(44, 62, 80));
        jLabel12.setText("Exportar");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        btnExportar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel5.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 504, 170, 40));

        txtNombreP.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtNombreP.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreP.setText("Seleccione los campos que quiere exportar");
        jPanel5.add(txtNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        txtNivelP.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtNivelP.setForeground(new java.awt.Color(204, 204, 204));
        txtNivelP.setText("Tabla que quiere exportar:");
        jPanel5.add(txtNivelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        txtClaveP.setForeground(new java.awt.Color(44, 62, 80));
        txtClaveP.setText("jLabel1");
        jPanel5.add(txtClaveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        cbxTablaExportar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Bailarin", "Pagos", "Asistencias" }));
        cbxTablaExportar.setMinimumSize(new java.awt.Dimension(133, 30));
        cbxTablaExportar.setPreferredSize(new java.awt.Dimension(133, 32));
        cbxTablaExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTablaExportarActionPerformed(evt);
            }
        });
        jPanel5.add(cbxTablaExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 272, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("El archivo se exporto en: ");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, 40));

        txtMes.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txtMes.setForeground(new java.awt.Color(0, 204, 204));
        txtMes.setText("C:\\\\Users\\\\teocali\\\\Documents\\\\Archivos Teocalli\\\\reporte.xlsx");
        jPanel5.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, 30));

        txtNivelP1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtNivelP1.setForeground(new java.awt.Color(204, 204, 204));
        txtNivelP1.setText("Por nivel:");
        jPanel5.add(txtNivelP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        cbxNivelExportar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Compañia Mayor", "Kids" }));
        cbxNivelExportar.setMinimumSize(new java.awt.Dimension(133, 30));
        cbxNivelExportar.setPreferredSize(new java.awt.Dimension(133, 32));
        cbxNivelExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNivelExportarActionPerformed(evt);
            }
        });
        jPanel5.add(cbxNivelExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 272, 30));

        txtNivelP2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtNivelP2.setForeground(new java.awt.Color(204, 204, 204));
        txtNivelP2.setText("Por mes:");
        jPanel5.add(txtNivelP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        cbxMesExportar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Ocutubre", "Noviembre", "Diciembre" }));
        cbxMesExportar.setMinimumSize(new java.awt.Dimension(133, 30));
        cbxMesExportar.setPreferredSize(new java.awt.Dimension(133, 32));
        cbxMesExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMesExportarActionPerformed(evt);
            }
        });
        jPanel5.add(cbxMesExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 272, 30));

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

    private void btnExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseClicked

        // TODO add your handling code here:

    }//GEN-LAST:event_btnExportarMouseClicked

    private void btnExportarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMousePressed

        crearExcel();


    }//GEN-LAST:event_btnExportarMousePressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked


    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void btnRegistro1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistro1MousePressed
        dispose();
    }//GEN-LAST:event_btnRegistro1MousePressed

    private void btnRegistro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistro1MouseClicked

    }//GEN-LAST:event_btnRegistro1MouseClicked

    private void cbxTablaExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTablaExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTablaExportarActionPerformed

    private void cbxNivelExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNivelExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNivelExportarActionPerformed

    private void cbxMesExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMesExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMesExportarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDepreceated.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDepreceated.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Exportar().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExportar;
    private javax.swing.JPanel btnRegistro1;
    public static javax.swing.JComboBox<String> cbxMesExportar;
    public static javax.swing.JComboBox<String> cbxNivelExportar;
    public static javax.swing.JComboBox<String> cbxTablaExportar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JLabel txtClaveP;
    public static javax.swing.JLabel txtMes;
    public static javax.swing.JLabel txtNivelP;
    public static javax.swing.JLabel txtNivelP1;
    public static javax.swing.JLabel txtNivelP2;
    public static javax.swing.JLabel txtNombreP;
    // End of variables declaration//GEN-END:variables

}
