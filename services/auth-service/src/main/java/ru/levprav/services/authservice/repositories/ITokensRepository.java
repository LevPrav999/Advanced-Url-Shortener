package ru.levprav.services.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.levprav.services.authservice.models.Token;

import java.util.Optional;

@Repository
public interface ITokensRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByValue(String value);
}
