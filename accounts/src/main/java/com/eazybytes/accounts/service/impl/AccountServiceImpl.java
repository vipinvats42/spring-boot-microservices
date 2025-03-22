package com.eazybytes.accounts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountService;

import lombok.AllArgsConstructor;
/**
 * when there is a single constructor in any class just add 
 * @AllArgsConstructor no need to manually add @Autowired.
 */


@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

   
     private AccountsRepository accountsRepository;

    
     private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDTO customerDTO) {
        
    }
    
}
