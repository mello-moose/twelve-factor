package demo.service;

import com.github.javafaker.Faker;
import demo.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import demo.repository.AccountRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class AccountService {
    private static String INSTANCE_NAME = new Faker().funnyName().name();
    @Resource
    AccountRepository accountRepository;
    @Transactional
    public Page<Account> get(Pageable pageable) {
        Page<Account> accountPage = accountRepository.findAll(pageable);
        return accountPage;
    }
    @Transactional
    public Account create(Account account) {
        account.setInstanceName(INSTANCE_NAME);
        return accountRepository.save(account);
    }
    @Transactional
    public Account update(Long id, Account account) {
        account.setId(id);
        account.setInstanceName(INSTANCE_NAME);
        return accountRepository.save(account);
    }
    @Transactional
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
