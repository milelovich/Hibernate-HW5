package com.flamexander.hibernate.h2;

import java.util.List;

public interface ProductDao { // класс, с пом которого происходит взаимод с бд и выполняются все операции над сущностями

    Product findById(Long id); // для кажд продукта есть поиск по id
    Product findByName(String name);// для кажд продукта есть поиск по name
    List<Product> findAll();
    void saveOrUpdateNameById(Long id, String newName);
    void deleteById(Long id);


}
