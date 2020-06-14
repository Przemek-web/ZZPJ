package pl.lodz.p.it.insta.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.it.insta.exceptions.ResourceNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WithMockUser(username = "ObiKenobi14", password = "Duch123")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test(expected = ResourceNotFoundException.class)
    public void findByUsernameExceptionTest() {
        accountService.findByUsername("NieMa");
    }

    //TODO po poprawce
    @Test
    public void editUserTest() {

    }

    @Test
    public void editUserExceptionTest() {

    }
}