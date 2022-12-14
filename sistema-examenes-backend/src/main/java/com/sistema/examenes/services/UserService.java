package com.sistema.examenes.services;

import com.sistema.examenes.services.entities.User;
import com.sistema.examenes.services.entities.UserRole;

import java.util.Set;

public interface UserService {

    /**
     * Guardar usuario y los roles que tiene
     * @param user que se desea guardar
     * @param userRoleSet Lista de roles del usuario, con la tabla normalizada de muchos a muchos
     * @return  Usuario Guardado
     * @throws Exception en caso de que el usuario exista
     */
    public User saveUser(User user, Set<UserRole> userRoleSet) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);

}
