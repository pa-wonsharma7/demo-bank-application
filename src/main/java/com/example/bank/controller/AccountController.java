package com.example.bank.controller;

import com.example.bank.entity.Account;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class AccountController {

  @Autowired private AccountService accountService;

  @PostMapping
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {

    return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Account> accountById(@PathVariable(name = "id") long accountId) {

    return ResponseEntity.ok(accountService.getAccount(accountId));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Account> updateAccountType(@PathVariable(name = "id") long accountId, @RequestBody Account account) {

      return new ResponseEntity<>(accountService.updateAccount(accountId, account), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<String> deleteAccount(@PathVariable(name = "id") long accountId) {

      accountService.deleteAccount(accountId);
      return new ResponseEntity<>("Post with ID" + accountId + "deleted successfully", HttpStatus.OK);
  }
}
