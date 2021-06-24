package kz.one.lab.Catalog.Catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DBRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    List<User> findAll();
}
