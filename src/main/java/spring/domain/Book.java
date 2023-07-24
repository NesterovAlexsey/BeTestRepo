package spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Аннотация @Entity в Java Spring Boot обозначает, что класс представляет сущность в базе данных.
 * Объекты этого класса могут быть сохранены, извлечены, обновлены и удалены в бд
 * с использованием ORM (Object Relational Mapping). Аннотация @Entity должна быть применена к классу,
 * который будет отображаться в таблице базы данных, и должна содержать как минимум один
 * первичный ключ (аннотацию @Id).
 */
@Entity
//всегда должны быть все геттеры и сеттеры,
//а также конструктор без аргументов, в случае использования SpringBoot
@Getter
@Setter
@NoArgsConstructor
public class Book {

    //поле является первичным ключом таблицы в базе данных.
    @Id
    //Аннотация @GeneratedValue(strategy = GenerationType.IDENTITY) указывает,
    //как будет генерироваться значение для первичного ключа.
    //В данном случае, значение будет автоматически генерироваться базой данных.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;

    /**
     * Аннотация @ManyToOne указывает, что поле является отношением «многие-к-одному» к другой сущности.
     * Fetchtype.LAZY означает, что связанная сущность будет загружаться при необходимости, а не автоматически.
     * TargetEntity = ***.class указывает на класс, к которому установлено отношение.
     *
     * Аннотация @JoinColumn указывает на столбец в базе данных, который будет использоваться как внешний ключ
     * для связи между сущностями. Name = "authorId" указывает на имя столбца, а nullable = false указывает,
     * что значение не может быть пустым.
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Author.class)
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PublishYear.class)
    @JoinColumn(name = "yearId", nullable = false)
    private PublishYear year;
}
