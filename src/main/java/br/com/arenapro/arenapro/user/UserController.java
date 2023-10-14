package br.com.arenapro.arenapro.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        UserModel byEmail = userRepository.findByEmail(userModel.getEmail());
        if (byEmail != null) {
            // throw new RuntimeException("Email já cadastrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já exite");
        }
        var passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashed);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userRepository.save((userModel)));

    }
}
