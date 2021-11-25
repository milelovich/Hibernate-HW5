package com.flamexander.hibernate.h2;

import javax.persistence.*;

@Entity // аннотация сущности, чтобы объекты класса могли мапиться в бд и обратно
@Table(name = "products") // аннотация говорит, что сущности этого класса живут в таблице products
public class Product {
    @Id // primary key - hibernate не сможет управлять таблицей, если в ней нет первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // соотв между полем объекта и столбцом, куда отобразится
    private Long id; // в роли первичного ключа, который обязательно должен быть (поле id - bigserial, автоинкремирует поле id)

    @Column(name = "name")
    private String name; // это поле отобразится в столбец, обозначенный в строке выше

    @Column(name = "score")
    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product() { // hibernate исп дефолтный конструктор, чтобы создать базовый объект, затем сеттерами наполняет поля, которые получил из резалтсэта
    }

    // сеттеры нужны, когда мы достаем объекты из базы, гетеры - вытаскивают данные об объекте и отправляют в базу

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
