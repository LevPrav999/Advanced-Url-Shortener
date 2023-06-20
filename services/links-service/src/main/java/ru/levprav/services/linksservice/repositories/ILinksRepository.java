package ru.levprav.services.linksservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levprav.services.linksservice.models.Link;

import java.util.Optional;

public interface ILinksRepository extends JpaRepository<Link, Integer> {
    Optional<Link> findByAccessHash(String accessHash);
}