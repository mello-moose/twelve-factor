package demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(AccountService.class);
    private static String INSTANCE_NAME = new Faker().funnyName().name();
    @Resource
    AccountRepository accountRepository;
    @Transactional
    public Page<Account> get(Pageable pageable) {
        logger.info(INSTANCE_NAME + " received a GET request.");
        Page<Account> accountPage = accountRepository.findAll(pageable);
        return accountPage;
    }
    @Transactional
    public Account create(Account account) {
        logger.info(INSTANCE_NAME + " received a POST request.");
        account.setInstanceName(INSTANCE_NAME);
        return accountRepository.save(account);
    }
    @Transactional
    public Account update(Long id, Account account) {
        logger.info(INSTANCE_NAME + " received a PUT request.");
        account.setId(id);
        account.setInstanceName(INSTANCE_NAME);
        return accountRepository.save(account);
    }
    @Transactional
    public void delete(Long id) {
        logger.info(INSTANCE_NAME + " received a DELETE request.");
        accountRepository.deleteById(id);
    }
}
