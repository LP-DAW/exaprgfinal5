package datos;

import modelo.Curso;
import modelo.Examen;

public interface Modelo {

   // Graba en objeto examen en un fichero/mysql
   public void createExamen(Examen examen);

   // Graba en objeto curso en un fichero/mysql
   public void createCurso(Curso curso);

   // Devuelve el objeto Examen que tengo el valor id
   public Examen readExamen(String id);

   // Devuelve el objeto Curso que tengo el valor id
   public Curso readCurso(String id);

   // Borrar el contenido de los ficheros/tablas
   public void inicializa();
}
