import com.grailsbrains.persistence.DestinationAddress;
import com.grailsbrains.persistence.OriginAddress;
import com.grailsbrains.persistence.POAddress;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Date;
import java.util.Map;

/**
 * Created by Ajeet on 5/5/2017.
 */
public class Main {
    /*private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }*/

    public static void main(final String[] args) throws Exception {
        /*final Session session = getSession();
        Transaction tx = session.beginTransaction();
        */
        try {
           /* POAddress poAddress = new POAddress();
            poAddress.setRefererName("ajeet");
            poAddress.setAddress("kotra");
            poAddress.setCity("bhopal");
            poAddress.setCountry("india");
            System.out.println(poAddress.toString());

            OriginAddress originAddress =new OriginAddress();
            originAddress.setRefererName("ajeet");
            originAddress.setAddress("kotra");
            originAddress.setCity("bhopal");
            originAddress.setCountry("india");
            originAddress.setPickupStart(new Date());
            originAddress.setPickupEnd(new Date());

            DestinationAddress destinationAddress =new DestinationAddress();
            destinationAddress.setRefererName("ajeet");
            destinationAddress.setAddress("kotra");
            destinationAddress.setCity("bhopal");
            destinationAddress.setCountry("india");
            destinationAddress.setDeliveryStart(new Date());
            destinationAddress.setDeliveryEnd(new Date());

            session.persist(poAddress);
            session.persist(originAddress);
            session.persist(destinationAddress);


            tx.commit();*/
            //session.close();
            System.out.println("success");

        }catch (Exception e){
            //tx.rollback();
            e.printStackTrace();
        }
        finally {
           // session.close();
            System.exit(0);
        }
    }
}