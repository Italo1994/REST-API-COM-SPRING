package dio.web.api.controller;

import java.util.List;
import java.util.ArrayList;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping("/users")
    // @PreAuthorize("hasAnyRole('MANAGERS', 'USER')")
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    @GetMapping("/managers")
    // @PreAuthorize("hasRole('MANAGER')")
    public String managers() {
        return "Authorized manager";
    }
}
