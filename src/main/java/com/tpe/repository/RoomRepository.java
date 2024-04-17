package com.tpe.repository;


import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {
    private Session session;

    //room 1-b
    public void save(Room room) {
        try {
            HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Room findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Room.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Room> findAll() {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            //select * from t_otel where id=pId
            List<Room> roomList = session.createQuery("FROM Room", Room.class).getResultList();
            return roomList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;


    }
//odev save, findById, findAll

}
