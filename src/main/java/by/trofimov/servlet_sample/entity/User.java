package by.trofimov.servlet_sample.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private Integer age;
    private String company;
    private String firstName;
    private String lastName;

}
