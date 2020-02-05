package com.example.streamintergration.role;

import com.example.streamintergration.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(value = {Sink.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    /*@ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received: " + payload);
    }*/

    /*@Transformer(inputChannel = Sink.INPUT,outputChannel = Sink.INPUT)
    public Object transform(Date message){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }*/

    /*
    @Transformer(inputChannel = Sink.INPUT,outputChannel = Sink.INPUT)
    public User transform(String message) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message,User.class);
        return user;
    }

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(User user){
        logger.info("Received: " + user);
    }
    */

    @StreamListener(Sink.INPUT)
    public void receive(User user){
        logger.info("Received: "+user);
    }
}
