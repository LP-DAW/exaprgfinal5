package datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Curso;
import modelo.Examen;

public class ModeloMysql implements IModelo {

   private final String BD = "exaprgfinal5";
   private final String USER = "alumno";
   private final String PASS = "alumno";
   private Connection con = null;
   private Statement st = null;
   private ResultSet rs = null;

   public void desconectar() {

      try {
         System.out.println("BDR Mysql Connexión cerrada");
         con.close();
      } catch (SQLException ex) {

      }
   }

   public void conectar() {

      try {
         String driver = "com.mysql.jdbc.Driver";
         Class.forName(driver).newInstance();
         String jdbcUrl = "jdbc:mysql://localhost:3306/" + BD;
         con = (Connection) DriverManager.getConnection(jdbcUrl, USER, PASS);
         System.out.println("Conexion establecida con la Base de datos...");

      } catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   @Override
   public void createExamen(Examen examen) {
      /* Rellenar: 1 puntos
       Graba el examen en la tabla
       */

       //TODO


   }

   @Override
   public void createCurso(Curso curso) {
       //TODO


   }

   @Override
   public Examen readExamen(String id) {
      /* Rellenar: 1 puntos
       Leer el examen de la tabla
       */

       //TODO


       return null;
   }

   @Override
   public Curso readCurso(String idcurso) {

       //TODO


       return null;
   }

   @Override
   public void inicializa() {

      /* Rellenar: 1 puntos
       Borra las tablas
       */

       //TODO

   }

}
