package dto;
// Generated 15-09-2018 18:22:47 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Atencion generated by hbm2java
 */
public class Atencion  implements java.io.Serializable {


     private int idatencion;
     private Usuario usuario;
     private int totalatencion;
     private int mesa;
     private byte faturada;
     private Set<Comanda> comandas = new HashSet<Comanda>(0);

    public Atencion() {
    }

	
    public Atencion(int idatencion, Usuario usuario, int totalatencion, int mesa, byte faturada) {
        this.idatencion = idatencion;
        this.usuario = usuario;
        this.totalatencion = totalatencion;
        this.mesa = mesa;
        this.faturada = faturada;
    }
    public Atencion(int idatencion, Usuario usuario, int totalatencion, int mesa, byte faturada, Set<Comanda> comandas) {
       this.idatencion = idatencion;
       this.usuario = usuario;
       this.totalatencion = totalatencion;
       this.mesa = mesa;
       this.faturada = faturada;
       this.comandas = comandas;
    }
   
    public int getIdatencion() {
        return this.idatencion;
    }
    
    public void setIdatencion(int idatencion) {
        this.idatencion = idatencion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getTotalatencion() {
        return this.totalatencion;
    }
    
    public void setTotalatencion(int totalatencion) {
        this.totalatencion = totalatencion;
    }
    public int getMesa() {
        return this.mesa;
    }
    
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    public byte getFaturada() {
        return this.faturada;
    }
    
    public void setFaturada(byte faturada) {
        this.faturada = faturada;
    }
    public Set<Comanda> getComandas() {
        return this.comandas;
    }
    
    public void setComandas(Set<Comanda> comandas) {
        this.comandas = comandas;
    }




}


