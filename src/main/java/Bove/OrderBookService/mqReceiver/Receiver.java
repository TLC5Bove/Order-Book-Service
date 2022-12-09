package Bove.OrderBookService.mqReceiver;

import Bove.OrderBookService.config.RabbitConfig;
import Bove.OrderBookService.model.message.IdAndExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Receiver {
    private final String setReference = "OpenIds";
    @Autowired
    RedisTemplate<String, String> template;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void listener(IdAndExchange message) {
        save(message.getId());
        System.out.println(message);
    }

    private void save(String m){
        template.opsForSet().add(setReference, m);
    }

}
