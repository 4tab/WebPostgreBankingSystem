package za.co._4tab.banking;

//4tab on git , package names can not start with int types
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApp {

    public static void main(String[] args) {
        SpringApplication.run(BankingApp.class, args);
    }
}