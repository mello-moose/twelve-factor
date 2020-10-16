package demo.service;

import demo.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import demo.repository.AccountRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class AccountService {
    @Resource
    AccountRepository accountRepository;
    @Transactional
    public Page<Account> get(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
    @Transactional
    public Account create(Account account) {
        return accountRepository.save(account);
    }
    @Transactional
    public Account update(Long id, Account account) {
        account.setId(id);
        return accountRepository.save(account);
    }
    @Transactional
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
