package ru.levprav.services.usersservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levprav.services.usersservice.models.User;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String email);
    boolean existsByLogin(String email);

}