package com.example.streamapp1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
//@EnableBinding(Processor.class)
//@EnableRxJavaProcessor
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(App1.class);

    /*
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload){
        logger.info("Received: "+payload);
        return "From Input Channel Return - "+payload;
    }
    */

    /*
    @ServiceActivator(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
    public Object receiveFroInput(Object payload){
        logger.info("Received: "+payload);
        return "From Input Channel Return - "+payload;
    }
    */

    @Bean
    public RxJavaProcessor<String,String> processor(){
        /*
        return inputStream -> inputStream.map(data->{
            logger.info("Received: "+ data);
            return data;
        }).map(data->String.valueOf("From Input Channel Return - "+data));
        */
        return inputStream -> inputStream.map(data->{
            logger.info("Received: "+data);
            return data;
        }).buffer(5).map(data->String.valueOf("From Input Channel Return - "+data));
    }
}
