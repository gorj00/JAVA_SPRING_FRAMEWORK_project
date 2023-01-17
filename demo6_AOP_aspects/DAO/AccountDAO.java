package demo6_AOP_aspects.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING DB WORK: Adding an ACCOUNT");
    }
}
