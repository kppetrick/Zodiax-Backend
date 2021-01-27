package runner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import runner.entities.Account;
import runner.repositories.AccountRepo;

import java.util.List;

@Service
public class AccountServices {
    @Autowired
    AccountRepo accountRepo;

    public List<Account> getAllAccounts(){
        return  accountRepo.findAll();
    }
    public Account getAccount(String username){
        return accountRepo.findAccountByUsername(username);
    }
    @Query
    public List<Account> getAllRatedGreater(Integer rating){
        return accountRepo.findAccountByRatingGreaterThan(rating);
    }
    @Query
    public List<Account> getAllRatedBelow(Integer rating){
        return accountRepo.findAccountByRatingLessThan(rating);
    }
    //TODO get all accounts filter by rating >= and <= given rating

    public Account create(Account account) {
       return accountRepo.save(account);
    }
    //TODO read, update, delete
    public void delete(Long id) {
        accountRepo.delete(accountRepo.findAccountById(id));
    }

}
