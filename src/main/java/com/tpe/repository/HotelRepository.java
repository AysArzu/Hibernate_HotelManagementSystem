package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Room, Guest, Reservation icin service ve repo classlarini olusturalim

public class HotelRepository {

    private Session session;

    //1-b
    public void save(Hotel hotel) {
        try {
            HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(hotel);//insert into t_hotel values
            transaction.commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }

    }
}
