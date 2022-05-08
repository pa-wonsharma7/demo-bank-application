package com.example.bank.service;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(long accountId, Account account) {

        Account foundAccount = accountRepository.findById(accountId).orElseThrow();
        foundAccount.setAccountType(account.getAccountType());
        return accountRepository.save(foundAccount);
    }

    @Override
    public Account getAccount(long accountId) {

        return accountRepository.findById(accountId).orElseThrow();
    }

    @Override
    public void deleteAccount(long accountId) {

        Account foundAccount = accountRepository.findById(accountId).orElseThrow();
        accountRepository.delete(foundAccount);
    }
}
