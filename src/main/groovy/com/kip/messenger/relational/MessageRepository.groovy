package com.kip.messenger.relational

import com.kip.messenger.model.Message
import org.springframework.data.repository.CrudRepository

/**
 * Created by yuranos on 9/21/17.
 */
interface MessageRepository extends CrudRepository<Message, Long> {
}
