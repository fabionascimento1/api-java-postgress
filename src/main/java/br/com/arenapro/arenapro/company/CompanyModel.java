package br.com.arenapro.arenapro.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "companies")
public class CompanyModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private UUID userId;
    @Column(length = 70)
    private String name;
    private String postalcode;

    @CreationTimestamp
    private LocalDateTime created_at;

    public void setName(String name) throws Exception {
        if(name.length() > 70) {
            throw new Exception("O campo nome não pode ser maior que 70 caracteres.");
        }
        this.name = name;
    }
}
