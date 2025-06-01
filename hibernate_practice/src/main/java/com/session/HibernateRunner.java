package com.session;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static util.HibernateUtil.buildSessionFactory;

public class HibernateRunner {

    private static final Logger log = LogManager.getLogger(HibernateRunner.class);

    public static void main(String[] args){
        User user = User.builder()
            .userName("ivanko@gmail.com")
            .firstName("Ivan")
            .lastName("Ivanchelo")
            .build();

        log.error("{} BLABLABLA", user.toString());

        try(var sessionFactory = buildSessionFactory()){
            try(var session1 = sessionFactory.openSession()){
                session1.beginTransaction();

                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            } catch (Exception e ){

            }
            try(var session2 = sessionFactory.openSession()){
                session2.beginTransaction();

                user.setFirstName("Koalko");

                //refresh from bd to client
                //merge from client to bd
                session2.merge(user);

                session2.getTransaction().commit();
            } catch (Exception e ){

            }
        } catch (Exception e) {

        }
    }
}
