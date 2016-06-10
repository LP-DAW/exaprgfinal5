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

public class ModeloMysql implements Modelo {

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
      int resultado;
      String sql;

      try {
         conectar();
         st = con.createStatement();

         String id = examen.getId();
         String nombre = examen.getNombre();
         String idcurso = examen.getCurso().getId();

         sql = "insert into examen(id,nombre,idcurso) "
                 + "values('" + id + "','" + nombre + "','" + idcurso + "')";
         System.out.println(sql);
         resultado = st.executeUpdate(sql);

         desconectar();
      } catch (SQLException ex) {
         System.out.println("Error");
      }
   }

   @Override
   public void createCurso(Curso curso) {
      int resultado;
      String sql;

      try {
         conectar();
         st = con.createStatement();

         String id = curso.getId();
         String nombre = curso.getNombre();

         sql = "insert into curso(id,nombre) "
                 + "values('" + id + "','" + nombre + "')";
         System.out.println(sql);
         resultado = st.executeUpdate(sql);

         desconectar();
      } catch (SQLException ex) {
         System.out.println("Error");
      }
   }

   @Override
   public Examen readExamen(String id) {
      /* Rellenar: 1 puntos
       Leer el examen de la tabla
       */

      Examen examen = null;
      Curso curso = null;
      Boolean encontrado = false;

      try {

         conectar();
         st = con.createStatement();

         String sql = "select id,nombre,idcurso from examen where id='" + id + "'";
         System.out.println(sql);

         rs = st.executeQuery(sql);

         if (rs.next()) {

            String nombre = rs.getString("nombre");
            String idcurso = rs.getString("idcurso");

            curso = new Curso(idcurso, "");

            examen = new Examen(id, nombre, curso);
            desconectar();
         }

      } catch (SQLException se) {
         //Errores de JDBC
         se.printStackTrace();
      } catch (Exception e) {
         //Errores de Class.forNameCliente
         e.printStackTrace();
      }
      return examen;
   }

   @Override
   public Curso readCurso(String idcurso) {
      Curso curso = null;
      try {

         conectar();
         st = con.createStatement();

         //Ejecutamos la SELECT sobre la tabla alumnos
         String sql = "select id,nombre from curso where id='" + idcurso + "'";
         System.out.println(sql);

         rs = st.executeQuery(sql);

         if (rs.next()) {

            String nombre;
            nombre = rs.getString("nombre");
            curso = new Curso(idcurso, nombre);

            desconectar();
         }
      } catch (SQLException ex) {
         Logger.getLogger(ModeloMysql.class.getName()).log(Level.SEVERE, null, ex);
      }

      return curso;
   }

   @Override
   public void inicializa() {

      /* Rellenar: 1 puntos
       Borra las tablas
       */
      try {

         conectar();
         st = con.createStatement();

         String sql = "delete from examen;";
         System.out.println(sql);
         st.executeUpdate(sql);

         sql = "delete from curso;";
         System.out.println(sql);
         st.executeUpdate(sql);

         desconectar();

      } catch (SQLException ex) {
         Logger.getLogger(ModeloMysql.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

}
