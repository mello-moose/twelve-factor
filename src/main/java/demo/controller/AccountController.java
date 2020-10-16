package demo.controller;

import demo.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import demo.service.AccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping(value = "/accounts")
public class AccountController {
    @Resource
    AccountService accountService;
    @GetMapping
    ResponseEntity<Page<Account>> get(Pageable pageable) {
        return ResponseEntity.ok(accountService.get(pageable));
    }
    @PostMapping
    ResponseEntity<Account> post(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.create(account));
    }
    @PutMapping(value = "/{id}")
    ResponseEntity<Account> put(@PathVariable("id") Long id, @RequestBody Account account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        accountService.delete(id);
        return ResponseEntity.ok().build();
    }
}
