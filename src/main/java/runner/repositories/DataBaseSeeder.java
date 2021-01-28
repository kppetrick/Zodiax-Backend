package runner.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import runner.entities.Account;


@Component
public class DataBaseSeeder implements CommandLineRunner {
    @Autowired
    AccountRepo accountRepo;


    @Override
    public void run(String... args) throws Exception {
        accountRepo.deleteAll();
        accountRepo.save(new Account("Kyle", "password", 1200));
        accountRepo.save(new Account("Peter", "pass", 1000));
        accountRepo.save(new Account("Christine", "word", 1100));
        accountRepo.save(new Account("Amanda", "fml", 1050));
    }
}
