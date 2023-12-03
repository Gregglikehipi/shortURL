package HAYE.demo.data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique=true)
    private String name;

    private String pass;

    public Person() {
    }

    public Person(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
