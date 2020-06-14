package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.lodz.p.it.insta.entities.Account;
import pl.lodz.p.it.insta.entities.Post;
import pl.lodz.p.it.insta.entities.Topic;
import pl.lodz.p.it.insta.exceptions.ResourceNotFoundException;
import pl.lodz.p.it.insta.repositories.AccountRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "username", username));
    }

    public Boolean existsByUsername(String login) {
        return accountRepository.existsByUsername(login);
    }

    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    public void editUser( Long userId, String firstName, String lastName, String email) {
        Account editedAccount = accountRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", userId));

            editedAccount.setFirstName(firstName);
            editedAccount.setLastName(lastName);
            editedAccount.setEmail(email);

            accountRepository.save(editedAccount);
    }
}
