package com.example.streamhello.role;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MySource.class)
public class OutputSender {

    @Autowired
    @Qualifier(MySource.OUTPUT1)
    private MessageChannel OUTPUT1;
}
