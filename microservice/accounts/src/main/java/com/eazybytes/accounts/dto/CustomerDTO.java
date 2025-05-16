package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name="Customer",
description="schema infrmation for customer and account infiormation")
public class CustomerDTO {
   @NotEmpty(message = "Name cannot be null or empty!!")
   @Size(min = 5,max = 30,message = "Name must be between 5 and 30 characters")
   @Schema(description = "Name of the customer",example = "Vipin Tyagi")
    private String name;

    @NotEmpty(message = "Email cannot be null or empty!!")
    @Email(message = "Email must be valid!!")
    @Schema(description = "Email of the customer",example = "vipin@gmail.com")
    private String email;

    @Pattern(regexp ="^(0|[1-9][0-9]*)$",message = "Mobile number must be 10 digits" )
    @Schema(description = "Mobile number of the customer",example = "9999999")
    private String mobileNumber;

    @Schema(description = "Name of the customer")
    private AccountsDTO accountsDTO;
}
