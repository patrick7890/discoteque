/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Comanda;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Patricio
 */
public class DAOComanda {
    private Session session;
    private Transaction tx;

    public DAOComanda() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    
    public boolean agregar(Comanda co) {
        try {
            session.save(co);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Comanda: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Comanda co) {
        try {
            Comanda com = buscar(co.getIdcomanda());
            com.setAtencion(co.getAtencion());
            com.setTotalcomanda(co.getTotalcomanda());
            session.update(com);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Comanda: " + e.getMessage());
        }
    }

    
    public boolean eliminar(String o) {
        try {
            Comanda ate = buscar(o);
            session.delete(ate);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Comanda: " + e.getMessage());
        }
    }

    
    public Comanda buscar(Object nomComanda) {
        try {
            List<Comanda> lista = session.createQuery("from Comanda where idComanda='"+nomComanda+"'").list();
            for ( Comanda ate : lista ) {
                return ate;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Comanda: " + e.getMessage());
        }
        return null;
    }
    
    public List<Comanda> listarTodo() {
        try {
            List<Comanda> lista = session.createQuery("from Comanda").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Comandas: " + e.getMessage());
        }
    }
}
