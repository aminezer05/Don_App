package Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@KafkaListener(id = "class-level", topics = "multi-type")
class KafkaClassListener {

    @KafkaHandler
    void listenString(String message) {
        log.info("KafkaHandler [String] {}", message);
    }

    @KafkaHandler(isDefault = true)
    void listenDefault(Object object) {
        log.info("KafkaHandler [Default] {}", object);
    }
}
