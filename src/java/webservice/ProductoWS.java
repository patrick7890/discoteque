/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.DAOProducto;
import dto.Producto;
import dto.Tipoproducto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IngresarProducto")
    public String IngresarProducto(@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock, @WebParam(name = "tipo") int tipo) {
        DAOProducto dao=new DAOProducto();
        Tipoproducto ti=dao.buscarTipo(tipo);
        byte esado=1;
        Producto p =new Producto(ti, nombre, precio, stock, esado);
        return dao.agregar(p)?"agregado":"no se pudo agregar";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarProducto")
    public String buscarProducto(@WebParam(name = "id") int id) {
        DAOProducto dao=new DAOProducto();
        Producto p=dao.buscar(id);
        return "el producto es "+p.getNombreProducto()+" su estock es de "+p.getStock();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public String eliminar(@WebParam(name = "id") int id) {
        DAOProducto dao=new DAOProducto();
        Producto p=dao.buscar(id);
        byte estado=0;
        p.setEnVenta(estado);
        return dao.actualizar(p)?"actualizado":"no se pudo actualizar";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualizar")
    public String Actualizar() {
        //TODO write your implementation code here:
        return null;
    }
}
