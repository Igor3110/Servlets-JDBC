package by.trofimov.servlet_sample.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {

    String age;
    String company;
    String firstName;
    String lastName;

}
