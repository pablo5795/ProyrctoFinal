package proyectofinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class ventanaInterna extends javax.swing.JInternalFrame {
    
    private static final String info = "info.txt";
    private static File cliente;
    private Connection conexion;
    private Statement sentencia;
    private static final String[] header = {"DNI","Nombre","Apellido","Telefono"};
    /**
     * Creates new form ventanaInterna
     */
    public ventanaInterna() {
        initComponents();
        rellenarTexto();
        prepararBaseDatos();
        listaClientes();
        jTable1.setEnabled(false);
        jTable2.setEnabled(false);
    }
    
    private void prepararBaseDatos(){
        try {
            String controlador = "com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            
            String DNS = "jdbc:mysql://localhost/gimnasio";
            String user="root";
            String password="";
            conexion = DriverManager.getConnection(DNS, user, password);
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //sentencia = conexion.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Enciende el XAMPP", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listaClientes(){
        ArrayList<String> lista = datos();
        DefaultTableModel model = new DefaultTableModel();
        for(int i=0; i<header.length; i++){
            model.addColumn(header[i]);
        }
        for(int i=0; i<lista.size(); i++){
            model.addRow(lista.get(i).split("/"));
        }
        jTable1.setModel(model);
    }
    
    private ArrayList<String> datos(){
        ArrayList<String> lista = new ArrayList<String>();
        String aux = "";
        try {
            ResultSet r = sentencia.executeQuery("SELECT dni, nombre, apellido, telefono FROM CLIENTES");
            for(int i=0; r.next(); i++){
                aux = r.getString("dni")+"/"+r.getString("nombre")+"/"+r.getString("apellido")+"/"+r.getString("telefono");
                lista.add(aux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    private void rellenarTexto(){
        Path p1 = Paths.get(info);
        Charset charset = Charset.forName("ISO-8859-1");
        if(Files.exists(p1)){
            try {
                BufferedReader reader = Files.newBufferedReader(p1, charset);
                String s;
                while((s = reader.readLine()) != null){
                    jEditorPane1.setText(jEditorPane1.getText()+s+"\n\n");
                }
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Error");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_sexo = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jp_anadir = new javax.swing.JPanel();
        jl_nombre = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jl_apellido = new javax.swing.JLabel();
        tf_apellido = new javax.swing.JTextField();
        jl_dni = new javax.swing.JLabel();
        tf_dni = new javax.swing.JTextField();
        jl_tlf = new javax.swing.JLabel();
        tf_tlf = new javax.swing.JTextField();
        jl_sexo = new javax.swing.JLabel();
        rb_hombre = new javax.swing.JRadioButton();
        rb_mujer = new javax.swing.JRadioButton();
        jl_nacionalidad = new javax.swing.JLabel();
        cob_nacionalidad = new javax.swing.JComboBox<>();
        jl_fecha = new javax.swing.JLabel();
        jl_dia = new javax.swing.JLabel();
        sp_dia = new javax.swing.JSpinner();
        jl_mes = new javax.swing.JLabel();
        cob_mes = new javax.swing.JComboBox<>();
        jl_anio = new javax.swing.JLabel();
        sl_anio = new javax.swing.JSlider();
        jl_ver = new javax.swing.JLabel();
        bt_aceptar = new javax.swing.JButton();
        bt_cerrar = new javax.swing.JButton();
        jp_borrar = new javax.swing.JPanel();
        jl_dni_b = new javax.swing.JLabel();
        tf_dni_b = new javax.swing.JTextField();
        bt_buscar = new javax.swing.JButton();
        jp_infoCliente = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        bt_borrar = new javax.swing.JButton();
        bt_cerrar_b = new javax.swing.JButton();
        jp_clientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt_actualizar = new javax.swing.JButton();
        bt_cerrar_c = new javax.swing.JButton();
        jp_informacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setOpaque(true);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("IDroid", 0, 14)); // NOI18N

        jl_nombre.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_nombre.setText("Nombre:");

        tf_nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jl_apellido.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_apellido.setText("Apellido:");

        tf_apellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jl_dni.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_dni.setText("DNI:");

        tf_dni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jl_tlf.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_tlf.setText("Teléfono:");
        jl_tlf.setToolTipText("");

        tf_tlf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jl_sexo.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_sexo.setText("Sexo:");

        rb_hombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rb_hombre.setMnemonic('0');
        rb_hombre.setSelected(true);
        rb_hombre.setText("Hombre");

        rb_mujer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rb_mujer.setMnemonic('1');
        rb_mujer.setText("Mujer");

        jl_nacionalidad.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_nacionalidad.setText("Nacionalidad:");

        cob_nacionalidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cob_nacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alemania", "Andorra", "Bélgica", "Dinamarca", "España", "Francia", "Italia", "Marruecos", "Portugal" }));

        jl_fecha.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_fecha.setText("Fecha de Nacimiento");

        jl_dia.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_dia.setText("Día:");

        sp_dia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sp_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jl_mes.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_mes.setText("Mes:");

        cob_mes.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cob_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cob_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cob_mesActionPerformed(evt);
            }
        });

        jl_anio.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_anio.setText("Año:");

        sl_anio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sl_anio.setMaximum(2017);
        sl_anio.setMinimum(1950);
        sl_anio.setMinorTickSpacing(1);
        sl_anio.setSnapToTicks(true);
        sl_anio.setValue(1985);
        sl_anio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sl_anioStateChanged(evt);
            }
        });

        jl_ver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        bt_aceptar.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/sign-check-icon.png"))); // NOI18N
        bt_aceptar.setText("ACEPTAR");
        bt_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aceptarActionPerformed(evt);
            }
        });

        bt_cerrar.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/sign-error-icon.png"))); // NOI18N
        bt_cerrar.setText("CERRAR");
        bt_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_anadirLayout = new javax.swing.GroupLayout(jp_anadir);
        jp_anadir.setLayout(jp_anadirLayout);
        jp_anadirLayout.setHorizontalGroup(
            jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_anadirLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_anadirLayout.createSequentialGroup()
                        .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jl_fecha)
                                .addGroup(jp_anadirLayout.createSequentialGroup()
                                    .addComponent(jl_nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(jl_apellido)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jp_anadirLayout.createSequentialGroup()
                                    .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jp_anadirLayout.createSequentialGroup()
                                            .addComponent(jl_dni)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jp_anadirLayout.createSequentialGroup()
                                            .addComponent(jl_nacionalidad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cob_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(34, 34, 34)
                                    .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jp_anadirLayout.createSequentialGroup()
                                            .addComponent(jl_sexo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rb_hombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rb_mujer))
                                        .addGroup(jp_anadirLayout.createSequentialGroup()
                                            .addComponent(jl_tlf)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_tlf, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jp_anadirLayout.createSequentialGroup()
                                    .addComponent(jl_dia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sp_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(jl_mes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cob_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jl_anio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sl_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_anadirLayout.createSequentialGroup()
                                .addComponent(jl_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_anadirLayout.createSequentialGroup()
                        .addComponent(bt_aceptar)
                        .addGap(37, 37, 37)
                        .addComponent(bt_cerrar)
                        .addGap(174, 174, 174))))
        );
        jp_anadirLayout.setVerticalGroup(
            jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_anadirLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_apellido)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_nombre))
                .addGap(26, 26, 26)
                .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_dni)
                    .addComponent(jl_tlf)
                    .addComponent(tf_tlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp_anadirLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jl_nacionalidad))
                        .addComponent(cob_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jl_sexo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_hombre)
                        .addComponent(rb_mujer)))
                .addGap(32, 32, 32)
                .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_anadirLayout.createSequentialGroup()
                        .addComponent(jl_fecha)
                        .addGap(18, 18, 18)
                        .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_dia)
                            .addComponent(sp_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_mes)))
                    .addComponent(cob_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_anio)
                    .addComponent(sl_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jp_anadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_aceptar)
                    .addComponent(bt_cerrar))
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("AÑADIR", jp_anadir);

        jp_borrar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 35));

        jl_dni_b.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        jl_dni_b.setText("DNI:");
        jp_borrar.add(jl_dni_b);

        tf_dni_b.setColumns(20);
        tf_dni_b.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jp_borrar.add(tf_dni_b);

        bt_buscar.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/search_icon-icons.com_54424.png"))); // NOI18N
        bt_buscar.setText("BUSCAR");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });
        jp_borrar.add(bt_buscar);

        jTable2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Telefono"
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
        jTable2.setRowHeight(35);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jp_infoClienteLayout = new javax.swing.GroupLayout(jp_infoCliente);
        jp_infoCliente.setLayout(jp_infoClienteLayout);
        jp_infoClienteLayout.setHorizontalGroup(
            jp_infoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        jp_infoClienteLayout.setVerticalGroup(
            jp_infoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 76, Short.MAX_VALUE))
        );

        jp_borrar.add(jp_infoCliente);

        bt_borrar.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/user-remove-icon.png"))); // NOI18N
        bt_borrar.setText("BORRAR");
        bt_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_borrarActionPerformed(evt);
            }
        });
        jp_borrar.add(bt_borrar);

        bt_cerrar_b.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_cerrar_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/sign-error-icon.png"))); // NOI18N
        bt_cerrar_b.setText("CERRAR");
        bt_cerrar_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cerrar_bActionPerformed(evt);
            }
        });
        jp_borrar.add(bt_cerrar_b);

        jTabbedPane1.addTab("BORRAR", jp_borrar);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Telefono"
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
        jTable1.setRowHeight(25);
        jScrollPane3.setViewportView(jTable1);

        bt_actualizar.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/refresh-icon.png"))); // NOI18N
        bt_actualizar.setText("ACTUALIZAR");
        bt_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualizarActionPerformed(evt);
            }
        });

        bt_cerrar_c.setFont(new java.awt.Font("AngryBirds", 0, 18)); // NOI18N
        bt_cerrar_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/sign-error-icon.png"))); // NOI18N
        bt_cerrar_c.setText("CERRAR");
        bt_cerrar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cerrar_cActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_clientesLayout = new javax.swing.GroupLayout(jp_clientes);
        jp_clientes.setLayout(jp_clientesLayout);
        jp_clientesLayout.setHorizontalGroup(
            jp_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_clientesLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(bt_actualizar)
                .addGap(45, 45, 45)
                .addComponent(bt_cerrar_c)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_clientesLayout.setVerticalGroup(
            jp_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_actualizar)
                    .addComponent(bt_cerrar_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTES", jp_clientes);

        jEditorPane1.setEditable(false);
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jp_informacionLayout = new javax.swing.GroupLayout(jp_informacion);
        jp_informacion.setLayout(jp_informacionLayout);
        jp_informacionLayout.setHorizontalGroup(
            jp_informacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
        jp_informacionLayout.setVerticalGroup(
            jp_informacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("INFORMACIÓN", jp_informacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(0, 0, 668, 497);
    }// </editor-fold>//GEN-END:initComponents

    private void cob_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cob_mesActionPerformed
        // TODO add your handling code here:
        String tresuno[] = {"Enero","Marzo","Mayo","Julio","Agosto","Octubre","Diciembre"};
        String trescero[] = {"Abril","Junio","Septiembre","Noviembre"};
        String mes = cob_mes.getSelectedItem().toString();
        boolean salida = false;
        for(int i=0; i<tresuno.length && salida==false; i++){
            if(mes.equalsIgnoreCase(tresuno[i])){
                sp_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
                salida=true;
            }
        }
        if(salida==false){
            for(int i=0; i<trescero.length && salida==false; i++){
                if(mes.equalsIgnoreCase(trescero[i])){
                    sp_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));
                    salida=true;
                }
            }
        }
        if(salida==false){
            sp_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 28, 1));
            salida=true;
        }
    }//GEN-LAST:event_cob_mesActionPerformed

    private void sl_anioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sl_anioStateChanged
        // TODO add your handling code here:
        jl_ver.setText(String.valueOf(sl_anio.getValue()));
    }//GEN-LAST:event_sl_anioStateChanged

    private void bt_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aceptarActionPerformed
        // TODO add your handling code here:
        if(validarDatos()){
            Object valor;
            String nombre = tf_nombre.getText();
            String apellido = tf_apellido.getText();
            String dni = tf_dni.getText();
            String telefono = tf_tlf.getText();
            String nacionalidad = cob_nacionalidad.getItemAt(cob_nacionalidad.getSelectedIndex());
            String sexo="";
            switch(bg_sexo.getSelection().getMnemonic()-48){
                case 0:
                sexo = "Hombre";
                break;
                case 1:
                sexo = "Mujer";
                break;
            }
            int dia = Integer.parseInt(sp_dia.getValue().toString());
            String mes = cob_mes.getSelectedItem().toString();
            int anio = sl_anio.getValue();
            valor = JOptionPane.showConfirmDialog(rootPane, "Nombre: "+nombre+
                "\nApellido: "+apellido+
                "\nDni: "+dni+
                "\nTeléfono: "+telefono+
                "\nNacionalidad: "+nacionalidad+
                "\nSexo: "+sexo+
                "\nFecha de Nacimiento: "+dia+" de "+mes+" del "+anio, "¿Datos Correctos?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(valor.toString().equalsIgnoreCase("0")){
                nuevoCliente(dni, nombre, apellido, telefono, nacionalidad, sexo, dia, mes, anio);
                tf_nombre.setText("");
                tf_apellido.setText("");
                tf_dni.setText("");
                tf_tlf.setText("");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Cambia los datos que necesites", "Operacion Cancelada", JOptionPane.INFORMATION_MESSAGE);
            }
        }/*else{
            JOptionPane.showMessageDialog(rootPane, "Datos no Válidos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_bt_aceptarActionPerformed
    
    private boolean validarDatos(){
        boolean valido = false;
        String nombre = tf_nombre.getText();
        Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,19}");
        Matcher m = p.matcher(nombre);
        if(m.find()){
            String apellido = tf_apellido.getText();
            p = Pattern.compile("[A-Z]{1}[a-z]{2,29}");
            m = p.matcher(apellido);
            if(m.find()){
                String dni = tf_dni.getText();
                p = Pattern.compile("[0-9]{8}[a-zA-Z]{1}");
                m = p.matcher(dni);
                if(m.find()){
                    String telefono = tf_tlf.getText();
                    p = Pattern.compile("[0-9]{9}");
                    m = p.matcher(telefono);
                    if(m.find()){
                        String nacionalidad = cob_nacionalidad.getItemAt(cob_nacionalidad.getSelectedIndex());
                        p = Pattern.compile("[a-zA-Zñ]{5,30}");
                        m = p.matcher(nacionalidad);
                        if(m.find()){
                            valido=true;
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "El país introducido no es válido. Elige uno de la lista", "País Erroneo", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "El teléfono introducido no es válido, solamente puedes introducir números", "Teléfono Erroneo", JOptionPane.ERROR_MESSAGE);
                        tf_tlf.setText("");
                        tf_tlf.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "El DNI introducido no es válido. Introduce un DNI correcto", "DNI Erroneo", JOptionPane.ERROR_MESSAGE);
                    tf_dni.setText("");
                    tf_dni.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "El apellido introducido no es válido, solamente puedes introducir letras", "Apellido Erroneo", JOptionPane.ERROR_MESSAGE);
                tf_apellido.setText("");
                tf_apellido.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "El nombre introducido no es válido, solamente puedes introducir letras", "Nombre Erroneo", JOptionPane.ERROR_MESSAGE);
            tf_nombre.setText("");
            tf_nombre.requestFocus();
        }
        return valido;
    }
    
    private void nuevoCliente(String dni, String nombre, String apellido, String telefono, String nacionalidad, String sexo, int dia, String mes, int anio){
        try {
            int r = sentencia.executeUpdate("insert into clientes values('"+dni+"','"+nombre+"','"+apellido+"','"+telefono+"','"+nacionalidad+"','"+sexo+"',"+dia+",'"+mes+"',"+anio+")");
            escribirInfo(dni, nombre, apellido, telefono, nacionalidad, sexo, dia, mes, anio);
            listaClientes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al insertar al cliente");
        }
    }
    
    private void escribirInfo(String dni, String nombre, String apellido, String telefono, String nacionalidad, String sexo, int dia, String mes, int anio){
        int resp;
        resp= jFileChooser1.showOpenDialog(this);
        ArrayList<String> lista = new ArrayList<String>();
        if (resp==JFileChooser.APPROVE_OPTION) {
            cliente = this.jFileChooser1.getSelectedFile();
            lista.add(dni);
            lista.add(nombre);
            lista.add(apellido);
            lista.add(telefono);
            lista.add(nacionalidad);
            lista.add(sexo);
            lista.add(String.valueOf(dia));
            lista.add(mes);
            lista.add(String.valueOf(anio));
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(cliente));
                for(int i=0; i<lista.size(); i++){
                    bw.write(lista.get(i));
                    if(i!=lista.size()){
                        bw.write(System.lineSeparator());
                    }
                }
                bw.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "No se creará el fichero con los datos del cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void bt_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bt_cerrarActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        // TODO add your handling code here:
        String dni = tf_dni_b.getText();
        if(!dni.equals("")){
            ArrayList<String> lista = datos2(dni);
            if(!lista.isEmpty()){
                DefaultTableModel model = new DefaultTableModel();
                for(int i=0; i<header.length; i++){
                    model.addColumn(header[i]);
                }
                for(int i=0; i<lista.size(); i++){
                    model.addRow(lista.get(i).split("/"));
                }
                jTable2.setModel(model);
            }else{
                JOptionPane.showMessageDialog(rootPane, "No hay ningún cliente con ese dni", "ERROr", JOptionPane.ERROR_MESSAGE);
                tf_dni_b.setText("");
                tf_dni_b.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Hace falta introducir un dni", "ERROR", JOptionPane.ERROR_MESSAGE);
            tf_dni_b.requestFocus();
        }
    }//GEN-LAST:event_bt_buscarActionPerformed

    private ArrayList<String> datos2(String dni){
        ArrayList<String> lista = new ArrayList<String>();
        String aux = "";
        try {
            ResultSet r = sentencia.executeQuery("SELECT dni, nombre, apellido, telefono FROM CLIENTES WHERE dni='"+dni+"'");
            for(int i=0; r.next(); i++){
                aux = r.getString("dni")+"/"+r.getString("nombre")+"/"+r.getString("apellido")+"/"+r.getString("telefono");
                lista.add(aux);
            }
        } catch (SQLException ex) {
            
        }
        return lista;
    }
    
     private void vaciarTabla(){
        String s = " / / / ";
        DefaultTableModel model = new DefaultTableModel();
        for(int i=0; i<header.length; i++){
            model.addColumn(header[i]);
        }
        model.addRow(s.split("/"));
        jTable2.setModel(model);
    }
    
    private void bt_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_borrarActionPerformed
        if(jTable2.getValueAt(0, 0)!=null){
            Object valor = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quiere borrar a "
                +(jTable2.getValueAt(0, 1)).toString()+" "
                +(jTable2.getValueAt(0, 2)).toString()+"?", "¿Datos Correctos?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(valor.toString().equalsIgnoreCase("0")){
                try {
                    int r = sentencia.executeUpdate("DELETE FROM Clientes WHERE dni='"+tf_dni_b.getText()+"'");
                    JOptionPane.showMessageDialog(rootPane, "Cliente eliminado correctamente", "CLIENTE ELIMINADO", JOptionPane.INFORMATION_MESSAGE);
                    tf_dni_b.setText("");
                    vaciarTabla();
                    listaClientes();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "No se ha podido eliminar al cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "No se borrará al cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_borrarActionPerformed

    private void bt_cerrar_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cerrar_bActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bt_cerrar_bActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        // TODO add your handling code here:
        listaClientes();
    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void bt_cerrar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cerrar_cActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bt_cerrar_cActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_sexo;
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_actualizar;
    private javax.swing.JButton bt_borrar;
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_cerrar;
    private javax.swing.JButton bt_cerrar_b;
    private javax.swing.JButton bt_cerrar_c;
    private javax.swing.JComboBox<String> cob_mes;
    private javax.swing.JComboBox<String> cob_nacionalidad;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jl_anio;
    private javax.swing.JLabel jl_apellido;
    private javax.swing.JLabel jl_dia;
    private javax.swing.JLabel jl_dni;
    private javax.swing.JLabel jl_dni_b;
    private javax.swing.JLabel jl_fecha;
    private javax.swing.JLabel jl_mes;
    private javax.swing.JLabel jl_nacionalidad;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_sexo;
    private javax.swing.JLabel jl_tlf;
    private javax.swing.JLabel jl_ver;
    private javax.swing.JPanel jp_anadir;
    private javax.swing.JPanel jp_borrar;
    private javax.swing.JPanel jp_clientes;
    private javax.swing.JPanel jp_infoCliente;
    private javax.swing.JPanel jp_informacion;
    private javax.swing.JRadioButton rb_hombre;
    private javax.swing.JRadioButton rb_mujer;
    private javax.swing.JSlider sl_anio;
    private javax.swing.JSpinner sp_dia;
    private javax.swing.JTextField tf_apellido;
    private javax.swing.JTextField tf_dni;
    private javax.swing.JTextField tf_dni_b;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_tlf;
    // End of variables declaration//GEN-END:variables
}
