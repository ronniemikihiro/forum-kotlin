package br.com.forumkotlin.config.security

import br.com.forumkotlin.service.UserForumService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Component
class JwtUtil(
    private val userForumService: UserForumService
) {

    @Value("\${forum.jwt.secret}") private lateinit var secret: String
    @Value("\${forum.jwt.expiration}") private lateinit var expiration: String

    fun generateToken(
        username: String?,
        authorities: MutableCollection<out GrantedAuthority>
    ): String {
        val now = LocalDateTime.now()
        val expirationDate = now.plusSeconds(expiration.toLong())

        return Jwts.builder()
            .setIssuer("Fórum")
            .setSubject(username)
            .claim("role", authorities)
            .setIssuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
            .setExpiration(Date.from(expirationDate.atZone(ZoneId.systemDefault()).toInstant()))
            .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
            .compact()
    }

    @Throws(Exception::class)
    private fun parseClaimsJws(token: String?): Jws<Claims?>? {
        return Jwts.parser()
            .setSigningKey(secret.toByteArray())
            .parseClaimsJws(token)
    }

    fun isValidToken(token: String?): Boolean {
        return try {
            parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAuthentication(token: String?): Authentication {
        val username = parseClaimsJws(token)?.body?.subject
        val userForum = userForumService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(username, null, userForum.authorities)
    }

}