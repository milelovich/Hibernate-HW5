package com.flamexander.hibernate.h2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils { // спец класс для логики приложения - утилиты для управления фабрикой и для запроса сессий


    private SessionFactory factory;

    public void init() { // построение фабрики
        factory = new Configuration() // создаем фабрику сессий - не на каждый запрос, а на все приложение
                .configure("hibernate.cfg.xml") // вот есть конфигурация
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
