package br.com.forumkotlin.mapper

import br.com.forumkotlin.controller.dto.TopicView
import br.com.forumkotlin.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView (
            id = t.id,
            title = t.title,
            message = t.message,
            creationDate = t.creationDate,
            status = t.status
        )
    }
}