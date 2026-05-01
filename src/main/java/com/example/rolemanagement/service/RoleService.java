package com.example.rolemanagement.service;

import com.example.rolemanagement.entity.Permission;
import com.example.rolemanagement.entity.Role;
import com.example.rolemanagement.repository.PermissionRepository;
import com.example.rolemanagement.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public Role createRole(Role role) {
        if (roleRepository.findByName(role.getName()).isPresent()) {
            throw new RuntimeException("Role already exists!");
        }
        return roleRepository.save(role);
    }

    public Permission createPermission(Permission permission) {
        if (permissionRepository.findByName(permission.getName()).isPresent()) {
            throw new RuntimeException("Permission already exists!");
        }
        return permissionRepository.save(permission);
    }

    public void assignPermissionToRole(Long roleId, Long permissionId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        role.getPermissions().add(permission);
        roleRepository.save(role);
    }
    
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
