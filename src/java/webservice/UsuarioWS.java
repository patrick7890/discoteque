/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.DAOUsuario;
import dto.Usuario;
import dto.Tipousuario;
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
    @WebMethod(operationName = "idUsuario")
    public int idUsuario(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        DAOUsuario dao = new DAOUsuario();
        Usuario u = dao.login(user, password);
        return u.getIdusuario();
    }
    @WebMethod(operationName = "tipoUsuario")
    public int tipoUsuario(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        DAOUsuario dao = new DAOUsuario();
        Usuario u = dao.login(user, password);
        return u.getTipousuario().getIdtipoUsuario();
    }

}
