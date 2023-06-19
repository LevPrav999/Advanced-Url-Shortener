package ru.levprav.shortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levprav.shortener.models.Link;

import java.util.Optional;

public interface ILinksRepository extends JpaRepository<Link, Integer> {
    Optional<Link> findByAccessHash(String accessHash);
}