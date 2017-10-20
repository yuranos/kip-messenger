package com.yuranos.architecture.aws.rest

import com.yuranos.architecture.aws.relational.MessageRepository
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
    MessageRepository messageRepository

    @GetMapping("/message/{id}")
    def getBooking(@PathVariable(required = true) int id) {
        def booking = messageRepository.findById(id)
        booking.orElse(Message())
    }

    @PostMapping("/message")
    def postBooking(@RequestBody Message message) {
        def createdMesage = messageRepository.save(message)
        ResponseEntity.ok("The message with id $createdMesage.id has been created")
    }

    @DeleteMapping("/message/{id}")
    def deleteBooking(@PathVariable(required = true) int id) {
        messageRepository.deleteById(id)
        ResponseEntity.ok("The message with id ${id} has been deleted")
    }

    @PutMapping("/message/{id}")
    def putBooking(@PathVariable(required = true) int id, @RequestBody Message booking) {
        int status = messageRepository.update(id, booking)
        if(status) {
            ResponseEntity.ok("The message with id $id has been updated")
        } else {
            ResponseEntity.notFound().build()
        }
    }

}
