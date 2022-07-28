package br.com.forumkotlin.controller

import br.com.forumkotlin.config.security.JwtUtil
import br.com.forumkotlin.model.Role
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Autowired
    private lateinit var jwtUtil: JwtUtil

    private lateinit var mockMvc: MockMvc

    private var token: String? = null

    companion object {
        private const val RESOURCE = "/topics/"
        private const val RESOURCE_ID = RESOURCE.plus("%s")
    }

    @BeforeEach
    fun setup() {
        token = generateToken()

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder?>(
                SecurityMockMvcConfigurers.springSecurity()
            ).build()
    }

    @Test
    fun `must return code 400 when calling service get topics without token`() {
        mockMvc.get(RESOURCE).andExpect { status { is4xxClientError() } }
    }

    @Test
    fun `must return code 200 when calling service get topics with token`() {
        mockMvc.get(RESOURCE) {
            headers { token?.let { this.setBearerAuth(it) } }
        }.andExpect { status { is2xxSuccessful() } }
    }

    @Test
    fun `must return code 200 when calling service get topic by id with token`() {
        mockMvc.get(RESOURCE_ID.format("1")) {
            headers { token?.let { this.setBearerAuth(it) } }
        }.andExpect { status { is2xxSuccessful() } }
    }

    private fun generateToken(): String {
        val authorities = mutableListOf(Role(1, "read_write"))
        return jwtUtil.generateToken("ronnie@email.com", authorities)
    }

}