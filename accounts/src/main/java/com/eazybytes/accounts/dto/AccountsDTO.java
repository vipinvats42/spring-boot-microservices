package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {
    
    @NotEmpty(message = "Account number cannot be null or empty!!")
    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Account number must be 10 digits")
    private long accountNumber;

  
    @NotEmpty(message = "Account type cannot be null or empty!!")
    private String accountType;

 
    @NotEmpty(message = "Branch address cannot be null or empty!!")
    private String branchAddress;
}
