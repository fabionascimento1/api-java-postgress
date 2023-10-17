package br.com.arenapro.arenapro;

import br.com.arenapro.arenapro.user.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class PrimeiraController {

    @GetMapping("/session")
    public String primeiraController() {
        return "OLáaaaaaa";
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id) {
        return "O para com metodo com query params é" + id;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams) {
        return "O para com metodo com query params 2 é" + allParams.entrySet();
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComQueryParams2(@RequestBody UserModel user) {
        return "O para com metodo com body params é" + user.getEmail();
    }

    @PostMapping("/metodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String name) {
        return "O metodo com headers" + name;
    }

    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers) {
        return "O metodo com list de headers" + headers.entrySet();
    }
}
