package pl.lodz.p.it.insta.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountDetailsDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
}