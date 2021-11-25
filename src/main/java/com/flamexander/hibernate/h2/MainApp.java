package com.flamexander.hibernate.h2;

public class MainApp {
    public static void main(String[] args) {

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init(); // инициализируем фабрику при запуске программы
        try {
//            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
//            productDao.testCaching();

            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

            System.out.println(productDao.findById(2L)); // ищет по id
            System.out.println(productDao.findAll());

            System.out.println(productDao.findAll()); // ищет все продукты

            productDao.saveOrUpdateNameById(1L, "Tea"); // меняеи или сохраняет
            System.out.println(productDao.findAll());

            productDao.deleteById(1L); // удаляет по id
            System.out.println(productDao.findAll());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown(); // если фабрика не пустая - мы ее закрываем
        }
    }
}
