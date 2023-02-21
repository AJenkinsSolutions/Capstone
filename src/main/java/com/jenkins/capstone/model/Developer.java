package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import com.jenkins.capstone.decorators.InputValueMatch;
import com.jenkins.capstone.decorators.PasswordStrength;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@InputValueMatch.List({
        @InputValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Passwords do not match"
        ),
        @InputValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email address do not match"
        )
})
public class Developer extends AuditEntity {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int developerId;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, message = "Name must be greater than 3 letters")
    private String name;

    @NotBlank(message = "Email address is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "confirm email is required.")
    @Email(message = "please use a valid  confirm email")
    @Transient
    private String confirmEmail;


    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Please use a valid us number, include '-'")
    private String mobileNumber;


    @NotBlank(message = "Password is required.")
    @Size(min = 5, message = "Password must be longer than ")
    @PasswordStrength
    private String pwd;


    @NotBlank(message = "confirm password is required.")
    @Transient
    private String confirmPwd;
}
