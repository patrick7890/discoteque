package dto;
// Generated 15-09-2018 16:46:42 by Hibernate Tools 4.3.1



/**
 * ComandaProducto generated by hbm2java
 */
public class ComandaProducto  implements java.io.Serializable {


     private ComandaProductoId id;
     private Comanda comanda;
     private Producto producto;

    public ComandaProducto() {
    }

    public ComandaProducto(ComandaProductoId id, Comanda comanda, Producto producto) {
       this.id = id;
       this.comanda = comanda;
       this.producto = producto;
    }
   
    public ComandaProductoId getId() {
        return this.id;
    }
    
    public void setId(ComandaProductoId id) {
        this.id = id;
    }
    public Comanda getComanda() {
        return this.comanda;
    }
    
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }




}


