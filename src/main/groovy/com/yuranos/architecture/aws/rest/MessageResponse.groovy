package com.yuranos.architecture.aws.rest

import groovy.transform.TupleConstructor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by yuranos on 9/21/17.
 */
@TupleConstructor
class MessageResponse {
    String type
    String output
    Map keys
}
