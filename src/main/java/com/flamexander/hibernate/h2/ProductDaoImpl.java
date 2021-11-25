package com.flamexander.hibernate.h2;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao { // созд имплементацию интерфейса дао, с пом которого происходит взаимод с бд и выполняются все операции над сущностями
    // переопределяем методы и прописываем, как они должны действовать

    // те ProductDaoImpl - реализация интерфейса, куда мы зашили фабрику

    private SessionFactoryUtils sessionFactoryUtils; // прокидываем класс sessionFactoryUtils

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) { // сессии созд при каждом действии с бд
            session.beginTransaction(); // начинается транзакция
            Product product = session.get(Product.class, id); // пытаемся достать объект класса Product по id
            session.getTransaction().commit(); // транзакция закоммитилась
            return product;
        }
    }

    @Override
    public Product findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select product from Product product where product.name = :name", Product.class)
                    .setParameter("name", name) // устанавливаем параметр
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select u from Product u").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }


    @Override
    public void saveOrUpdateNameById(Long id, String newName) {

        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setName(newName);
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {

        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
        //    product. хмммм где-то тут надо удалить
            session.delete(product);
            session.getTransaction().commit();
        }
    }

}
