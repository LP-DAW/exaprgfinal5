package modelo;
// Generated 13-may-2015 9:59:48 by Hibernate Tools 4.3.1

import java.util.Set;

/**
 * Curso generated by hbm2java
 */
public class Curso implements java.io.Serializable {

   private String id;
   private String nombre;

   public Curso() {
      id = "";
      nombre = "";
   }

   public Curso(String id, String descripcion) {
      this.id = id;
      this.nombre = descripcion;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String descripcion) {
      this.nombre = nombre;
   }

}
