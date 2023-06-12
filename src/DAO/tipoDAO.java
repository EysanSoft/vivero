package DAO;

import entities.Tipo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class tipoDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    public tipoDAO(){
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

    public List<Tipo> getTipos(){
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Tipo.class);
        List tipos = crit.list();
        session.close();
        return tipos;
    }

    public void agregarTipo(Tipo tipo) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(tipo);
        session.getTransaction().commit();
        session.close();
    }

    public void actualizarTipo(Tipo tipo) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(tipo);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminarTipo(Tipo tipo) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(tipo);
        session.getTransaction().commit();
        session.close();
    }
}
