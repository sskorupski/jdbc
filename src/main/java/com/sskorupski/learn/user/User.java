package com.sskorupski.learn.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
}
