package com.eazybytes.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.eazybytes.accounts.entity.Accounts;

import jakarta.transaction.Transactional;

public interface AccountsRepository extends JpaRepository<Accounts,Long>{

    Optional<Accounts> findByCustomerId(long customerId);

/*************  ✨ Codeium Command ⭐  *************/
    /**
     * Deletes the account associated with the given customerId
     *
     * @param customerId
     * 
     * on custom function that are not defined in spring framework we need to add modifying and transactional 
     */
/******  fbfcf896-9965-4476-bf4b-8d206bac815e  *******/
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}