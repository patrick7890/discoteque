/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Producto;
import dto.Tipoproducto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricio
 */
public class DAOProducto {

    private Session session;
    private Transaction tx;

    public DAOProducto() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public boolean agregar(Producto pr) {
        try {
            session.save(pr);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Producto: " + e.getMessage());
        }
    }

    public boolean actualizar(Producto pr) {
        try {
            Producto pro = buscar(pr.getIdproducto());
            pro.setNombreProducto(pr.getNombreProducto());
            pro.setPrecio(pr.getPrecio());
            pro.setStock(pr.getStock());
            pro.setEnVenta(pr.getEnVenta());
            pro.setTipoproducto(pr.getTipoproducto());
            session.update(pro);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Producto: " + e.getMessage());
        }
    }

    public boolean eliminar(String o) {
        try {
            Producto ate = buscar(o);
            session.delete(ate);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Producto: " + e.getMessage());
        }
    }

    public Producto buscar(Object nomProducto) {
        try {
            List<Producto> lista = session.createQuery("from Producto where idproducto='" + nomProducto + "'").list();
            for (Producto pro : lista) {
                return pro;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Producto: " + e.getMessage());
        }
        return null;
    }
    public Tipoproducto buscarTipo(Object id) {
        try {
            List<Tipoproducto> lista = session.createQuery("from Tipoproducto where idtipoProducto='" + id + "'").list();
            for (Tipoproducto tipo : lista) {
                return tipo;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Producto: " + e.getMessage());
        }
        return null;
    }

    public List<Producto> listarTodo() {
        try {
            List<Producto> lista = session.createQuery("from Producto").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Productos: " + e.getMessage());
        }
    }

    public String stock(int pr) {
        Producto p = (Producto) session.get(Producto.class, pr);
        if (p!=null) {
            return "el producto es"+p.getNombreProducto()+"tiene "+p.getStock();
        }
        return "no se encontro el producto";
    }
}
