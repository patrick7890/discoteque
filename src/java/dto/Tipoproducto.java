package dto;
// Generated 15-09-2018 16:46:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipoproducto generated by hbm2java
 */
public class Tipoproducto  implements java.io.Serializable {


     private int idtipoProducto;
     private Subtipoproducto subtipoproducto;
     private String descripcionTipoP;
     private Set<Producto> productos = new HashSet<Producto>(0);

    public Tipoproducto() {
    }

	
    public Tipoproducto(int idtipoProducto, Subtipoproducto subtipoproducto, String descripcionTipoP) {
        this.idtipoProducto = idtipoProducto;
        this.subtipoproducto = subtipoproducto;
        this.descripcionTipoP = descripcionTipoP;
    }
    public Tipoproducto(int idtipoProducto, Subtipoproducto subtipoproducto, String descripcionTipoP, Set<Producto> productos) {
       this.idtipoProducto = idtipoProducto;
       this.subtipoproducto = subtipoproducto;
       this.descripcionTipoP = descripcionTipoP;
       this.productos = productos;
    }
   
    public int getIdtipoProducto() {
        return this.idtipoProducto;
    }
    
    public void setIdtipoProducto(int idtipoProducto) {
        this.idtipoProducto = idtipoProducto;
    }
    public Subtipoproducto getSubtipoproducto() {
        return this.subtipoproducto;
    }
    
    public void setSubtipoproducto(Subtipoproducto subtipoproducto) {
        this.subtipoproducto = subtipoproducto;
    }
    public String getDescripcionTipoP() {
        return this.descripcionTipoP;
    }
    
    public void setDescripcionTipoP(String descripcionTipoP) {
        this.descripcionTipoP = descripcionTipoP;
    }
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }




}


