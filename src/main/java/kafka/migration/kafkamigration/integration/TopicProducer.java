package kafka.migration.kafkamigration.integration;

import kafka.migration.kafkamigration.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Customer> kafkaTemplate;

    public void send(Customer customer){
        log.info("Payload enviado: {}", customer.getId());
        kafkaTemplate.send(topicName, customer);
    }

}