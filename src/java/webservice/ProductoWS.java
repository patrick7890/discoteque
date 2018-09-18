/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.DAOProducto;
import dto.Producto;
import dto.Tipoproducto;
import java.util.List;
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
    public Boolean IngresarProducto(@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock, @WebParam(name = "tipo") int tipo) {
        DAOProducto dao = new DAOProducto();
        Tipoproducto ti = dao.buscarTipo(tipo);
        byte esado = 1;
        Producto p = new Producto(ti, nombre, precio, stock, esado);
        return dao.agregar(p);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarProducto")
    public Producto buscarProducto(@WebParam(name = "id") int id) {
        DAOProducto dao = new DAOProducto();
        Producto p = dao.buscar(id);
        return p;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public Boolean eliminar(@WebParam(name = "id") int id) {
        DAOProducto dao = new DAOProducto();
        Producto p = dao.buscar(id);
        byte estado = 0;
        p.setEnVenta(estado);
        return dao.actualizar(p);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualizar")
    public String Actualizar() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listar")
    public String listar() {
        DAOProducto dao = new DAOProducto();
        String lista = "";
        for (Producto object : dao.listarTodo()) {
            lista += object.getNombreProducto();
        }

        return lista;
    }

}
