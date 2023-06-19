package ru.levprav.shortener.services;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.levprav.shortener.dto.CreateLinkDto;
import ru.levprav.shortener.exceptions.SimpleHttpException;
import ru.levprav.shortener.models.Link;
import ru.levprav.shortener.repositories.ILinksRepository;
import ru.levprav.shortener.utils.RandomString;

@Service
public class LinksService {
    private final ILinksRepository linksRepository;

    public LinksService(ILinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    public Link create(CreateLinkDto createLinkDto) {
        Link newLink = new Link();
        newLink.setAccessHash(RandomString.generateString(10));
        newLink.setTargetUrl(createLinkDto.getTargetURL());
        linksRepository.save(newLink);
        return newLink;
    }

    public Link getByAccessHash(String hash) throws SimpleHttpException {
        return linksRepository.findByAccessHash(hash)
                .orElseThrow(() -> new SimpleHttpException(HttpStatus.NOT_FOUND, "Link not found!"));
    }
}
