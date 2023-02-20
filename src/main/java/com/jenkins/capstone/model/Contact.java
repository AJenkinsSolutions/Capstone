package com.jenkins.capstone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "applicant_msg")
public class Contact extends CoreEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String mobileNum;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Must choose an account type")
    @Pattern(regexp = "^(?i)(developer|admin)$\n", message = "does not match either \"developer\" or \"admin\"")
    private String accountType;

    @NotBlank(message = "Message cannot be blank")
    @Size(min = 5, message = "Must be more than 5 characters")
    @Size(max = 50, message = "Cannot be greater than 50 characters")
    private String message;


    //Open or closed
    private String status;




}
