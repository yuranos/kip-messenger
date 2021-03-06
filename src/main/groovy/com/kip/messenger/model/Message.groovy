package com.kip.messenger.model

import groovy.transform.TupleConstructor
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.ZonedDateTime

/**
 * Created by yuranos on 9/21/17.
 */
@TupleConstructor
@Entity
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id

    String message
    String author
}
