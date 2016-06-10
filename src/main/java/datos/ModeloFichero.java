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
public class ModeloFichero implements IModelo {

   private int id = 0;
   private static String fexamen = "examen.cvs";
   private static String fcurso = "curso.cvs";

   @Override
   public void createCurso(Curso curso) {
      /* Rellenar.  0.5 puntos
       Graba el objeto curso en el fichero fcurso
       */

   }

   @Override
   public void createExamen(Examen examen) {
      /* Rellenar.  0.5 puntos
       Graba el objeto examen en el fichero fexamen
       */

       //TODO



   }

   @Override
   public Examen readExamen(String id) {

      /* Rellenar.  0.5 puntos
       lee el objeto examen en el fichero fexamen
       */

       //TODO


       return null;
   }

   @Override
   public Curso readCurso(String idcurso) {

      /* Rellenar.  0.5 puntos
       Lee  el objeto curso del fichero fcurso
       */

       //TODO


       return null;
   }

   private Examen extraeExamen(String linea) {
      /* Rellenar.  0.5 puntos
       Extrae el objeto examen de la linea separada por comas
       */

       //TODO



       return null;
   }

   private Curso extraeCurso(String linea) {
      /* Rellenar.  0.5 puntos
       Extrae el objeto curso de la linea separada por comas
       */

       //TODO


       return null;
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
