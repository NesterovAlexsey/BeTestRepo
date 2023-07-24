package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.domain.Book;

/**
 * В интерфейсе JpaRepository<T, ID>, T обозначает тип сущности (Entity), с которой мы работаем,
 * а ID обозначает тип идентификатора (Primary Key) этой сущности.
 *
 * Тип ID указывает, какой тип данных будет использоваться в качестве идентификатора для данной сущности.
 * Например, если у нас есть сущность User с идентификатором типа Long, то в интерфейсе UserRepository,
 * который расширяет JpaRepository<User, Long>, тип T будет User, а тип ID будет Long.
 *
 * Таким образом, JpaRepository предоставляет общие методы для работы с сущностями в базе данных,
 * основываясь на их типе и идентификаторе.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
