package co.edu.escuelaing.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.security.crypto.bcrypt.BCrypt;

import co.edu.escuelaing.entities.User;
import co.edu.escuelaing.utils.RoleEnum;

public class UserDto {
    private String id;
    private String name;
    private String email;
    private String lastName;
    private String password;
    private String createdAt;

    public UserDto() {
    }

    public UserDto(String id, String name, String email, String lastName, String password, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User toEntity() {
        try {
            return new User(id, name, email, lastName, new SimpleDateFormat("dd/MM/yyyy").parse(createdAt),
                    BCrypt.hashpw(this.getPassword(), BCrypt.gensalt()), RoleEnum.USER);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
