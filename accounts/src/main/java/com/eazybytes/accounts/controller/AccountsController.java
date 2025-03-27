package com.eazybytes.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.IAccountService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountsController {

   
    private IAccountService iAccountService;
    
/*************  ✨ Codeium Command ⭐  *************/
    /**
     * Create a new account.
     *
     * @param customerDTO the customerDTO object for new account creation
     * @return ResponseEntity object with status code 201 and responseDTO
     *         object
     */
/******  144efb64-4364-49d2-9755-3e9fd074595d  *******/
    @PostMapping("/create")
public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO){

    iAccountService.createAccount(customerDTO);
    return ResponseEntity
    .status(HttpStatus.CREATED)
    .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
}

@GetMapping("/fetch")
public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam  @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Mobile number must be 10 digits") String mobileNumber){
CustomerDTO customerDTO=iAccountService.fetchAccount(mobileNumber);
return ResponseEntity.status(HttpStatus.OK).body(customerDTO);

}




/*************  ✨ Codeium Command ⭐  *************/
/**
 * Updates account details for a given customer.
 *
 * @param customerDTO The customer data transfer object containing updated account details.
 * @return A ResponseEntity containing a ResponseDTO with the status and message of the update operation.
 *         Returns HTTP 200 OK if the update was successful, otherwise returns HTTP 500 Internal Server Error.
 */

/******  32e28f7c-81d2-4e5a-bbda-03f436de4c8c  *******/
@PutMapping("/update")
public ResponseEntity<ResponseDTO> updateAccount(@Valid @RequestBody CustomerDTO customerDTO){
    boolean isUpdated=iAccountService.updateAccount(customerDTO);
    if(isUpdated){
        return ResponseEntity
       .status(HttpStatus.OK)
       .body(new ResponseDTO(AccountsConstants.status_200, AccountsConstants.MESSAGE_200));
    }else{
        return ResponseEntity
       .status(HttpStatus.INTERNAL_SERVER_ERROR)
       .body(new ResponseDTO(AccountsConstants.status_500, AccountsConstants.MESSAGE_500));    }

}

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Mobile number must be 10 digits") String mobileNumber){
   boolean isDeleted=iAccountService.deleteAccount(mobileNumber);
   if(isDeleted){
    return ResponseEntity
    .status(HttpStatus.OK)
    .body(new ResponseDTO(AccountsConstants.status_200, AccountsConstants.MESSAGE_200));
   }else{
    return ResponseEntity
    .status(HttpStatus.INTERNAL_SERVER_ERROR)
    .body(new ResponseDTO(AccountsConstants.status_500, AccountsConstants.MESSAGE_500)); 
   }
  }

}