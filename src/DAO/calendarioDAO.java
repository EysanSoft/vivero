package DAO;

import entities.Calendario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class calendarioDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public calendarioDAO() {
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

    public Calendario getCalendario(int id) {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(entities.Calendario.class);
        crit.add(Restrictions.eq("idCalendario", id));
        List<Calendario> calendarioList = crit.list();
        Calendario calendario = (Calendario) calendarioList.get(0);
        session.close();
        return calendario;
    }

    public List<Calendario> getListaCalendario() {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Calendario.class);
        List calendarioList = crit.list();
        return calendarioList;
    }

    public void agregarCalendario(Calendario calendario) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(calendario);
        session.getTransaction().commit();
        session.close();
    }

    public void actualizarCalendario(Calendario calendario) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(calendario);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminarCalendario(Calendario calendario) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(calendario);
        session.getTransaction().commit();
        session.close();
    }
}
/*
    //Metodos para obtener un String de un Calendario por Año
    public void obtenerCalendario() {
        //Definir el Año
        int ano = 2020;

        //Proceso
        for (int i = 1; i <= 12; i++) {
            System.out.println("\nMes: "+ i);
            System.out.println("Dom\tLun\tMar\tMie\tJue\tVie\tSab");
            int dias = diasMes(ano, i);

            //Se calculan los espacios para que los dias esten en la posicion correcta
            int z = zeller(ano, i);
            int conDia = 0;
            for(int k = 0; k < z; k++) {
                conDia++;
                System.out.print("\t");
            }

            //Imprime los dias del mes
            for(int j = 1; j <= dias; j++) {
                System.out.print(j + "\t");
                conDia++;
                if (conDia == 7) {
                    System.out.println();
                    conDia = 0;
                }
            }
        }
    }

    public int zeller(int ano, int mes) {
        int a = (14 - mes) / 12;
        int y = ano - a;
        int m = mes + 12 * a - 2;
        int dia = 1, d;

        d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
        return (d);
    }

    public int diasMes(int ano, int mes) {
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            return 31;
        }
        else if(mes == 2) {
            if(esBisiesto(ano)) {
                return 29;
            }
            else {
                return 28;
            }
        }
        else {
            return 30;
        }
    }

    //Metodo para determinar si un año es bisiesto o no
    public boolean esBisiesto(int ano) {
        if(ano % 4 == 0) {
            if(ano % 100 == 0) {
                if(ano % 400 == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
*/