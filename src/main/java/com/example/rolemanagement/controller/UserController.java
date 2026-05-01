package com.example.rolemanagement.controller;

import com.example.rolemanagement.dto.AssignRoleRequest;
import com.example.rolemanagement.entity.User;
import com.example.rolemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/{userId}/roles")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> assignRole(@PathVariable Long userId, @RequestBody AssignRoleRequest request) {
        userService.assignRoleToUser(userId, request.getRoleId());
        return ResponseEntity.ok().build();
    }
}
