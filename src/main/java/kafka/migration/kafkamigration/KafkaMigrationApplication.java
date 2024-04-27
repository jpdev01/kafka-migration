package kafka.migration.kafkamigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMigrationApplication.class, args);
	}

}
