package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(name="Account",
description="schema infrmation for customer and account infiormation")
@Data
public class AccountsDTO {
    
    @NotEmpty(message = "Account number cannot be null or empty!!")
    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Account number must be 10 digits")
    @Schema(description = "Account number of the bank")
    private long accountNumber;

  
    @NotEmpty(message = "Account type cannot be null or empty!!")
    @Schema(description = "Account type of the bank" ,example="Savings")
    private String accountType;

 
    @NotEmpty(message = "Branch address cannot be null or empty!!")
    @Schema(description = "Branch Address of the bank" )
    private String branchAddress;
}
