package com.yuranos.architecture.aws.relational

import com.yuranos.architecture.aws.rest.Message
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import javax.transaction.Transactional

/**
 * Created by yuranos on 9/21/17.
 */
interface MessageRepository extends CrudRepository<Message, Long> {
}
