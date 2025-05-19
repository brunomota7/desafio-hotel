package br.com.desafio.controller;

import br.com.desafio.dto.request.UsuarioRequestDTO;
import br.com.desafio.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody @Valid UsuarioRequestDTO dto) {
        try {
            usuarioService.createUser(dto);
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(403).body(ex);
        }
    }

}
