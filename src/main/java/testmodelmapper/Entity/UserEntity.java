package testmodelmapper.Entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "status")
    private boolean status;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
