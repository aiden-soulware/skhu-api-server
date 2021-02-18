package kr.soulware.skhuapi

import groovy.util.logging.Slf4j
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@Slf4j
@SpringBootTest
class SkhuapiApplicationTests {
    @Resource
    @Test
    void contextLoads() {
        def data = [username: "test1", password: '12341234', nick: '왼쪽', "email": "george.bluth@reqres.in", "first_name": "George", "last_name": "Bluth", "avatar": "https://reqres.in/img/faces/1-image.jpg"]

        Long id = memberService.createMember(data)

        def member = memberService.getMember(id)
        log.info("id {}", id)

    }

}