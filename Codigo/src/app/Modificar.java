/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static app.Registro.getConection;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.File;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Modificar extends javax.swing.JFrame {

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
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return con;
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void limpiarCajas() {
        txtClaveM.setText(null);
        txtNombreM.setText(null);
        txtDirecM.setText(null);
        txtTelM.setText(null);
        txtEdadM.setText(null);
        chbxGenMM.setSelected(false);
        chbxGenHM.setSelected(false);
        datepFechaM.getEditor().setText("");
        cbxNivelM.setSelectedIndex(0);
    }

    public Modificar() {
        initComponents();
        getConection();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txtClaveM = new javax.swing.JTextField();
        txtNombreM = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtDirecM = new javax.swing.JTextField();
        txtTelM = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtEdadM = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chbxGenMM = new javax.swing.JCheckBox();
        chbxGenHM = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        cbxNivelM = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        datepFechaM = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(912, 180));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_48px_1.png"))); // NOI18N
        jLabel15.setText("Registro de Bailarines");

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

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Foto");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Nombre");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        txtClaveM.setBackground(new java.awt.Color(36, 47, 65));
        txtClaveM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtClaveM.setForeground(new java.awt.Color(255, 255, 255));
        txtClaveM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClaveM.setText("Ingrese su clave");
        txtClaveM.setBorder(null);
        txtClaveM.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtClaveM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveMFocusGained(evt);
            }
        });
        txtClaveM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClaveMMouseClicked(evt);
            }
        });

        txtNombreM.setBackground(new java.awt.Color(36, 47, 65));
        txtNombreM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombreM.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreM.setText("Ingresa el nombre");
        txtNombreM.setBorder(null);
        txtNombreM.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtNombreM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreMFocusGained(evt);
            }
        });
        txtNombreM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMActionPerformed(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(26, 188, 156));
        btnRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistro.setForeground(new java.awt.Color(44, 62, 80));
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistroMousePressed(evt);
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
        jLabel12.setText("Actualizar");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        btnRegistro.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Direccion");

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        txtDirecM.setBackground(new java.awt.Color(36, 47, 65));
        txtDirecM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDirecM.setForeground(new java.awt.Color(255, 255, 255));
        txtDirecM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDirecM.setText("Ingresa su direccion");
        txtDirecM.setBorder(null);
        txtDirecM.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtDirecM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDirecMFocusGained(evt);
            }
        });
        txtDirecM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirecMActionPerformed(evt);
            }
        });

        txtTelM.setBackground(new java.awt.Color(36, 47, 65));
        txtTelM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelM.setForeground(new java.awt.Color(255, 255, 255));
        txtTelM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelM.setText("Ingresa su telefono");
        txtTelM.setBorder(null);
        txtTelM.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTelM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelMFocusGained(evt);
            }
        });
        txtTelM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelMMouseClicked(evt);
            }
        });
        txtTelM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelMActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Fecha de nacimiento");

        txtEdadM.setBackground(new java.awt.Color(36, 47, 65));
        txtEdadM.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEdadM.setForeground(new java.awt.Color(255, 255, 255));
        txtEdadM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEdadM.setText("Ingresa su edad");
        txtEdadM.setBorder(null);
        txtEdadM.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtEdadM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdadMFocusGained(evt);
            }
        });
        txtEdadM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEdadMMouseClicked(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Nivel");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Genero");

        chbxGenMM.setBackground(new java.awt.Color(36, 47, 65));
        chbxGenMM.setForeground(new java.awt.Color(255, 255, 255));
        chbxGenMM.setText("Mujer");
        chbxGenMM.setBorder(null);
        chbxGenMM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxGenMMActionPerformed(evt);
            }
        });

        chbxGenHM.setBackground(new java.awt.Color(36, 47, 65));
        chbxGenHM.setForeground(new java.awt.Color(255, 255, 255));
        chbxGenHM.setText("Hombre");
        chbxGenHM.setBorder(null);
        chbxGenHM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxGenHMActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Telefono");

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        cbxNivelM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Kids", "Compañia Mayor" }));
        cbxNivelM.setMinimumSize(new java.awt.Dimension(133, 30));
        cbxNivelM.setPreferredSize(new java.awt.Dimension(133, 32));
        cbxNivelM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNivelMActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Edad");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group_52px_1.png"))); // NOI18N
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Ingrese los datos");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Clave");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(271, 271, 271)
                        .addComponent(jLabel14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtClaveM, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtEdadM, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addGap(253, 253, 253)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtDirecM, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtTelM, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(chbxGenMM)
                                .addGap(38, 38, 38)
                                .addComponent(chbxGenHM))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(datepFechaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(cbxNivelM, 0, 272, Short.MAX_VALUE)
                            .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11)
                        .addGap(13, 13, 13)
                        .addComponent(txtDirecM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(13, 13, 13)
                        .addComponent(txtTelM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(datepFechaM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addComponent(cbxNivelM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClaveM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdadM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbxGenMM)
                            .addComponent(chbxGenHM))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveMFocusGained
        txtClaveM.setText("");
    }//GEN-LAST:event_txtClaveMFocusGained

    private void txtNombreMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreMFocusGained
        // TODO add your handling code here:
        txtNombreM.setText("");
    }//GEN-LAST:event_txtNombreMFocusGained

    private void txtNombreMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        btnRegistro.action(null, null);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        // TODO add your handling code here:

        toFront();
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMousePressed
        // TODO add your handling code here:
       System.out.println("actualizar");
        actualizar();
        

    }//GEN-LAST:event_btnRegistroMousePressed

    private void txtDirecMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirecMFocusGained

        if (txtDirecM.getText().equals("")) {

            txtDirecM.setText("");
        }
    }//GEN-LAST:event_txtDirecMFocusGained

    private void txtDirecMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirecMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirecMActionPerformed

    private void txtTelMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelMFocusGained
        txtTelM.setText("");
    }//GEN-LAST:event_txtTelMFocusGained

    private void txtTelMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelMMouseClicked

    private void txtTelMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelMActionPerformed

    private void txtEdadMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadMFocusGained
        txtEdadM.setText("");
    }//GEN-LAST:event_txtEdadMFocusGained

    private void txtEdadMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadMMouseClicked

    private void chbxGenMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxGenMMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbxGenMMActionPerformed

    private void chbxGenHMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxGenHMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbxGenHMActionPerformed

    private void cbxNivelMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNivelMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNivelMActionPerformed

    private void imageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseClicked

        String[] options = new String[]{"Tomar Foto", "Seleccionar", "Cancelar"};
        int response = JOptionPane.showOptionDialog(null, "Seleccionar una opcion", "Captura de foto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (response == 1) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                imageLabel.setIcon(ResizeImage(path));
                System.out.println("PATH " + path);
            }
        } else if (response == 0) {

            new Thread(new Runnable() {
                public void run() {
                    SwingUtilities.invokeLater(new AbrirWebcam());
                }
            }).start();
        }

    }//GEN-LAST:event_imageLabelMouseClicked

    private void txtClaveMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveMMouseClicked

    public void actualizar() {
        try {
            ps = con.prepareStatement("UPDATE bailarin SET image=?, clave=?, nombre=?, direc=?, tel=?, edad=?, genero=?, fech_nac=?, nivel=? WHERE clave=?");

            FileInputStream fis = null;
            File file = new File(path);

            try {
                fis = new FileInputStream(file);
                ps.setBinaryStream(1, fis, (int) file.length());

            } catch (FileNotFoundException ex) {

                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }

            // ps.set ps
            
            ps.setString(2, String.valueOf(txtClaveM.getText()));
            ps.setString(3, String.valueOf(txtNombreM.getText()));
            ps.setString(4, String.valueOf(txtDirecM.getText()));
            ps.setString(5, String.valueOf(txtTelM.getText()));
            ps.setString(6, String.valueOf(txtEdadM.getText()));

            if (chbxGenMM.isSelected()) {
                ps.setString(7, String.valueOf(chbxGenMM.getText()));
            } else {
                if (chbxGenHM.isSelected()) {
                    ps.setString(7, String.valueOf(chbxGenHM.getText()));
                }
            }

            ps.setDate(8, (datepFechaM.getDate() == null ? null : new java.sql.Date(datepFechaM.getDate().getTime())));

            ps.setString(9, cbxNivelM.getSelectedItem().toString());

            ps.setString(10, String.valueOf(txtClaveM.getText()));

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(this, "Bailarín Modificado");
                
                dispose();
                limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar al bailarín");
                limpiarCajas();
            }

            con.close();
            fis.close();

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar().setVisible(true);
            }
        });
    }

    // End of variables declaration                   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnRegistro;
    public static javax.swing.JComboBox<String> cbxNivelM;
    public static javax.swing.JCheckBox chbxGenHM;
    public static javax.swing.JCheckBox chbxGenMM;
    public static org.jdesktop.swingx.JXDatePicker datepFechaM;
    public static javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public static javax.swing.JTextField txtClaveM;
    public static javax.swing.JTextField txtDirecM;
    public static javax.swing.JTextField txtEdadM;
    public static javax.swing.JTextField txtNombreM;
    public static javax.swing.JTextField txtTelM;
    // End of variables declaration//GEN-END:variables
}
