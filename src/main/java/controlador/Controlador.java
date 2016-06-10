package controlador;

import datos.Modelo;
import datos.ModeloFichero;
import datos.ModeloMysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.Curso;
import modelo.Examen;
import vista.VistaExamen;

class Controlador implements ActionListener {

   Modelo modelo;
   VistaExamen vista;
   Examen examen;
   Curso curso;

   final static String GRABAR = "GRABAR";
   final static String SALIR = "SALIR";

   Controlador(Modelo modelo_, VistaExamen vista_) throws IOException {

      modelo = modelo_;
      vista = vista_;

      vista = new VistaExamen();
      vista.setVisible(true);

      fuentededatos();

      modelo.inicializa();
      inicializaModelo();

      examen = ExamenInicial();
      mostrarExamen(examen);
      configuraBotones();

   }

   private Examen ExamenInicial() throws IOException {

      examen = modelo.readExamen("e1");
      String idcurso = examen.getCurso().getId();
      curso = modelo.readCurso(idcurso);
      examen.setCurso(curso);

      return examen;
   }

   private void configuraBotones() {
      /* Rellenar. 0.5puntos
       Inicializar los botones GRABAR de  y SALIR donde se define
       la etiqueta asociada al boton y quien es la clase que escucha
       los eventos.
       */

      vista.getjb1().setActionCommand(GRABAR);
      vista.getjb2().setActionCommand(SALIR);

      vista.getjb1().addActionListener(this);
      vista.getjb2().addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      /* Rellenar. 0.5puntos
       Si se pulsa SALIR hacer salir(), si se pulsa GRABR
       hacer grabar()
       */

      String comando = e.getActionCommand();

      switch (comando) {
         case SALIR:
            salir();
            break;
         case GRABAR:
            grabar();
            break;
      }

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

      vista.getjtf1().setText(examen.getId());
      vista.getjtf2().setText(examen.getNombre());
      vista.getjtf3().setText(examen.getCurso().getId());
      vista.getjtf4().setText(examen.getCurso().getNombre());
   }

   private Examen getExamen() {

      Examen examen = new Examen();
      Curso curso = new Curso();

      String id = vista.getjtf1().getText();
      String nombre = vista.getjtf2().getText();
      String idcurso = vista.getjtf3().getText();

      curso = modelo.readCurso(idcurso);
      examen = new Examen(id, nombre, curso);
      return examen;
   }

   private void mostrarCurso(Examen examen) {
      vista.getjtf4().setText(examen.getCurso().getNombre());
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
      Curso curso1 = new Curso("c1", "Curso 1");
      Examen examen1 = new Examen("e1", "Examen 1", curso1);
      modelo.createCurso(curso1);
      modelo.createExamen(examen1);

      Curso curso2 = new Curso("c2", "Curso 2");
      Examen examen2 = new Examen("e2", "Examen 2", curso2);
      modelo.createCurso(curso2);
      modelo.createExamen(examen2);

   }

   private void fuentededatos() {
      /* Rellenar. 0.5puntos
       Definir la fuente de datos sea fichero o mysql
       utilizando el modelo
       */

      modelo = new ModeloMysql();
   }

   private void destinodedatos() {
      /* Rellenar. 0.5puntos
       Definir el destino de los datos del formulario VistaExamen
       sea fichero o mysql utilizando el modelo
       */

      modelo = new ModeloFichero();
   }

}
