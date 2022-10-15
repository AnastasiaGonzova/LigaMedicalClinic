package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.api.RabbitRouterService;
import liga.medical.medicalmonitoring.core.configuration.ExchangeConfiguration;
import liga.medical.medicalmonitoring.core.domain.MessageType;
import liga.medical.medicalmonitoring.core.domain.RequestMessageDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitRouterServiceImpl implements RabbitRouterService {

    @NonNull
    private final RabbitTemplate rabbitTemplate;

    @NonNull
    private final ObjectMapper objectMapper;

    @Override
    public void routeMessage(String message) {
        rabbitTemplate.setExchange(ExchangeConfiguration.DIRECT_EXCHANGE_NAME);

        try{
            RequestMessageDto messageDto = objectMapper.readValue(message, RequestMessageDto.class);
            rabbitTemplate.convertAndSend(messageDto.getMessageType().toString(), message);

        } catch(Exception e){
            rabbitTemplate.convertAndSend(MessageType.ERROR.toString(), e.getMessage());
        }
    }
}
