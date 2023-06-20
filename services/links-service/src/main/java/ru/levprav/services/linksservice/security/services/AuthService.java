package ru.levprav.services.linksservice.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levprav.services.linksservice.security.utils.JwtAuthentication;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}

