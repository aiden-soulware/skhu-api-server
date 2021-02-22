package kr.soulware.skhuapi

import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.service.MemberService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@Slf4j
@SpringBootTest
class SkhuapiApplicationTests {
    @Resource

    @Resource
    MemberService memberService

    @Test
    void contextLoads() {
        def data = [email     : "kim41900@naver.com",
                    first_name: "k",
                    last_name : "i",
                    nick      : "u",
                    password  : "w",
                    username  : "ki"]

        Long id = memberService.editUser(data, id)
        log.info("Long {}@@@@@@@@@@@", id)
        def member = memberService.getMember(id)
        log.info("id {}@@@@@@@@@@@", member)
    }


    @Test
    void valindationCheckTest(){

    }


}