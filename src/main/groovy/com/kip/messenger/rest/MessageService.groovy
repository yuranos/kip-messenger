package com.kip.messenger.rest

import com.kip.messenger.model.Message
import com.kip.messenger.model.MessageResponse
import groovy.transform.TupleConstructor
import org.springframework.stereotype.Service

import java.util.regex.Matcher

/*
//    http://mrhaki.blogspot.com/2009/09/groovy-goodness-matchers-for-regular.html
//    https://stackoverflow.com/questions/9845133/match-variable-occurrences-in-a-text-using-regex
//    http://www.groovyconsole.appspot.com/script/23002
 */
@Service
@TupleConstructor
@Newify(MessageResponse)
class MessageService {
    private def taskMatcher = { it =~ /((?<invitation>.*meet)(?<time>.*))/ }
    private def portraitMatcher = { it =~ /((.*)(?<verb>love|.*adore|.*idolize|.*worship|.*like|.*prefer|.*hate)(?<object>.*))/ }

    def processMessage(Message message) {
        def match
        if ((match = taskMatcher(message.message)).matches()) {
            buildTask(message, match, TaskType.TASK)
        } else if ((match = portraitMatcher(message.message)).matches()) {
            buildPortrait(message, match, TaskType.PORTRAIT)
        } else {
            "Sorry, can't process this message"
        }
    }


    static def buildTask(Message message, def match, TaskType taskType) {
        MessageResponse taskResponse = MessageResponse()
        taskResponse.with {
            type = taskType.toString().toLowerCase()
            output = "Meet with $message.author${match.group('time')}"
            keys = [startIndex: match.start("time") + 1, endIndex: match.end("time"), type: 'time']
        }
        taskResponse

    }

    static def buildPortrait(Message message, def match, TaskType taskType) {
        MessageResponse portraitResponse = MessageResponse()
        portraitResponse.with {
            type = taskType.toString().toLowerCase()
            output = "${match.group('verb').capitalize()}s${match.group('object')}"
        }
        portraitResponse
    }
}
