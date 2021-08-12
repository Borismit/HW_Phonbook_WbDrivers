package models;


import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class Contact {
    String name;
    String lastname;
    String email;
    String phone;
    String address;
    String description;
}
