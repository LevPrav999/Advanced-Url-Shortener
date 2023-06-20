package ru.levprav.services.linksservice.models;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "access_hash")
    private String accessHash;

    @Column(name = "target_url")
    private String targetUrl;


    @Column(name = "clicks")
    private int clicks;

    @Column(name = "owner_name")
    private String ownerName;

}
