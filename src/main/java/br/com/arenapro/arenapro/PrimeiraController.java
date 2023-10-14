package br.com.arenapro.arenapro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PrimeiraController {

    @GetMapping("/session")
    public String primeiraController() {
        return "OLáaaaaaa";
    }
}
