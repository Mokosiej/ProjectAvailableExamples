package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserProfile {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}