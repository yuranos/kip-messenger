package com.yuranos.architecture.aws

import com.yuranos.architecture.aws.rest.Message
import com.yuranos.architecture.aws.rest.MessageService
import groovy.json.JsonOutput
import org.junit.Test

class MessageServiceTest {

    @Test
    void testTask() {
        def taskMessage = new Message()
        taskMessage.with {
            author = "Yura"
            message = "Hey, Zheka, let's meet tomorrow at 10PM"
        }

        MessageService messageService = new MessageService()
        def response = messageService.processMessage(taskMessage)
        println JsonOutput.toJson(response)
    }

    @Test
    void testPortrait() {
        def taskMessage = new Message()
        taskMessage.with {
            author = "Yura"
            message = "I really hate those stupid politics"
        }

        MessageService messageService = new MessageService()
        def response = messageService.processMessage(taskMessage)
        println JsonOutput.toJson(response)
    }
}
