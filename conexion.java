/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gabi;

//import com.mysql.jdbc;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
 
class conexion {
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
       pst=con.prepareStatement("select * from ingredientes where nombre=? order by nombre asc");
       pst.setString(1, nombre);
       rs=pst.executeQuery();
       
      }  catch (SQLException e){
          
      }
  return rs;
  }

    ResultSet SelleccionarCategoria(String medicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
