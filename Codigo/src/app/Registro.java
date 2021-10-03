package app;

import static app.Asistencia.con;
import static app.RegistroDepreceated.con;
import static app.RegistroDepreceated.getConection;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.io.File;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Registro extends javax.swing.JFrame {

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
        Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void limpiarCajas() {
        clave();
        //txtClaveRegistro.setText();
        txtNombreRegistro.setText(null);
        txtDirecRegistro.setText(null);
        txtTelRegistro.setText(null);
        txtEdadRegistro.setText(null);
        chbxGenMRegistro.isSelected();
        chbxGenHRegistro.isSelected();
        datepFechaRegistro.getEditor().setText("");
        cbxNivelRegistro.setSelectedIndex(0);
    }

    public void clave() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT clave, image, nombre, nivel FROM  bailarin ORDER BY clave DESC";
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            rs.next();
            //AsistenciaDetalles ao = new AsistenciaDetalles();
            //AsistenciaDetalles.txtClaveAD.setText(txtClaveRegistro.getText().toString());
            //AsistenciaDetalles.txtNombreA.setText(rs.getString("nombre"));
            //AsistenciaDetalles.txtNivelA.setText(rs.getString("nivel"));

            int clav = Integer.parseInt(rs.getString("clave").substring(2));

            System.out.println("clave recortada desde db: " + clav);

            String clave;
            Calendar c1 = Calendar.getInstance();
            String año = Integer.toString(c1.get(Calendar.YEAR)).replace("20", "");

            int tamaño = String.valueOf(clav).length();

            System.out.println(tamaño);
            if (tamaño == 1) {
                if (clav != 9) {
                    clave = año + "00" + String.valueOf(clav + 1);
                    System.out.println(clave);
                    txtClaveRegistro.setText(clave);

                } else {
                    clave = año + "0" + String.valueOf(clav + 1);
                    System.out.println(clave);
                    txtClaveRegistro.setText(clave);
                }
            } else if (tamaño == 2 && (clav != 99)) {

                if (clav != 99) {
                    clave = año + "0" + String.valueOf(clav + 1);
                    System.out.println(clave);
                    txtClaveRegistro.setText(clave);
                } else {
                    clave = año + String.valueOf(clav + 1);
                    System.out.println(clave);
                    txtClaveRegistro.setText(clave);
                }

            } else if (tamaño == 3) {
                clave = año + String.valueOf(clav + 1);
                System.out.println(clave);
                txtClaveRegistro.setText(clave);
            }

            txtClaveRegistro.setEditable(false);

        } catch (SQLException ex) {
            Logger.getLogger(Asistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Registro() {
        initComponents();
        getConection();
        clave();

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
        txtClaveRegistro = new javax.swing.JTextField();
        txtNombreRegistro = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtDirecRegistro = new javax.swing.JTextField();
        txtTelRegistro = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtEdadRegistro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chbxGenMRegistro = new javax.swing.JCheckBox();
        chbxGenHRegistro = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        cbxNivelRegistro = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        datepFechaRegistro = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel5.setPreferredSize(new java.awt.Dimension(912, 180));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Foto");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Nombre");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        txtClaveRegistro.setBackground(new java.awt.Color(36, 47, 65));
        txtClaveRegistro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtClaveRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtClaveRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClaveRegistro.setText("Ingrese su clave");
        txtClaveRegistro.setBorder(null);
        txtClaveRegistro.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtClaveRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveRegistroFocusGained(evt);
            }
        });
        txtClaveRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClaveRegistroMouseClicked(evt);
            }
        });

        txtNombreRegistro.setBackground(new java.awt.Color(36, 47, 65));
        txtNombreRegistro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombreRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreRegistro.setText("Ingresa el nombre");
        txtNombreRegistro.setBorder(null);
        txtNombreRegistro.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtNombreRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreRegistroFocusGained(evt);
            }
        });
        txtNombreRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRegistroActionPerformed(evt);
            }
        });

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
        jLabel12.setText("Registrar ");
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

        txtDirecRegistro.setBackground(new java.awt.Color(36, 47, 65));
        txtDirecRegistro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDirecRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtDirecRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDirecRegistro.setText("Ingrese su direccion");
        txtDirecRegistro.setBorder(null);
        txtDirecRegistro.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtDirecRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDirecRegistroFocusGained(evt);
            }
        });
        txtDirecRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirecRegistroActionPerformed(evt);
            }
        });

        txtTelRegistro.setBackground(new java.awt.Color(36, 47, 65));
        txtTelRegistro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtTelRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelRegistro.setText("Ingrese su telefono");
        txtTelRegistro.setBorder(null);
        txtTelRegistro.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTelRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelRegistroFocusGained(evt);
            }
        });
        txtTelRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelRegistroMouseClicked(evt);
            }
        });
        txtTelRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelRegistroActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Fecha de nacimiento");

        txtEdadRegistro.setBackground(new java.awt.Color(36, 47, 65));
        txtEdadRegistro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEdadRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtEdadRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEdadRegistro.setText("Ingrese su edad");
        txtEdadRegistro.setBorder(null);
        txtEdadRegistro.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtEdadRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdadRegistroFocusGained(evt);
            }
        });
        txtEdadRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEdadRegistroMouseClicked(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Nivel");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Genero");

        chbxGenMRegistro.setBackground(new java.awt.Color(36, 47, 65));
        chbxGenMRegistro.setForeground(new java.awt.Color(255, 255, 255));
        chbxGenMRegistro.setText("Mujer");
        chbxGenMRegistro.setBorder(null);
        chbxGenMRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxGenMRegistroActionPerformed(evt);
            }
        });

        chbxGenHRegistro.setBackground(new java.awt.Color(36, 47, 65));
        chbxGenHRegistro.setForeground(new java.awt.Color(255, 255, 255));
        chbxGenHRegistro.setText("Hombre");
        chbxGenHRegistro.setBorder(null);
        chbxGenHRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxGenHRegistroActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Telefono");

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        cbxNivelRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Kids", "Compañia Mayor" }));
        cbxNivelRegistro.setMinimumSize(new java.awt.Dimension(133, 30));
        cbxNivelRegistro.setPreferredSize(new java.awt.Dimension(133, 32));
        cbxNivelRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNivelRegistroActionPerformed(evt);
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
                        .addComponent(txtClaveRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtEdadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(txtDirecRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtTelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtNombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(chbxGenMRegistro)
                                .addGap(38, 38, 38)
                                .addComponent(chbxGenHRegistro))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(datepFechaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(cbxNivelRegistro, 0, 272, Short.MAX_VALUE)
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
                        .addComponent(txtDirecRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(13, 13, 13)
                        .addComponent(txtTelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(datepFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addComponent(cbxNivelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClaveRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtNombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbxGenMRegistro)
                            .addComponent(chbxGenHRegistro))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        // TODO add your handling code here:

        toFront();
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        btnRegistro.action(null, null);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void txtNombreRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRegistroActionPerformed

    private void txtNombreRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreRegistroFocusGained
        // TODO add your handling code here:
        txtNombreRegistro.setText("");
    }//GEN-LAST:event_txtNombreRegistroFocusGained

    private void txtClaveRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveRegistroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveRegistroMouseClicked

    private void txtDirecRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirecRegistroFocusGained
        txtDirecRegistro.setText("");
    }//GEN-LAST:event_txtDirecRegistroFocusGained

    private void txtDirecRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirecRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirecRegistroActionPerformed

    private void txtTelRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelRegistroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelRegistroMouseClicked

    private void txtTelRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelRegistroActionPerformed

    private void txtEdadRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadRegistroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadRegistroMouseClicked

    private void chbxGenMRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxGenMRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbxGenMRegistroActionPerformed

    private void chbxGenHRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxGenHRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbxGenHRegistroActionPerformed

    private void cbxNivelRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNivelRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNivelRegistroActionPerformed

    private void txtClaveRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveRegistroFocusGained
        //  txtClaveRegistro.setText("");
    }//GEN-LAST:event_txtClaveRegistroFocusGained

    private void txtTelRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelRegistroFocusGained
        txtTelRegistro.setText("");
    }//GEN-LAST:event_txtTelRegistroFocusGained

    private void txtEdadRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadRegistroFocusGained
        txtEdadRegistro.setText("");
    }//GEN-LAST:event_txtEdadRegistroFocusGained

    private void btnRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMousePressed
        // TODO add your handling code here:

        try {
            ps = con.prepareStatement("INSERT INTO bailarin (image, clave, nombre, direc, tel, edad, genero,fech_nac, nivel) VALUES (?,?,?,?,?,?,?,?,?)");

            FileInputStream fis = null;
            File file = new File(path);

            try {
                fis = new FileInputStream(file);
                ps.setBinaryStream(1, fis, (int) file.length());

            } catch (FileNotFoundException ex) {

                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }

            // ps.set ps
            ps.setString(2, String.valueOf(txtClaveRegistro.getText()));
            ps.setString(3, String.valueOf(txtNombreRegistro.getText()));
            ps.setString(4, String.valueOf(txtDirecRegistro.getText()));
            ps.setString(5, String.valueOf(txtTelRegistro.getText()));
            ps.setString(6, String.valueOf(txtEdadRegistro.getText()));

            if (chbxGenMRegistro.isSelected()) {
                ps.setString(7, String.valueOf(chbxGenMRegistro.getText()));
            } else if (chbxGenHRegistro.isSelected()) {
                ps.setString(7, String.valueOf(chbxGenHRegistro.getText()));
            }

            ps.setDate(8, (datepFechaRegistro.getDate() == null ? null : new java.sql.Date(datepFechaRegistro.getDate().getTime())));

            ps.setString(9, cbxNivelRegistro.getSelectedItem().toString());

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(this, "Bailarín Registrado");
                new Home().setVisible(true);
                dispose();

                //  limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar al bailarín");
                //limpiarCajas();
            }

            con.close();
            fis.close();

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistroMousePressed

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

                new Registro().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnRegistro;
    private javax.swing.JComboBox<String> cbxNivelRegistro;
    private javax.swing.JCheckBox chbxGenHRegistro;
    private javax.swing.JCheckBox chbxGenMRegistro;
    private org.jdesktop.swingx.JXDatePicker datepFechaRegistro;
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
    public static javax.swing.JTextField txtClaveRegistro;
    public static javax.swing.JTextField txtDirecRegistro;
    private javax.swing.JTextField txtEdadRegistro;
    public static javax.swing.JTextField txtNombreRegistro;
    private javax.swing.JTextField txtTelRegistro;
    // End of variables declaration//GEN-END:variables

}
