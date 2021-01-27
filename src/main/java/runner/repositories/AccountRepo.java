package runner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import runner.entities.Account;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findAccountById(Long id);
    Account findAccountByUsername(String username);
    List<Account> findAccountByRatingGreaterThan(Integer rating);
    List<Account> findAccountByRatingLessThan(Integer rating);
    List<Account> findAll();
}
