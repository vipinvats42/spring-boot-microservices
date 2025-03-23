package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountService {
    
    
    /**
     * createAccount
     * @param customerDTO - customer DTO ovject
     */
    
    void createAccount(CustomerDTO customerDTO);

    
    
    /**
     * @param mobileNumber
     * @return
     */
    CustomerDTO fetchAccount(String mobileNumber);
}
