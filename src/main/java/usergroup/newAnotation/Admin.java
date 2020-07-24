package usergroup.newAnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Scope(value = "prototype")
public class Admin {

    @Username(name =  "admin")
    private String username;

    public Admin() {
        System.out.println(username);
    }

    @PostConstruct
    void init() {
        System.out.println(username);
    }

    @Timer
    public void say(){
        System.out.println(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
