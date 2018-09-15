/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Atencion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 *
 * @author Patricio
 */
public class DAOAtencion {
    private Session session;
    private Transaction tx;

    public DAOAtencion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    
    public boolean agregar(Atencion at) {
        try {
            session.save(at);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Atencion: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Atencion at) {
        try {
            Atencion ate = buscar(at.getIdatencion());
            ate.setUsuario(at.getUsuario());
            ate.setFaturada(at.getFaturada());
            ate.setTotalatencion(at.getTotalatencion());
            session.update(ate);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Atencion: " + e.getMessage());
        }
    }

    
    public boolean eliminar(String o) {
        try {
            Atencion ate = buscar(o);
            session.delete(ate);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Atencion: " + e.getMessage());
        }
    }

    
    public Atencion buscar(Object nomAtencion) {
        try {
            List<Atencion> lista = session.createQuery("from Atencion where Nombreateario='"+nomAtencion+"'").list();
            for ( Atencion ate : lista ) {
                return ate;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Atencion: " + e.getMessage());
        }
        return null;
    }
    
    public List<Atencion> listarTodo() {
        try {
            List<Atencion> lista = session.createQuery("from Atencion").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Atencions: " + e.getMessage());
        }
    }
}
