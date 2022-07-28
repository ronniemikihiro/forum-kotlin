package br.com.forumkotlin.mapper

import br.com.forumkotlin.dto.NewTopicForm
import br.com.forumkotlin.model.Topic
import br.com.forumkotlin.service.CourseService
import br.com.forumkotlin.service.UserForumService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userForumService: UserForumService
): Mapper<NewTopicForm, Topic> {

    override fun map(
        t: NewTopicForm
    ): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse).orElse(null),
            author = userForumService.findById(t.idAuthor).orElse(null)
        )
    }

}
