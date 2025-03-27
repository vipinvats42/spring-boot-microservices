package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
   @NotEmpty(message = "Name cannot be null or empty!!")
   @Size(min = 5,max = 30,message = "Name must be between 5 and 30 characters")
    private String name;

    @NotEmpty(message = "Email cannot be null or empty!!")
    @Email(message = "Email must be valid!!")
    private String email;

    @Pattern(regexp ="^(0|[1-9][0-9]*)$",message = "Mobile number must be 10 digits" )
    private String mobileNumber;

    private AccountsDTO accountsDTO;
}
