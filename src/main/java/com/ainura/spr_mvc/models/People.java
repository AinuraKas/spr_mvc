package com.ainura.spr_mvc.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "people")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="PEOPLE_SEQ")
    @SequenceGenerator(sequenceName = "PEOPLE_SQ", allocationSize = 1, name = "PEOPLE_SEQ")

    private Long id;

    @Column
    private String name;



}
