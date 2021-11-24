package co.usa.c4.c4reto.web;


import co.usa.c4.c4reto.model.User;
import co.usa.c4.c4reto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
/**
 * Clase publica User Controller
 */
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Llamado web para todos los elementos
     * @return muestra todos los registros
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Llamado metodo post para nuevo usuario
     * @param user
     * @return registro de usuario nuevo
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }

    /**
     * Llamado web para obtener email y password
     * @param email
     * @param password
     * @return autenticacion de usuario
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

    /**
     * LLamado para verificar existencia de email
     * @param email
     * @return true o false
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }

}
