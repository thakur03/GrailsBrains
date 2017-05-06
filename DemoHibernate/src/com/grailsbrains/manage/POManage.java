package com.grailsbrains.manage;

import com.grailsbrains.forms.PurchaseOrderForm;
import com.grailsbrains.persistence.DestinationAddress;
import com.grailsbrains.persistence.OriginAddress;
import com.grailsbrains.persistence.PurchaseOrder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ajeet on 5/5/2017.
 */
public class POManage {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    final Session session = getSession();
    Transaction tx = session.beginTransaction();
    public int createPurchaseOrder(PurchaseOrder purchaseOrder){

        System.out.println("inside create purchase order");

        System.out.println("session opened");
        try {
            System.out.println("inside try");


            session.save(purchaseOrder);
           tx.commit();

        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Error creating User :" + e.getMessage());
            tx.rollback();
            return 0 ;
        }
        return 0;
    }

   public List<PurchaseOrder> viewOrders(){
        System.out.println("before session open");
        Session session = HibernateUtil.getSessionFactory().openSession();
       System.out.println("after session open");
       List finalList = new ArrayList<>();
       List<PurchaseOrder> poList = null;
       List<OriginAddress> originList = null;
       List<DestinationAddress> destList = null;
        try {
            System.out.println("inside try of view method");
            session.beginTransaction();
            List <?> l1 = new ArrayList<>();
            poList = session.createQuery("  SELECT poNumber, seller_vendor, dueDate, status,priority, transResp from PurchaseOrder").list();
            Iterator<PurchaseOrder> itr = poList.iterator();
            while(itr.hasNext()){
                PurchaseOrder purchaseOrder = itr.next();
                purchaseOrder.setPoNumber(purchaseOrder.getPoNumber());
                purchaseOrder.setSeller_vendor(purchaseOrder.getSeller_vendor());
                purchaseOrder.setDueDate(purchaseOrder.getDueDate());
                purchaseOrder.setStatus(purchaseOrder.getStatus());
                purchaseOrder.setPriority(purchaseOrder.getPriority());
                purchaseOrder.setTransResp(purchaseOrder.getTransResp());
                l1.add(purchaseOrder);
            }
            tx.commit();
            session.close();

            finalList.addAll(poList);


        } catch (Exception e) {
            System.err.println("Error getting Users :" + e);
            session.getTransaction().rollback();
        }
        return finalList;
    }
}
