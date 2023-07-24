package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.domain.PublishYear;

public interface PublishYearRepository extends JpaRepository<PublishYear, Integer> {
    PublishYear findByYearOfBook(Integer yearOfBook);
}
