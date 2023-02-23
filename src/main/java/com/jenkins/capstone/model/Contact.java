package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact extends AuditEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "contact_id")
    private int contactId;

    @NotBlank(message = "Must Enter Name")
    @Size(min = 3, message = "Name must be longer than 3 letters")
    private String name;


    /**
     * Generated regex - https://regexr.com/
     */
    @NotBlank(message = "Must enter a mobileNumber")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Number must be 10 digits")
    @Column(name = "mobile_num")
    private String mobileNum;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please enter a valid email")
    private String email;


    @NotBlank(message = "Must choose an account type")
    @Pattern(regexp = "^(?=.*\\b(dev|admin)\\b)(?!.*\\b(dev.*admin|admin.*dev)\\b).*$", message = "does not match either \"developer\" or \"admin\"")
    @Column(name = "account_type")
    private String accountType;

    @NotBlank(message = "Message cannot be blank")
    @Size(min = 5, message = "Must be more than 5 characters")
    @Size(max = 50, message = "Cannot be greater than 50 characters")
    private String message;


    //Open or closed
    private String status;

}
