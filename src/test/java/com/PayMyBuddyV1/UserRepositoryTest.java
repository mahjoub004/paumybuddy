package com.PayMyBuddyV1;

import com.PayMyBuddyV1.model.Account;
import com.PayMyBuddyV1.model.Connection;
import com.PayMyBuddyV1.model.User;
import com.PayMyBuddyV1.repository.UserRepository;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;



@Data
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private TestEntityManager entityManager ;



    @Test
    public void testCreationUser(){
        PasswordEncoder passwordEncoder = new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return null;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return false;
            }
        };
        User us1 = new User();
        User us2 = new User();
        User user = new User();
        user.setEmail("monique-fred@yahoo.fr");
        user.setFirstName("monique");
        user.setLastName("fred");
        user.setPassword(passwordEncoder.encode("fred2020"));
       // user.setAccount(new Account(1,200.12 , "IBN123434"));

 User savedUser = userRepository.save(user);
 User existUser = entityManager.find(User.class , savedUser.getId());
 Assertions.assertThat(existUser.getEmail().equals(user.getEmail()));

    }
}
