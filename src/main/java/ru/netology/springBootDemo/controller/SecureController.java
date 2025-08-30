package ru.netology.springBootDemo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String readOnly(){
        return "Доступ разрешен пользователю с ролью READ";
    }

    @RolesAllowed("WRITE")
    @GetMapping("/write")
    public String writeOnly() {
        return "Доступ разрешен пользователю с ролью WRITE";
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/modify")
    public String modify() {
        return "Доступ разрешен пользователю с ролью WRITE или DELETE";
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/personal")
    public String personal(@RequestParam String username) {
        return "Привет, " + username + ", ты получил доступ";
    }
}
