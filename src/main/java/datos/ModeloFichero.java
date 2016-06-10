package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import modelo.Curso;
import modelo.Examen;

/**
 *
 * @author paco
 */
public class ModeloFichero implements Modelo {

   private int id = 0;
   private static String fexamen = "examen.cvs";
   private static String fcurso = "curso.cvs";

   @Override
   public void createCurso(Curso curso) {
      /* Rellenar.  0.5 puntos
       Graba el objeto curso en el fichero fcurso
       */

      try {
         File fs = new File(fcurso);
         java.io.FileWriter fw = new FileWriter(fs, true);
         fw.write(curso.getId());
         fw.write(";");
         fw.write(curso.getNombre());
         fw.write("\r\n");
         fw.close();
      } catch (IOException ex) {
      }
   }

   @Override
   public void createExamen(Examen examen) {
      /* Rellenar.  0.5 puntos
       Graba el objeto examen en el fichero fexamen
       */

      try {
         File fs = new File(fexamen);
         java.io.FileWriter fw = new FileWriter(fs, true);

         fw.write(examen.getId());
         fw.write(";");
         fw.write(examen.getNombre());
         fw.write(";");
         fw.write(examen.getCurso().getId() + "");
         fw.write("\r\n");
         fw.close();
      } catch (IOException ex) {
      }

   }

   @Override
   public Examen readExamen(String id) {

      /* Rellenar.  0.5 puntos
       Graba el objeto examen en el fichero fexamen
       */
      Examen examen = null;
      Boolean encontrado = false;

      try {
         FileReader fr = new FileReader(fexamen);
         BufferedReader br = new BufferedReader(fr);
         String linea;

         linea = br.readLine();
         while (linea != null) {
            examen = extraeExamen(linea);
            if (id.equals(examen.getId())) {
               encontrado = true;
               break;
            }

            linea = br.readLine();
         }
         fr.close();
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      }

      if (!encontrado) {
         examen = null;
      }
      return examen;
   }

   @Override
   public Curso readCurso(String idcurso) {

      /* Rellenar.  0.5 puntos
       Lee  el objeto curso del fichero fcurso
       */
      Curso curso = null;
      Boolean encontrado = false;

      try {
         FileReader fr = new FileReader(fcurso);
         BufferedReader br = new BufferedReader(fr);
         String linea;

         linea = br.readLine();
         while (linea != null) {
            curso = extraeCurso(linea);
            if (idcurso.equals(curso.getId())) {
               encontrado = true;
               break;
            }

            linea = br.readLine();
         }
         fr.close();
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      }

      if (!encontrado) {
         curso = null;
      }
      return curso;
   }

   private Examen extraeExamen(String linea) {
      /* Rellenar.  0.5 puntos
       Extrae el objeto examen de la linea separada por comas
       */

      Examen examen;
      Curso curso = null;
      StringTokenizer str = new StringTokenizer(linea, ";");

      String id = str.nextToken();
      String nombre = str.nextToken();
      String idcurso = str.nextToken();

      curso = new Curso(idcurso, "");
      examen = new Examen(id, nombre, curso);
      return examen;
   }

   private Curso extraeCurso(String linea) {
      /* Rellenar.  0.5 puntos
       Extrae el objeto curso de la linea separada por comas
       */
      Curso curso = null;
      StringTokenizer str = new StringTokenizer(linea, ";");

      String id = str.nextToken();
      String nombre = str.nextToken();

      curso = new Curso(id, nombre);
      return curso;
   }

   @Override
   public void inicializa() {
      /* Rellenar.  0.5 puntos
       Borra los ficheros 
       */

      File f = new File(fcurso);
      f.delete();
      f = new File(fexamen);
      f.delete();
   }

}
