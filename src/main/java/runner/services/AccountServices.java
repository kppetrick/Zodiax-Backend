package runner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import runner.entities.Account;
import runner.repositories.AccountRepo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountServices {
    private final static Logger loggerService = Logger.getLogger(AccountServices.class.getName());

    @Autowired
    AccountRepo accountRepo;

    public List<Account> getAllAccounts(){
        return  accountRepo.findAll();
    }
    public Account getAccount(String username){
        loggerService.log(Level.INFO, "Retriving " + username + " to be displayed");
        return accountRepo.findAccountByUsername(username);
    }
    @Query
    public List<Account> getAllRatedGreater(Integer rating){
        loggerService.log(Level.INFO, "All ratings above " + rating + " being displayed");
        return accountRepo.findAccountByRatingGreaterThan(rating);
    }
    @Query
    public List<Account> getAllRatedBelow(Integer rating){
        loggerService.log(Level.INFO, "All ratings below " + rating + " being displayed");
        return accountRepo.findAccountByRatingLessThan(rating);
    }
    public Account create(Account account) {
        loggerService.log(Level.INFO, "Account being created");
       return accountRepo.save(account);
    }
    public Optional<Account> updateAccount(Long id, Account account) throws Exception{
        loggerService.log(Level.INFO, "Account update initiated" + id);
        if (accountRepo.existsById(id) == true) {
            loggerService.log(Level.INFO, "Account exists being updated" + id);
            Account current = accountRepo.findAccountById(id);
            current.setUsername(account.getUsername());
            current.setPassword(account.getPassword());
            accountRepo.save(current);
            return Optional.of(current);
        }
        loggerService.log(Level.WARNING, "Account does not exist.");
        throw new Exception("Account does not exist");
    }
    public void delete(Long id) {
        loggerService.log(Level.INFO, "Account being deleted: " + accountRepo.findAccountById(id).getUsername());
        accountRepo.delete(accountRepo.findAccountById(id));
    }

}
