package liga.medical.medicalmonitoring.core.antiSOLID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import liga.medical.medicalmonitoring.core.domain.MessageType;

@RestController
@Getter
@Setter
@RequiredArgsConstructor
public class AntiS {

    private MessageType type;

    private String messageText;

    @NonNull
    private static AmqpTemplate amqpTemplate;

    @NonNull
    private final ObjectMapper objectMapper;

    @PostMapping("/badSend")
    public void sendMessage(@RequestBody AntiS dto, String queue) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(dto);
        amqpTemplate.convertAndSend(queue,  message);
    }
}
