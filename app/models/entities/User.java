package models.entities;

import javax.persistence.*;

/**
 * Created by Yuliia_Filatova on 9/7/2016.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long personId;

    @Column
    private String name;

    @Column private String password;

    public User(final String name, final String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public Long getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
