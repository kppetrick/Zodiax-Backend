package runner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner.entities.Account;
import runner.services.AccountServices;
import java.util.List;
import java.util.Optional;

@RequestMapping("/myaccount")
@RestController
public class AccountController {
    @Autowired
    AccountServices accountServices;

    @RequestMapping("/test")
    public String test() {
        return "Test Test Test";
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Account> create(@RequestBody Account account)  {
        return new ResponseEntity<>(accountServices.create(account), HttpStatus.CREATED);
    }
    @PostMapping("/get/{username}")
    public ResponseEntity<Account> getAccount(@PathVariable String username)  {
        return new ResponseEntity<>(accountServices.getAccount(username), HttpStatus.OK);
    }
    @PostMapping("/getall")
    public ResponseEntity<List<Account>> getAllAccounts()  {
        return new ResponseEntity<>(accountServices.getAllAccounts(), HttpStatus.OK);
    }
    @PostMapping("/ratingabove/{rating}")
    public ResponseEntity<List<Account>> getAllRatedGreater(@PathVariable Integer rating){
        return new ResponseEntity<>(accountServices.getAllRatedGreater(rating), HttpStatus.OK);
    }
    @PostMapping("/ratingbelow/{rating}")
    public ResponseEntity<List<Account>> getAllRatedBelow(@PathVariable Integer rating){
        return new ResponseEntity<>(accountServices.getAllRatedBelow(rating), HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Optional<Account>> update(@RequestBody Account account, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(accountServices.updateAccount(id,account), HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        accountServices.delete(id);
    }
}
