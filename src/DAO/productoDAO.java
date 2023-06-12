package DAO;

import entities.Producto;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class productoDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public productoDAO() {
        System.err.println("Iniciando");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion SQL");
            configuration.configure("hibernateSQL.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public List<Producto> getListaProductos() {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Producto.class);
        List productos = crit.list();
        return productos;
    }

    public Producto getProducto(int id) {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(entities.Producto.class);
        crit.add(Restrictions.eq("idProducto", id));
        List<Producto> productos = crit.list();
        Producto producto = (Producto) productos.get(0);
        session.close();
        return producto;
    }

    public void agregarProducto(Producto producto) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(producto);
        session.getTransaction().commit();
        session.close();
    }

    public void actualizarProducto(Producto producto) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(producto);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminarProducto(Producto producto) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(producto);
        session.getTransaction().commit();
        session.close();
    }
}
