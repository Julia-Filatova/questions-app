package models.entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Yuliia_Filatova on 9/7/2016.
 */
@Entity
@Table(name="users")
public class User extends AbstractEntity{

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
