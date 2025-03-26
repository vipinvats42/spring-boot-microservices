package com.eazybytes.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDTO;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyException;
import com.eazybytes.accounts.exception.ResourceNotfoundexception;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
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
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
       Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber()); 
        
       if(optionalCustomer.isPresent()){
        throw new CustomerAlreadyException("Customer already registered with mobile number "+customerDTO.getMobileNumber());
       }

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");

        Customer savedCustomer=customerRepository.save(customer);

        accountsRepository.save(createNewAccount(savedCustomer));
    }


    private Accounts createNewAccount(Customer customer) {
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L+new Random().nextInt(900000000);

        newAccounts.setAccountNumber(randomAccountNumber);
        newAccounts.setAccountType(AccountsConstants.SAVINGS);
        newAccounts.setBranchAddress(AccountsConstants.ADDRESS);
        newAccounts.setCreatedAt(LocalDateTime.now());
        newAccounts.setCreatedBy("Anonymous");
        return newAccounts;

    }


/*************  ✨ Codeium Command ⭐  *************/
    /**
     * This method takes mobile number as input and return the customer details
     * @param mobileNumber
     * @return
/******  74003ea9-2c7f-4fcc-a2ea-b01f7bd6aafc  *******/
    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
     Customer customer=  customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
        ()-> new ResourceNotfoundexception("customer", "mobileNumber", mobileNumber)
     );

     Accounts accounts=  accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
        ()-> new ResourceNotfoundexception("Account", "customerId", customer.getCustomerId().toString())
     );

    CustomerDTO customerDTO= CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());  
    customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDTO(accounts, new AccountsDTO()));

    return customerDTO;

    }


    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpated= false;
        AccountsDTO accountsDTO =customerDTO.getAccountsDTO();
        if(accountsDTO!=null){
            Accounts accounts = accountsRepository.findById(accountsDTO.getAccountNumber())
            .orElseThrow(
                ()-> new  ResourceNotfoundexception("Account", "AccountNumber", String.valueOf(accountsDTO.getAccountNumber())));
            

            AccountsMapper.mapToAccounts(accountsDTO, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId= accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotfoundexception("customer", "customerId", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO, customer);
            customerRepository.save(customer);
            isUpated=true; 
        }
        return isUpated;
    }


    @Override
    public boolean deleteAccount(String mobileNumber) {
      Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
          ()-> new ResourceNotfoundexception("customer", "mobileNumber", mobileNumber)
      );
      accountsRepository.deleteByCustomerId(customer.getCustomerId());
      customerRepository.deleteById(customer.getCustomerId());
      return true;
    }
    
}
