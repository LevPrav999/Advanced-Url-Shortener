package ru.levprav.services.usersservice.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.levprav.services.usersservice.models.User;
import ru.levprav.services.usersservice.repositories.IUsersRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {
    private final IUsersRepository usersRepository;

    public User create(User user) {
        if (usersRepository.existsByLogin(user.getLogin()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exists!");
        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        return usersRepository.save(user);
    }

    public User findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
    }

    public User findByLogin(String login) {
        return usersRepository.findByLogin(login)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
    }
}