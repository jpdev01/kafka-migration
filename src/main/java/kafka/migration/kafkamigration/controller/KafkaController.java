package kafka.migration.kafkamigration.controller;

import kafka.migration.kafkamigration.integration.TopicProducer;
import kafka.migration.kafkamigration.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final CustomerService customerService;
    private final TopicProducer topicProducer;

    @GetMapping("/save")
    public void save() {
        System.out.println("---> Starting synchronous data load at " + Instant.now());
        customerService.loadData();
        System.out.println("---> Synchronous data load completed at " + Instant.now());
    }
}