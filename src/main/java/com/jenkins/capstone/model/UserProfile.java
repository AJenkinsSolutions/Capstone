package com.jenkins.capstone.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This Simple pojo will be sent to update profile view to store information about the fields user will update
 */
@Data
public class UserProfile {

    @NotBlank(message = "Name is required.")
    @Size(min = 3, message = "Name must be greater than 3 letters")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Please use a valid us number, include '-'")
    private String mobileNumber;

    @NotBlank(message = "Email address is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "Language is required")
    private String language;

    @NotBlank(message = "Specify if front End development is in your skill set")
    private boolean frontEnd;

    @NotBlank(message = "Specify if backEnd development is in your skill set")
    private boolean backEnd;

    private String ide;

}
