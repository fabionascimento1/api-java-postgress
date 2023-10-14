package br.com.arenapro.arenapro.company;

import br.com.arenapro.arenapro.uitls.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ICompanyRepository companyRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody CompanyModel companyModel, HttpServletRequest request) {
        var userId = request.getAttribute("userId");
        companyModel.setUserId((UUID) userId);

//        var currentDate = LocalDateTime.now();
//        if (currentDate.isAfter((companyModel.getCreated_at()))) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de criação deve ser maior que data atual");
//        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyRepository.save((companyModel)));
    }

    @GetMapping("/")
    public List<CompanyModel> list(HttpServletRequest request) {
        var userId = request.getAttribute("userId");
        var companies = this.companyRepository.findByUserId((UUID) userId);
        return companies;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody CompanyModel companyModel, @PathVariable UUID id, HttpServletRequest request) {
        //var userId = request.getAttribute("userId");
        var company = this.companyRepository.findById(id).orElse(null);

        var userId = request.getAttribute("userId");

        if(!company.getUserId().equals(userId)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não tem permissão para alterar essa tarefa!");
        }

        Utils.copyNonNullProperties(companyModel , company);
//        companyModel.setUserId((UUID) userId);
//        companyModel.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyRepository.save(company));
    }
}
