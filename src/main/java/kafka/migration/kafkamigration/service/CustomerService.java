package kafka.migration.kafkamigration.service;

import jakarta.transaction.Transactional;
import kafka.migration.kafkamigration.domain.Customer;
import kafka.migration.kafkamigration.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final int batchSize = 100000;

    public void loadData() {
        for (int i = 0; i <= batchSize; i++) {
            customerRepository.save(buildCustomer(i));
        }
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    private Customer buildCustomer(int index) {
        return Customer.builder()
                .name("CUSTOMER_" + index)
                .rollNo(index + 1)
                .standard((index + 1) % 10)
                .build();
    }
}
