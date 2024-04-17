package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }

    }

    //2-b
    public Hotel findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            //select * from t_hotel where id=pId
            return session.get(Hotel.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    //4-b
    public List<Hotel> findAll(){
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            //select * from t_otel where id=pId
        List<Hotel> hotelList = session.createQuery("FROM Hotel",Hotel.class).getResultList();
        return hotelList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;



    }
}
