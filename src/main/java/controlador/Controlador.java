package controlador;

import datos.IModelo;
import datos.ModeloFichero;
import datos.ModeloMysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.Curso;
import modelo.Examen;
import vista.VistaExamen;

class Controlador implements ActionListener {

   IModelo modelo;
   VistaExamen vista;
   Examen examen;
   Curso curso;

   final static String GRABAR = "GRABAR";
   final static String SALIR = "SALIR";

   Controlador(IModelo m, VistaExamen v) {

      modelo = m;
      vista = v;

      //TODO


   }

   private void configuraBotones() {
      /* Rellenar. 0.5puntos
       Inicializar los botones GRABAR de  y SALIR donde se define
       la etiqueta asociada al boton y quien es la clase que escucha
       los eventos.
       */

       //TODO

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      /* Rellenar. 0.5puntos
       Si se pulsa SALIR hacer salir(), si se pulsa GRABR
       hacer grabar()
       */

       //TODO


   }

   private void salir() {
      System.exit(0);
      vista.dispose();
   }

   private void grabar() {

      destinodedatos();
      modelo.inicializa();
      inicializaModelo();
      examen = getExamen();
      modelo.createExamen(examen);
      mostrarCurso(examen);
   }

   private void mostrarExamen(Examen examen) {
      /* Rellenar. 0.5puntos
       Muestra en  el formulario VistaExamen el examen
       */

      //TODO

   }

   private Examen getExamen() {

       //TODO
       return null;
   }

   private void mostrarCurso(Examen examen)
   {
       //TODO

   }

   private void inicializaModelo() {

       /* Rellenar. 0.5puntos
       Crear los objetos examen y curso que se indican y grabarlos en
       la fuente de datos.

       En fichero  examen.cvs sería:
       e1;Examen 1;c1
       e2;Examen 2;c2

       En fichero  curso.cvs sería:
       c1;Curso 1
       c2;Curso 2

       */
       //TODO

   }

   private void fuentededatos() {
      /* Rellenar. 0.5puntos
       Definir la fuente de datos sea fichero o mysql
       utilizando el modelo
       */

       //TODO
   }

   private void destinodedatos() {
      /* Rellenar. 0.5puntos
       Definir el destino de los datos del formulario VistaExamen
       sea fichero o mysql utilizando el modelo
       */

      //TODO
   }

}
