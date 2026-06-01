package za.co._4tab.banking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co._4tab.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}