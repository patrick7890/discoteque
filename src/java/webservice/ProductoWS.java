/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.DAOProducto;
import dto.Producto;
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
    public String IngresarProducto(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock, @WebParam(name = "tipo") int tipo, @WebParam(name = "subtipo") int subtipo) {
        DAOProducto dao=new DAOProducto();
        Producto p =new Producto();
        return null;
    }
}
