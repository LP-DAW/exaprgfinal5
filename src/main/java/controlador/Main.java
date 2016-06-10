package controlador;

import datos.Modelo;
import java.io.IOException;
import vista.VistaExamen;

public class Main {

   public static void main(String[] args) throws IOException {
      Modelo modelo = null;
      VistaExamen vista = new VistaExamen();
      Controlador controlador = new Controlador(modelo, vista);
   }

}
