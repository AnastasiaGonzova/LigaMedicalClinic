package liga.medical.medicalmonitoring.core.service;

import liga.medical.medicalmonitoring.api.RabbitRouterService;
import liga.medical.medicalmonitoring.core.domain.QueueNames;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitRouterListener {

    @NonNull
    private final RabbitRouterService rabbitRouterService;

    @RabbitListener(queues = QueueNames.COMMON_MONITORING_QUEUE_NAME)
    public void redirectMessage(String message) {
        rabbitRouterService.routeMessage(message);
    }
}
