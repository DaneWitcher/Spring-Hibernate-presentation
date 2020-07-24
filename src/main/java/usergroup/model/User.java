package usergroup.model;

import lombok.*;
import usergroup.newAnotation.Username;

import javax.annotation.PostConstruct;
import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;

    private String password;



//    public User() {
//    }
//
//    public User(long id, String name, String password) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id == user.id &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, password);
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
