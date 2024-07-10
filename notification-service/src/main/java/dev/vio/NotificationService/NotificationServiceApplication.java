package dev.vio.NotificationService;

import dev.vio.NotificationService.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotifications(OrderPlacedEvent orderPlacedEvent) {

        // se poate implementa the bussiness logic in here, cum ar fi trimiterea unui email catre cumparator ex: "comanda plasata cu succes""
        log.info("Received notification for Order -> {}", orderPlacedEvent.getOrderNumber());
    }
}
