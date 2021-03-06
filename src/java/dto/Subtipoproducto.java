package dto;
// Generated 15-09-2018 16:46:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Subtipoproducto generated by hbm2java
 */
public class Subtipoproducto  implements java.io.Serializable {


     private int idsubTipoProducto;
     private String descripcionsubTipo;
     private Set<Tipoproducto> tipoproductos = new HashSet<Tipoproducto>(0);

    public Subtipoproducto() {
    }

	
    public Subtipoproducto(int idsubTipoProducto, String descripcionsubTipo) {
        this.idsubTipoProducto = idsubTipoProducto;
        this.descripcionsubTipo = descripcionsubTipo;
    }
    public Subtipoproducto(int idsubTipoProducto, String descripcionsubTipo, Set<Tipoproducto> tipoproductos) {
       this.idsubTipoProducto = idsubTipoProducto;
       this.descripcionsubTipo = descripcionsubTipo;
       this.tipoproductos = tipoproductos;
    }
   
    public int getIdsubTipoProducto() {
        return this.idsubTipoProducto;
    }
    
    public void setIdsubTipoProducto(int idsubTipoProducto) {
        this.idsubTipoProducto = idsubTipoProducto;
    }
    public String getDescripcionsubTipo() {
        return this.descripcionsubTipo;
    }
    
    public void setDescripcionsubTipo(String descripcionsubTipo) {
        this.descripcionsubTipo = descripcionsubTipo;
    }
    public Set<Tipoproducto> getTipoproductos() {
        return this.tipoproductos;
    }
    
    public void setTipoproductos(Set<Tipoproducto> tipoproductos) {
        this.tipoproductos = tipoproductos;
    }




}


