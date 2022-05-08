package com.example.bank.service;

import com.example.bank.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Account createAccount(Account account);

    Account updateAccount(long accountId, Account account);

    Account getAccount(long accountId);

    void deleteAccount(long accountId);


}
