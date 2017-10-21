package com.yuranos.architecture.aws.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
/**
 * Created by yuranos on 9/20/17.
 */
@RestController
@Newify(Message)
class MessageController {

    @Autowired
    MessageService messageService

    @PostMapping("/process")
    def processMessage(@RequestBody Message message) {
        def messageResponse = messageService.processMessage(message)
        ResponseEntity.ok(messageResponse)
    }

}
