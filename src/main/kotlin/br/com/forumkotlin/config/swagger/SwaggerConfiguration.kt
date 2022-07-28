package br.com.forumkotlin.config.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.context.annotation.Configuration

@Configuration
@SecurityScheme(
    name = SwaggerConfiguration.BEARER_AUTH,
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
@OpenAPIDefinition(
    info = Info(
        title = "Fórum-kotlin",
        description = "API's do Fórum-kotlin",
        version = "1.0",
        contact = Contact(
            name = "Ronnie Mikihiro Sato Lopes",
            url = "https://www.linkedin.com/in/ronnie-mikihiro-sato-lopes-801432a0/",
            email = "ronnielopes@hotmail.com"),
        license = License(
            name = "Github",
            url = "https://github.com/ronniemikihiro/forum-kotlin"
        )
    )
)
class SwaggerConfiguration {

    companion object {
        const val BEARER_AUTH = "bearerAuth"
    }

}