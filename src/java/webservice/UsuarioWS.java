/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.DAOUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "UsuarioWS")
public class UsuarioWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public Boolean Login(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "password") String password) {
        DAOUsuario dao = new DAOUsuario();
        return dao.login(Usuario, password) != null ? true : false;
    }

}
