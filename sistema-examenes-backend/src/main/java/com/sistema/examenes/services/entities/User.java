package com.sistema.examenes.services.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.examenes.security.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Tabla de usuarios
 */
@Entity
@Table(name = "usuarios")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremen cuando cree nuevo registro
    private Long id;

    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Boolean enable = true; // para saber si el usuario esta habilitado para hacer examenes
    private String profile;

    /**
     * - CascadeType.ALL: Propaga todas las operaciones de una entidad, a la entidad con la que se relaciona.
     * - FetchType.EAGER: Lista todos lo registros relacionados al usuario
     * - mappedBy: Apunta a la entidad propietaria de la relacion
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore // Omite los roles del usuario cuando lo llamamos con get
    private Set<UserRole> userRoles = new HashSet<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Recorremos los roles que tiene el usuario en cuestion,
     * obtenemos los nombres de los roles
     * los guardamos en una lista de autoridades
     * @return la lista con las autoridades del usuario
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autorities = new HashSet<>();

        this.userRoles.forEach(userRole -> {
            autorities.add(new Authority(userRole.getRole().getNameRole()));
        });
        return autorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
