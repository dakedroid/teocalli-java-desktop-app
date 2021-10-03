/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static app.Asistencia.con;
import static app.Asistencia.txtClaveRegistro;
import static app.Modificar.datepFechaM;
import static app.PagosDetalles.cbxMesPagos;
import static app.PagosDetalles.txtClaveP;
import static app.PagosDetalles.txtMes;
import static app.PagosDetalles.txtMonto;
import static app.PagosDetalles.txtMontoDebido;
import static app.RegistroDepreceated.con;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author proxc
 */
public class Consulta extends javax.swing.JFrame {

    ArrayList<Bailarin> bailarinesL;

    /**
     * Creates new form Home15
     */
    public Consulta() {
        initComponents();
        jtTeo.setDefaultEditor(Object.class, null);
        jtTeo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2) {

                    System.out.println("Click en: " + row);

                    String[] options = new String[]{"Editar", "Borrar", "Cancelar"};
                    int response = JOptionPane.showOptionDialog(null, "Seleccionar una opcion", "Opciones de estudiante",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    if (response == 0) {
                        Modificar act = new Modificar();
                        int fila = jtTeo.getSelectedRow();

                        Modificar.txtClaveM.setText(jtTeo.getValueAt(fila, 0).toString());
                        Modificar.txtClaveM.setEnabled(false);
                        Modificar.txtNombreM.setText(jtTeo.getValueAt(fila, 1).toString());
                        Modificar.txtDirecM.setText(jtTeo.getValueAt(fila, 2).toString());
                        Modificar.txtTelM.setText(jtTeo.getValueAt(fila, 3).toString());
                        Modificar.txtEdadM.setText(jtTeo.getValueAt(fila, 4).toString());

                        String sexo = jtTeo.getValueAt(fila, 5).toString();
                        System.out.println("SEXO " + sexo);

                        if (sexo.equals("Femenino")) {
                            Modificar.chbxGenMM.setSelected(true);
                        } else if (sexo.equals("Hombre")) {
                            Modificar.chbxGenHM.setSelected(true);
                        }

                        Modificar.datepFechaM.setDate((Date) jtTeo.getValueAt(fila, 6)); //== null ? null : new java.sql.Date(datepFechaM.getDate().getTime()))
                        Modificar.cbxNivelM.setSelectedItem(jtTeo.getValueAt(fila, 7).toString());
                        act.setVisible(true);
                    } else if (response == 1) {

                        try {

                            // DefaultTableModel modelo = new DefaultTableModel();
                            // jtTeo.setModel(modelo);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            Conexion conn = new Conexion();
                            Connection con = conn.getConexion();

                            String clave = jtTeo.getValueAt(row, 0).toString();
                            ps = con.prepareStatement("DELETE FROM bailarin WHERE clave=?");
                            ps.setString(1, clave);
                            ps.execute();

                            JOptionPane.showMessageDialog(null, "Bailarín Eliminado");

                            DefaultTableModel modelo = new DefaultTableModel();
                            jtTeo.setModel(modelo);
                            modelo.removeRow(row);

                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }
                    // your valueChanged overridden method 
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_bailarines = new javax.swing.JLabel();
        btn_pagos = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_asistencias = new javax.swing.JLabel();
        jsClave = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtCampo = new javax.swing.JTextField();
        indicator = new javax.swing.JSeparator();
        lbl_identificacion = new javax.swing.JLabel();
        lbl_nivel = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        home = new javax.swing.JPanel();
        bailarines = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTeo = new javax.swing.JTable();
        asistencias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTAsistencias = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_segundolugar = new javax.swing.JLabel();
        txt_nombre_asistencia = new javax.swing.JLabel();
        txt_compañia_asistencia = new javax.swing.JLabel();
        txt_dias_asistencia = new javax.swing.JLabel();
        txt_asistencia_mes = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_primerlugar = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_tercerlugar = new javax.swing.JLabel();
        pagos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTPagos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_nombreP = new javax.swing.JLabel();
        txt_nivelP = new javax.swing.JLabel();
        txt_mes_debido = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_deudaP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(44, 62, 80));
        header.setPreferredSize(new java.awt.Dimension(838, 200));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(44, 62, 80));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 0, 32, -1));

        btn_bailarines.setBackground(new java.awt.Color(0, 102, 102));
        btn_bailarines.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_bailarines.setForeground(new java.awt.Color(255, 255, 255));
        btn_bailarines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_bailarines.setText("Bailarines");
        btn_bailarines.setOpaque(true);
        btn_bailarines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bailarinesMouseClicked(evt);
            }
        });
        header.add(btn_bailarines, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 146, 30));

        btn_pagos.setBackground(new java.awt.Color(26, 188, 156));
        btn_pagos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pagos.setForeground(new java.awt.Color(255, 255, 255));
        btn_pagos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_pagos.setText("Pagos");
        btn_pagos.setOpaque(true);
        btn_pagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pagosMouseClicked(evt);
            }
        });
        header.add(btn_pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 200, 146, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_48px_1.png"))); // NOI18N
        jLabel15.setText("Consulta de Bailarines");
        header.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btn_asistencias.setBackground(new java.awt.Color(26, 188, 156));
        btn_asistencias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_asistencias.setForeground(new java.awt.Color(255, 255, 255));
        btn_asistencias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_asistencias.setText("Asistencias");
        btn_asistencias.setOpaque(true);
        btn_asistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_asistenciasMouseClicked(evt);
            }
        });
        header.add(btn_asistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 200, 146, 30));
        header.add(jsClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 348, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_20px_1.png"))); // NOI18N
        header.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        txtCampo.setBackground(new java.awt.Color(44, 62, 80));
        txtCampo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCampo.setForeground(new java.awt.Color(255, 255, 255));
        txtCampo.setBorder(null);
        txtCampo.setCaretColor(new java.awt.Color(255, 255, 255));
        header.add(txtCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 134, 350, 25));

        indicator.setForeground(new java.awt.Color(11, 181, 217));
        indicator.setPreferredSize(new java.awt.Dimension(50, 15));
        header.add(indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 110, 50, -1));

        lbl_identificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_identificacion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_identificacion.setText("Identificacion");
        lbl_identificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_identificacionMouseClicked(evt);
            }
        });
        header.add(lbl_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        lbl_nivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nivel.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nivel.setText("Nivel");
        lbl_nivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nivelMouseClicked(evt);
            }
        });
        header.add(lbl_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre.setText("Nombre");
        lbl_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nombreMouseClicked(evt);
            }
        });
        header.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        header.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, -1, -1));

        main.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 876, 230));

        home.setLayout(new java.awt.CardLayout());

        bailarines.setBackground(new java.awt.Color(255, 255, 255));
        bailarines.setLayout(new javax.swing.BoxLayout(bailarines, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jtTeo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jtTeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Direccion", "Teléfono", "Edad", "Género", "Fecha de Nacimiento", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTeo.setGridColor(new java.awt.Color(255, 255, 255));
        jtTeo.setRowHeight(20);
        jtTeo.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jtTeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTeoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTeo);

        bailarines.add(jScrollPane1);

        home.add(bailarines, "card3");

        asistencias.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        JTAsistencias.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        JTAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Fecha", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTAsistencias.setGridColor(new java.awt.Color(255, 255, 255));
        JTAsistencias.setRowHeight(20);
        JTAsistencias.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane2.setViewportView(JTAsistencias);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(285, 403));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(389, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(44, 62, 80));
        jLabel6.setText("Nombre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setText("Asistencias en el mes:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(44, 62, 80));
        jLabel9.setText("Asistencias en la semana:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(44, 62, 80));
        jLabel8.setText("Nivel:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(44, 62, 80));
        jLabel11.setText("Tercer lugar en Asistencia");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        txt_segundolugar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_segundolugar.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_segundolugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        txt_nombre_asistencia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_nombre_asistencia.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_nombre_asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        txt_compañia_asistencia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_compañia_asistencia.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_compañia_asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txt_dias_asistencia.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_dias_asistencia.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_dias_asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_asistencia_mes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_asistencia_mes.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_asistencia_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(44, 62, 80));
        jLabel21.setText("Resumen del mes");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(44, 62, 80));
        jLabel22.setText("Segundo lugar en Asistencia");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        txt_primerlugar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_primerlugar.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_primerlugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(44, 62, 80));
        jLabel24.setText("Datos del Alumno");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(44, 62, 80));
        jLabel12.setText("Primer lugar en Asistencia");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txt_tercerlugar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_tercerlugar.setForeground(new java.awt.Color(44, 62, 80));
        jPanel2.add(txt_tercerlugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout asistenciasLayout = new javax.swing.GroupLayout(asistencias);
        asistencias.setLayout(asistenciasLayout);
        asistenciasLayout.setHorizontalGroup(
            asistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistenciasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        asistenciasLayout.setVerticalGroup(
            asistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistenciasLayout.createSequentialGroup()
                .addGroup(asistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        home.add(asistencias, "card3");

        pagos.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 500));

        JTPagos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        JTPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Mes", "M.Pagado", "M.Debido", "Fecha", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTPagos.setGridColor(new java.awt.Color(255, 255, 255));
        JTPagos.setRowHeight(20);
        JTPagos.setSelectionBackground(new java.awt.Color(1, 198, 83));
        jScrollPane4.setViewportView(JTPagos);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(285, 403));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(389, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(44, 62, 80));
        jLabel25.setText("Nombre:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(44, 62, 80));
        jLabel28.setText("Último mes:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(44, 62, 80));
        jLabel29.setText("Nivel:");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txt_nombreP.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_nombreP.setForeground(new java.awt.Color(44, 62, 80));
        jPanel3.add(txt_nombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        txt_nivelP.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_nivelP.setForeground(new java.awt.Color(44, 62, 80));
        jPanel3.add(txt_nivelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txt_mes_debido.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_mes_debido.setForeground(new java.awt.Color(44, 62, 80));
        jPanel3.add(txt_mes_debido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLabel42.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(44, 62, 80));
        jLabel42.setText("Datos del Alumno");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(44, 62, 80));
        jLabel30.setText("Monto debido:");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_deudaP.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_deudaP.setForeground(new java.awt.Color(44, 62, 80));
        jPanel3.add(txt_deudaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jScrollPane5.setViewportView(jPanel3);

        javax.swing.GroupLayout pagosLayout = new javax.swing.GroupLayout(pagos);
        pagos.setLayout(pagosLayout);
        pagosLayout.setHorizontalGroup(
            pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
        pagosLayout.setVerticalGroup(
            pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        home.add(pagos, "card3");

        main.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 236, -1, 308));

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_headerMouseDragged

    private void btn_pagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pagosMouseClicked
        // TODO add your handling code here:
        resetLblColor(btn_bailarines);
        resetLblColor(btn_asistencias);
        setLblColor(btn_pagos);

        lbl_nombre.setVisible(false);
        lbl_nivel.setVisible(false);
        indicator.setLocation(404, 110);

        bailarines.setVisible(false);
        asistencias.setVisible(false);
        pagos.setVisible(true);
    }//GEN-LAST:event_btn_pagosMouseClicked

    private void btn_bailarinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bailarinesMouseClicked
        // TODO add your handling code here:

        setLblColor(btn_bailarines);
        resetLblColor(btn_asistencias);
        resetLblColor(btn_pagos);
        //switch bettween Jpanels
        lbl_nombre.setVisible(true);
        lbl_nivel.setVisible(true);
        indicator.setLocation(272, 110);

        bailarines.setVisible(true);
        asistencias.setVisible(false);
        pagos.setVisible(false);


    }//GEN-LAST:event_btn_bailarinesMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_asistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_asistenciasMouseClicked

        resetLblColor(btn_bailarines);
        setLblColor(btn_asistencias);
        resetLblColor(btn_pagos);
        //switch bettween Jpanels

        lbl_nombre.setVisible(false);
        lbl_nivel.setVisible(false);
        indicator.setLocation(404, 110);

        bailarines.setVisible(false);
        asistencias.setVisible(true);
        pagos.setVisible(false);


    }//GEN-LAST:event_btn_asistenciasMouseClicked

    private void lbl_identificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_identificacionMouseClicked
        // TODO add your handling code here:
        indicator.setLocation(404, 110);
    }//GEN-LAST:event_lbl_identificacionMouseClicked

    private void lbl_nivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nivelMouseClicked
        // TODO add your handling code here:
        indicator.setLocation(522, 110);
    }//GEN-LAST:event_lbl_nivelMouseClicked

    private void lbl_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nombreMouseClicked
        // TODO add your handling code here:

        // 270 x 90
        indicator.setLocation(272, 110);

    }//GEN-LAST:event_lbl_nombreMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:

        if (btn_asistencias.getBackground().getRed() == 0) {

            System.out.println("asistencias");

            String campo = txtCampo.getText();
            String where = "";

            if (!"".equals(campo)) {
                where = "WHERE clave= '" + campo + "'";

            }

            try {
                DefaultTableModel modelo = new DefaultTableModel();
                PreparedStatement ps = null;
                ResultSet rs = null;

                Conexion conn = new Conexion();
                Connection con = conn.getConexion();

                String sql = "SELECT id,clave,fecha,hora FROM asistencias " + where;
                System.out.println(sql);
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();

                modelo.addColumn("ID");
                modelo.addColumn("Clave");
                modelo.addColumn("Fecha");
                modelo.addColumn("Hora");

                int[] anchos = {100, 100, 100, 100};
                for (int x = 0; x < cantidadColumnas; x++) {
                    JTAsistencias.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
                }

                LocalDate date = LocalDate.now();

                ArrayList<String> asistencia = new ArrayList<String>();

                while (rs.next()) {

                    Object[] filas = new Object[cantidadColumnas];

                    for (int i = 0; i < cantidadColumnas; i++) {
                        filas[i] = rs.getObject(i + 1);

                        if (i == 2) {
                            String sDate = String.valueOf(rs.getObject(i + 1)).replace("-", "/");
                            LocalDate localDate1 = LocalDate.parse(sDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                            if (localDate1.getMonth().equals(date.getMonth())) {
                                asistencia.add(String.valueOf(localDate1.getDayOfMonth()));
                            }

                            System.out.println("String -> java.time.LocalDate: " + localDate1.getMonth());
                            System.out.println(date.getMonth());
                        }

                    }

                    modelo.addRow(filas);
                    JTAsistencias.setModel(modelo);
                }
                HashSet hs = new HashSet();

                hs.addAll(asistencia);
                asistencia.clear();
                asistencia.addAll(hs);

                if (!"".equals(txtCampo.getText().toString())) {
                txt_asistencia_mes.setText(String.valueOf(asistencia.size()));
                }
                String dias = "";
                

                for (int i = 0; i <= asistencia.size() - 1; i++) {
                    dias += asistencia.get(i) + ",";

                }
                System.out.println(dias);
                if (!"".equals(txtCampo.getText().toString())) {
                txt_dias_asistencia.setText(dias);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }

            where = "";
            if (!"".equals(txtCampo.getText().toString())) {
                where = "WHERE clave= '" + txtCampo.getText().toString() + "'";

            }
            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT nombre, nivel FROM  bailarin " + where;
            System.out.println(sql);
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                if (rs.next()) {

                    if (!"".equals(txtCampo.getText().toString())) {
                        txt_nombre_asistencia.setText(rs.getString("nombre"));
                        txt_compañia_asistencia.setText(rs.getString("nivel"));
                        

                    }

                }
            } catch (Exception e) {
                System.err.println(e);
            }

            buscarMejores();

//
        } else if (btn_bailarines.getBackground().getRed() == 0) {
            System.out.print("estudiantes");
            switch (indicator.getLocation().x) {
                case 272:
                    opcionNombre();
                    break;
                case 404:
                    opcionClave();
                    break;
                case 522:
                    opcionNivel();
                    break;
                default:
                    break;
            }

        } else if (btn_pagos.getBackground().getRed() == 0) {

            String campo = txtCampo.getText();
            String where = "";

            if (!"".equals(campo)) {
                where = "WHERE clave= '" + campo + "'";

            }

            try {
                DefaultTableModel modelo = new DefaultTableModel();
                PreparedStatement ps = null;
                ResultSet rs = null;

                Conexion conn = new Conexion();
                Connection con = conn.getConexion();

                String sql = "SELECT id,clave, mes, monto_pagado, monto_debido,fecha,hora  FROM pagos " + where;
                System.out.println(sql);
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();

                modelo.addColumn("ID");
                modelo.addColumn("Clave");
                modelo.addColumn("Mes");
                modelo.addColumn("M.Pagado");
                modelo.addColumn("M.Debido");
                modelo.addColumn("Fecha");
                modelo.addColumn("Hora");

                int[] anchos = {80, 80, 80, 80, 80, 80, 80};
                for (int x = 0; x < cantidadColumnas; x++) {
                    JTPagos.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
                }

                LocalDate date = LocalDate.now();
                ArrayList<String> pagos = new ArrayList<String>();
                while (rs.next()) {

                    Object[] filas = new Object[cantidadColumnas];

                    for (int i = 0; i < cantidadColumnas; i++) {
                        filas[i] = rs.getObject(i + 1);

                        if (i == 4) {
                            if (!"".equals(txtCampo.getText().toString())){
                            txt_deudaP.setText(rs.getString("monto_debido"));
                            }
                        } else if (i == 2) {
                            if (!"".equals(txtCampo.getText().toString())){
                            txt_mes_debido.setText(rs.getString("mes"));
                            }
                        }

                    }

                    modelo.addRow(filas);
                    JTPagos.setModel(modelo);
                }

            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }

            where = "";
            if (!"".equals(txtCampo.getText().toString())) {
                where = "WHERE clave= '" + txtCampo.getText().toString() + "'";

            }
            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT nombre, nivel FROM  bailarin " + where;
            System.out.println(sql);

            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                if (rs.next()) {
                    if (!"".equals(txtCampo.getText().toString())){
                    txt_nombreP.setText(rs.getString("nombre"));
                    txt_nivelP.setText(rs.getString("nivel"));
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
            }

        }


    }//GEN-LAST:event_btnBuscarMouseClicked

    private void jtTeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTeoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTeoMouseClicked

    int xx;
    int xy;

    // ------------switch between colors for Active/Inactive color
    public void setLblColor(JLabel lbl) {
        // [0,102,102] sombreado

        lbl.setBackground(new Color(0, 102, 102));
    }

    public void resetLblColor(JLabel lbl) {
        // natural [26,188,156]
        lbl.setBackground(new Color(26, 188, 156));
    }

    //-----------End --------
    //Let's create staff options and Avoid data
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //Change UI look of table.
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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Consulta().setVisible(true);
        });
    }

    public int conseguirMes() {

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        int mes = 0;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT  mes  FROM asistencias " + " where id=(SELECT max(id) FROM asistencias)";
        System.out.println(sql);

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // System.out.println("consulta "  + rs.getInt("mes"));
            if (rs.next()) {

                mes = rs.getInt("mes");

                System.out.println("mes conseguido: " + mes);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PagosDetalles.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mes;
    }

    public void llenarNombresClaves() {

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT  clave, nombre FROM bailarin";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            String clave;
            String nombre;

            // System.out.println("consulta "  + rs.getInt("mes"));
            while (rs.next()) {

                Bailarin bailarin = new Bailarin();

                clave = rs.getString("clave");
                nombre = rs.getString("nombre");

                bailarin.setClave(clave);
                bailarin.setNombre(nombre);

                System.out.println("nombre y clave; " + clave + " " + nombre);

                bailarinesL.add(bailarin);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PagosDetalles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void obtenerPuntuacion(int index, String clave, String mes) {

        System.out.println("Puntacion del alumno  " + clave);
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String where = "";
        if (!"".equals(clave)) {
            where = "WHERE clave= '" + clave + "'" + " AND mes= '" + mes + "'";

        }

        String sql = "SELECT  hora FROM asistencias " + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            String hora;

            int i = 0;

            int puntos = 0;
            int puntuacion = 0;

            // System.out.println("consulta "  + rs.getInt("mes"));
            while (rs.next()) {

                hora = rs.getString("hora");

                String h = hora.substring(0, 2);

                String m = hora.substring(3, 5);

                System.out.println("hora: " + h);

                System.out.println("hora: " + m);

                int hint = Integer.parseInt(h);

                int mint = Integer.parseInt(m);

                if (hint == 19) {
                    if (mint <= 10 && mint >= 0) {
                        puntos = 1;
                    }
                } else if (hint == 18) {
                    if (mint >= 30 && mint < 40) {
                        puntos = 4;
                    } else if (mint >= 40 && mint < 50) {
                        puntos = 3;
                    } else if (mint >= 50 && mint <= 59) {
                        puntos = 2;
                    }
                } else {
                    puntos = 0;
                }

                puntuacion += puntos;

                i++;

            }

            bailarinesL.get(index).setPuntuacion(String.valueOf(puntuacion));

            System.out.println("puntuacion :" + puntuacion);

        } catch (SQLException ex) {
            Logger.getLogger(PagosDetalles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buscarMejores() {

        bailarinesL = new ArrayList();

        /// obtener el mes en numero, ejemplo 6
        int mes = conseguirMes();

        llenarNombresClaves();

        int i = 0;

        while (i < bailarinesL.size()) {

            System.out.println("i: " + i);

            String clave = bailarinesL.get(i).getClave();

            obtenerPuntuacion(i, clave, String.valueOf(mes));

            i++;
        }

        int j = 0;

        int mayor = -1;

        ArrayList<String> ganadores = new ArrayList<>();

        int index = 0;

        for (int k = 0; k < 3; k++) {
            String nombre = "";
            while (j < bailarinesL.size()) {

                int valor = Integer.parseInt(bailarinesL.get(j).getPuntuacion());

                if (valor > mayor) {
                    mayor = valor;
                    index = j;

                    nombre = bailarinesL.get(j).getNombre();

                }

                j++;

            }

            ganadores.add(nombre);
            bailarinesL.remove(index);

            index = 0;

            mayor = -1;

            j = 0;

        }

        for (int x = 0; x < ganadores.size(); x++) {
            System.out.println("Ganador : " + x + "  " + ganadores.get(x));

            if (x == 0) {
                txt_primerlugar.setText(ganadores.get(x));
            }

            if (x == 1) {
                txt_segundolugar.setText(ganadores.get(x));
            }

            if (x == 2) {
                txt_tercerlugar.setText(ganadores.get(x));
            }
        }

        // consulta  rs.getInt()
        /// while i < size 
        // select hora asistencias where id = bailarines.get(i).getClave();
    }

    public void opcionNombre() {

        String campo = txtCampo.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "WHERE nombre= '" + campo + "'";

        }

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtTeo.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM  bailarin " + where;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Clave");
            modelo.addColumn("Nombre");
            modelo.addColumn("Dirección");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Edad");
            modelo.addColumn("Género");
            modelo.addColumn("Fecha de nacimiento");
            modelo.addColumn("Nivel");

            int[] anchos = {100, 500, 600, 300, 100, 300, 300, 300};
            for (int x = 0; x < cantidadColumnas; x++) {
                jtTeo.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    public void opcionClave() {

        String campo = txtCampo.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "WHERE clave = '" + campo + "'";
        }
        try {
            DefaultTableModel modeloTeo = new DefaultTableModel();
            jtTeo.setModel(modeloTeo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM bailarin " + where;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modeloTeo.addColumn("Clave");
            modeloTeo.addColumn("Nombre");
            modeloTeo.addColumn("Dirección");
            modeloTeo.addColumn("Teléfono");
            modeloTeo.addColumn("Edad");
            modeloTeo.addColumn("Género");
            modeloTeo.addColumn("Fecha de nacimiento");
            modeloTeo.addColumn("Nivel");

            int[] anchos = {100, 500, 600, 300, 100, 300, 300, 300};
            for (int x = 0; x < cantidadColumnas; x++) {
                jtTeo.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modeloTeo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void opcionNivel() {

        String campo = txtCampo.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "WHERE nivel = '" + campo + "'";
        }
        try {
            DefaultTableModel modeloTeo = new DefaultTableModel();
            jtTeo.setModel(modeloTeo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT clave, nombre, direc, tel, edad, genero, fech_nac, nivel FROM bailarin " + where;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modeloTeo.addColumn("Clave");
            modeloTeo.addColumn("Nombre");
            modeloTeo.addColumn("Dirección");
            modeloTeo.addColumn("Teléfono");
            modeloTeo.addColumn("Edad");
            modeloTeo.addColumn("Género");
            modeloTeo.addColumn("Fecha de nacimiento");
            modeloTeo.addColumn("Nivel");

            int[] anchos = {100, 500, 600, 300, 100, 300, 300, 300};
            for (int x = 0; x < cantidadColumnas; x++) {
                jtTeo.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modeloTeo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTAsistencias;
    private javax.swing.JTable JTPagos;
    private javax.swing.JPanel asistencias;
    private javax.swing.JPanel bailarines;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btn_asistencias;
    private javax.swing.JLabel btn_bailarines;
    private javax.swing.JLabel btn_pagos;
    private javax.swing.JPanel header;
    private javax.swing.JPanel home;
    private javax.swing.JSeparator indicator;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jsClave;
    private javax.swing.JTable jtTeo;
    private javax.swing.JLabel lbl_identificacion;
    private javax.swing.JLabel lbl_nivel;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pagos;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JLabel txt_asistencia_mes;
    private javax.swing.JLabel txt_compañia_asistencia;
    public static javax.swing.JLabel txt_deudaP;
    private javax.swing.JLabel txt_dias_asistencia;
    public static javax.swing.JLabel txt_mes_debido;
    public static javax.swing.JLabel txt_nivelP;
    public static javax.swing.JLabel txt_nombreP;
    private javax.swing.JLabel txt_nombre_asistencia;
    private javax.swing.JLabel txt_primerlugar;
    private javax.swing.JLabel txt_segundolugar;
    private javax.swing.JLabel txt_tercerlugar;
    // End of variables declaration//GEN-END:variables
}
