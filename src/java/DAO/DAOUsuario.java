/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Tipousuario;
import dto.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricio
 */
public class DAOUsuario {
    private Session session;
    private Transaction tx;

    public DAOUsuario() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public Usuario login(String user, String pass) {
        try {
            List<Usuario> lista = session.createQuery("FROM Usuario where cuentausuario='" + user + "' and passusuario='" + pass + "'").list();
            for (Usuario aux : lista) {
                if (aux.getCuentausuario().equalsIgnoreCase(user) && aux.getPassusuario().equalsIgnoreCase(pass)) {
                    return aux;
                }
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("Error" + e.getMessage());
        }
        return null;
    }
    
    public boolean agregar(Usuario us) {
        try {
            session.save(us);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Usuario: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Usuario us) {
        try {
            Usuario usu = buscar(us.getCuentausuario());
            usu.setNombreusuario(us.getNombreusuario());
            usu.setPassusuario(us.getPassusuario());
            usu.setTipousuario(us.getTipousuario());
            session.update(usu);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Usuario: " + e.getMessage());
        }
    }

    
    public boolean eliminar(String o) {
        try {
            Usuario usu = buscar(o);
            session.delete(usu);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Usuario: " + e.getMessage());
        }
    }

    
    public Usuario buscar(Object nomUsuario) {
        try {
            List<Usuario> lista = session.createQuery("from Usuario where Nombreusuario='"+nomUsuario+"'").list();
            for ( Usuario usu : lista ) {
                return usu;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Usuario: " + e.getMessage());
        }
        return null;
    }
    public Tipousuario buscarTipo(Object o) {
        try {
            List<Tipousuario> lista = session.createQuery("from Tipousuario where idtipoUsuario='"+o+"'").list();
            for ( Tipousuario usu : lista ) {
                return usu;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Usuario: " + e.getMessage());
        }
        return null;
    }

    
    public List<Usuario> listarTodo() {
        try {
            List<Usuario> lista = session.createQuery("from Usuario").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Usuarios: " + e.getMessage());
        }
    }
    public List<Tipousuario> listarTipo() {
        try {
            List<Tipousuario> lista = session.createQuery("from Tipousuario where id_tipo_usuario >2").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Tipos: " + e.getMessage());
        }
    }
    public List<Tipousuario> listarTipoAdmin() {
        try {
            List<Tipousuario> lista = session.createQuery("from Tipousuario").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Tipos: " + e.getMessage());
        }
    }
}
