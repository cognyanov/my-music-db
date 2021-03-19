package com.examFeb.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size (min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @NotBlank(message = "Please enter username")
    private String username;
    @Size (min = 3, max = 20, message = "Full name must be between 3 and 20 characters")
    @NotBlank(message = "Please enter full name")
    private String fullName;
    @Email
    @NotBlank
    private String email;
    @Size (min = 5, max = 20, message = "Password must be between 5 and 20 characters")
    @NotBlank(message = "Please enter password")
    private String password;
    @Size (min = 5, max = 20, message = "Password must be between 5 and 20 characters")
    @NotBlank(message = "Please confirm password")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
