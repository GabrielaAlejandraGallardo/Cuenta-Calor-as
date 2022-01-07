/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gabi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class conex {
   

private Connection con=null;


  public Connection conexion(){
      try{
         Class.forName("com.mysql.jdbc.Driver");
 con =  DriverManager.getConnection ("jdbc:mysql://localhost/saludabletentacion", "root", ""); 
      }  catch (ClassNotFoundException | SQLException e){
          
      }
  return con;
  }
  public void cerrarConexion(){
      try{
          con.close();
          
      }catch(SQLException e){
          
      }
  }
  public ResultSet SelleccionarIngrediente(String nombre){
       Connection con;
       PreparedStatement pst;
       ResultSet rs=null;
       
           try{
             con =conexion();
       pst=con.prepareStatement("select * from ingredientes where nombre=? ORDER BY nombre");
       pst.setString(1, nombre);
       rs=pst.executeQuery();
       
       
       
      }  catch (SQLException e){
          
      }
  return rs;
  } 
  public ResultSet SelleccionarCategoria(int medicion){
       Connection con;
       PreparedStatement pst;
       ResultSet rs=null;
       
           try{
             con =conexion();
       pst=con.prepareStatement("select * from Categoria where medicion=?");
       pst.setInt(1,medicion);
       rs=pst.executeQuery();
       
       
       
      }  catch (SQLException e){
          
      }
  return rs;
  } 
}
/* private void CalculoTotal() throws SQLException{
         String medicion = Ingredientes.getSelectedItem().toString();
        
        Object datos[] = {medicion};
        conexion cn = new conexion();
        ResultSet rs = cn.SelleccionarCategoria(medicion);
        ResultSetMetaData rsm=rs.getMetaData();
        //DefaultTableModel dfmbuscar =(DefaultTableModel)tabla.getModel();
        this.tabla.setModel(modelo);
        //int suma = 0;
       // modelo.setColumnIdentifiers(new Object[]{"Nombre", "Cantidad", "Calorias"});
        int s=0,tot;
        for(int i=0;i<tabla.getRowCount();i++){
            s=s+Integer.parseInt(modelo.getValueAt(i,3).toString());
        }
      //  s=redondear(s);https://youtu.be/x9ifeZHwCWc
        total.setText(String.valueOf(s));
        tot=s*100;
        total.setText(String.valueOf(total));
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel1 = new javax.swing.JLabel();
        Ingredientes = new javax.swing.JComboBox<>();
        aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Calorias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setText("Ingredientes");

        Ingredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredientesActionPerformed(evt);
            }
        });

        aceptar.setText("Agregar Ingrediente");
        aceptar.setActionCommand("Agregar Ingrediente");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        tabla.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingredientes", "Cantidad", "Calorias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Vivaldi", 2, 24)); // NOI18N
        jLabel3.setText("Total de calorias que aporta la receta: ");

        total.setForeground(new java.awt.Color(0, 102, 51));
        total.setText("00");

        eliminar.setText("Eliminar Ingrediente");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Calorias");

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Contador de Calorias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addComponent(total))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(aceptar)
                                .addGap(39, 39, 39)
                                .addComponent(eliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Calorias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ingredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ingredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Calorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(total))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    @SuppressWarnings("empty-statement")
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {                                        
 
        try {Object[] rowData=new Object[3];
        String nombre = Ingredientes.getSelectedItem().toString();
        
      //  Object datos[] = {nombre};
        conexion cn = new conexion();
        ResultSet rs = cn.SelleccionarIngrediente(nombre);
        ResultSetMetaData rsm=rs.getMetaData();
        DefaultTableModel modelo =(DefaultTableModel)tabla.getModel();
     // this.tabla.setModel(modelo);
      //  int suma = 0;
//        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Cantidad", "Calorias"});
       // Object[] fila = new Object[3];
       
            while (rs.next()) {
                
             for (int i = 0; i < rowData.length; i++) {
rowData[0] = Ingredientes.getSelectedItem().toString();
rowData[1] = cantidad.getText();// dfmbuscar.addRow(cantidad);
 rowData[2] = Calorias.getText();//add(Calorias);
             //_ rowData[0] = Ingredientes.getSelectedItem().toString();//add(Ingredientes);
             //_ rowData[1] = cantidad.getText();// dfmbuscar.addRow(cantidad);
            //_  rowData[2] = Calorias.getText();//add(Calorias);
             //_  int sumaC=Integer.parseInt(rowData[2])*Integer.parseInt(rowData[3]);
                int sumaC=Integer.parseInt(rowData[2])*Integer.parseInt(rowData[3]);
                        
              modelo.addRow(rowData);
               CalculoTotal();
            }}
               // this.total.setText(String.valueOf(rs.getInt("calorias")));// total=cantidad.getText()*Calorias.getText();                    // suma=cantidad.getText()* medicion;*/
                    
 //no deseleccionar fila[0]=rsm.getColumnLabel(i + 1);//http://www.chuidiang.org/java/mysql/resultset_jtable.php
      //          dfmbuscar.addRow(fila);
                    
        //        }Ingredientes.setModel((ComboBoxModel<String>) dfmbuscar);
               // Ingredientes.addRow(rs.next());
               
  /*  }                                       
     catch (SQLException ex) {
            Logger.getLogger(ContadorCalorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
        
    private void IngredientesActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            String nombre = this.Ingredientes.getSelectedItem().toString();
            conexion cn = new conexion();
            ResultSet rs = cn.SelleccionarIngrediente(nombre);
            //DefaultTableModel modelo = new DefaultTableModel();
            this.tabla.setModel(modelo);
           rs.next();
            this.Calorias.setText(String.valueOf(rs.getInt("calorias")));
            modelo.setColumnIdentifiers(new Object[]{"nombre", "Cantidad", "calorias",});
            try {
                while (rs.next()) {
                   modelo.addRow(new Object[]{rs.getString("nombre"), rs.getInt("calorias"), rs.getInt("idCategoria")});

                }
            } catch (SQLException ex) {
                Logger.getLogger(ContadorDeCalorias.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            /*String driver = "com.mysql.jdbc.Driver";
            try {
            if (this.contador < 0) {
            Class.forName(driver).newInstance();
            
            Connection con1 = null;
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/saludabletentacion", "root", ""); //
            
            // Connection con1=DriverManager.getConnection("com.mysql.jdbc.Driver");
            Statement st1 = con1.createStatement();
            ResultSet rs1 = st1.executeQuery("select * from ingredientes where nombre = '" + this.Ingredientes.getSelectedItem() + "' ");
            rs1.next();
            //           modelo.setColumnIdentifiers(new Object[]{"nombre", "calorias"});
            // this..setText(String.valueOf(rs1.getInt("idIngrediente")));
            JList lista = new JList();
            DefaultListModel modelo = new DefaultListModel();
            String[] elementos = {"nombre", "calorias"};
            javax.swing.JList list = new javax.swing.JList(elementos);
            
            for (int i = 1; i <= 10; i++) {
            modelo.addElement(i);/*https://serprogramador.es/usando-un-jlist-para-almacenar-objetos-java-swing/
            //javax.swing.JList list = new javax.swing.JList(lista);
            }
            lista.setModel(modelo);
            //if (evt.getSelectedItem() == java.awt.event.ItemEvent.SELECTED) {
            //  this.jTextField1.setVisible(true);
            }
            }
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ContadorCalorias.class.getName()).log(Level.SEVERE, null, ex);
            }//https://serprogramador.es/usando-un-jlist-para-almacenar-objetos-java-swing/
            //javax.swing.JList list = new javax.swing.JList(lista);
            
            
            //if (evt.getSelectedItem() == java.awt.event.ItemEvent.SELECTED) {
            //  this.jTextField1.setVisible(true);
            }
            
            
            
            
            //   String nombre=this.Ingredientes.getSelectedItem().toString();
            
            conexion cn=new conexion();
            ResultSet rs=cn.SelleccionarIngrediente(nombre);
            DefaultTableModel dfmbuscar=new DefaultTableModel();
            this.tabla.setModel(dfmbuscar);
            dfmbuscar.setColumnIdentifiers(new Object[]{"nombre", "calorias"});
            Object datos[]={nombre};
            try{
            while(rs.next()){
            dfmbuscar.addRow(new Object[]{rs.getString("nombre"),rs.getInt("calorias")});
            
            }

            
            } catch (SQLException ex) {
            Logger.getLogger(ContadorDeCalorias.class.getName()).log(Level.SEVERE, null, ex);
            } */
     //   } catch (SQLException ex) {
       //     Logger.getLogger(ContadorCalorias.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        /*String driver = "com.mysql.jdbc.Driver";
        try {
            if (this.contador < 0) {
                Class.forName(driver).newInstance();

                Connection con1 = null;
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/saludabletentacion", "root", ""); //

                // Connection con1=DriverManager.getConnection("com.mysql.jdbc.Driver");
                Statement st1 = con1.createStatement();
                ResultSet rs1 = st1.executeQuery("select * from ingredientes where nombre = '" + this.Ingredientes.getSelectedItem() + "' ");
                rs1.next();
      //           modelo.setColumnIdentifiers(new Object[]{"nombre", "calorias"});
               // this..setText(String.valueOf(rs1.getInt("idIngrediente")));
                JList lista = new JList();
                DefaultListModel modelo = new DefaultListModel();
                String[] elementos = {"nombre", "calorias"};
                javax.swing.JList list = new javax.swing.JList(elementos);
                
                for (int i = 1; i <= 10; i++) {
                    modelo.addElement(i);/*https://serprogramador.es/usando-un-jlist-para-almacenar-objetos-java-swing/
                    //javax.swing.JList list = new javax.swing.JList(lista);
                }
                lista.setModel(modelo);
                //if (evt.getSelectedItem() == java.awt.event.ItemEvent.SELECTED) {
          //  this.jTextField1.setVisible(true);
        }
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ContadorCalorias.class.getName()).log(Level.SEVERE, null, ex);
        }//https://serprogramador.es/usando-un-jlist-para-almacenar-objetos-java-swing/
        //javax.swing.JList list = new javax.swing.JList(lista);


        //if (evt.getSelectedItem() == java.awt.event.ItemEvent.SELECTED) {
          //  this.jTextField1.setVisible(true);
        }
    



           //   String nombre=this.Ingredientes.getSelectedItem().toString();
               
        conexion cn=new conexion();
        ResultSet rs=cn.SelleccionarIngrediente(nombre);
        DefaultTableModel dfmbuscar=new DefaultTableModel();
        this.tabla.setModel(dfmbuscar);
        dfmbuscar.setColumnIdentifiers(new Object[]{"nombre", "calorias"});
         Object datos[]={nombre};
        try{
            while(rs.next()){
               dfmbuscar.addRow(new Object[]{rs.getString("nombre"),rs.getInt("calorias")}); 
               
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContadorDeCalorias.class.getName()).log(Level.SEVERE, null, ex);
        } */
   /* }                                            

                                   

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                         
      // TODO add your handling code here:
        // tabla.getSelectedRow());
     eliminar();   
    }
    private void eliminar(){
        int fila;
        if(modelo.getRowCount()<0){
            if(tabla.getSelectedRow()!=-1){
                fila=tabla.getSelectedRow();
                modelo.removeRow(fila);
                try {
                    CalculoTotal();
                } catch (SQLException ex) {
                    Logger.getLogger(ContadorCalorias.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
            }
        
    }                                 
*/