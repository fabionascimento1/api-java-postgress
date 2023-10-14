package br.com.arenapro.arenapro.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICompanyRepository extends JpaRepository<CompanyModel, UUID> {
    List<CompanyModel> findByUserId(UUID userId);
}
