package ru.levprav.services.linksservice.services;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.levprav.services.linksservice.dto.CreateLinkDto;
import ru.levprav.services.linksservice.exceptions.SimpleHttpException;
import ru.levprav.services.linksservice.models.Link;
import ru.levprav.services.linksservice.repositories.ILinksRepository;
import ru.levprav.services.linksservice.security.services.AuthService;
import ru.levprav.services.linksservice.utils.RandomString;

@Service
public class LinksService {
    private final ILinksRepository linksRepository;
    private final AuthService authService;

    public LinksService(ILinksRepository linksRepository, AuthService authService) {
        this.linksRepository = linksRepository;
        this.authService = authService;
    }

    public Link create(CreateLinkDto createLinkDto) {
        Link newLink = new Link();
        newLink.setAccessHash(RandomString.generateString(10));
        newLink.setTargetUrl(createLinkDto.getTargetURL());
        newLink.setClicks(0);
        newLink.setOwnerName(authService.getAuthInfo().getName());
        linksRepository.save(newLink);
        return newLink;
    }

    public Link getByAccessHash(String hash) throws SimpleHttpException {
        Link link = linksRepository.findByAccessHash(hash);
        if (link == null)
            throw new SimpleHttpException(HttpStatus.NOT_FOUND, "Link not found!");

        int clicks = link.getClicks();
        clicks++;
        link.setClicks(clicks);
        linksRepository.save(link);

        return linksRepository.save(link);
    }
}
