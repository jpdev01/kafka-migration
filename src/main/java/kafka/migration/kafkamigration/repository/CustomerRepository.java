package kafka.migration.kafkamigration.repository;

import kafka.migration.kafkamigration.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
