package kr.ac.jejunu.user;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="userinfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;

}
