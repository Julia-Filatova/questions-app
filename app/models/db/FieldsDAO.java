package models.db;

import models.entities.Field;
import models.entities.FieldType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Singleton;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Yuliia_Filatova on 9/9/2016.
 */
@Singleton
public class FieldsDAO {

    public static final String ENTITY_NAME = "Fields";
    public static final String GET_ALL_INSTANCES = "from " + ENTITY_NAME;

    /*
    TODO: move to the separate util class
     */
    private SessionFactory sessionFactory;

        {
            try{

                Configuration configuration = new Configuration();

                configuration.configure("hibernate.cfg.xml");

                StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

                standardServiceRegistryBuilder.applySettings(configuration.getProperties());

                ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();

                setSessionFactory(configuration.buildSessionFactory(serviceRegistry));
            }
            catch(HibernateException hex){
                hex.printStackTrace(); //TODO logging
            }
        }

        public  SessionFactory getSessionFactory(){
            return sessionFactory;
        }

        public  void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        /*
        TODO: Why do we need it?
         */
        public void shutdown()
        {
            getSessionFactory().close();
        }



    public List<Field> getAllFields() {
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(GET_ALL_INSTANCES);
        List<Field> allFields = query.list();

        session.close();
        return allFields;
    }

    /**
     * Аляля, работает!
     * @param args
     */
    public static void main(String[] args) {


        Session session = new FieldsDAO().sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            Field user = new Field();
            user.setLabel("Field #" + i);
            user.setActive(i % 2 == 0);
            user.setRequired(i % 2 == 1);
            user.setTypeOfField(FieldType.values()[i]);
            session.save(user);
        }

        session.getTransaction().commit();
        session.close();
        System.out.println(new FieldsDAO().getAllFields());
    }

}
