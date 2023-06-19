package ru.levprav.shortener.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Link {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "links_seq")
    @SequenceGenerator(name = "links_seq", sequenceName = "links_seq", allocationSize = 1)
    private int id;

    @Column(name = "access_hash")
    private String accessHash;

    @Column(name = "target_url")
    private String targetUrl;


}
