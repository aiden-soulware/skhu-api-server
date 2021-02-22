package kr.soulware.skhuapi

import groovy.util.logging.Slf4j

import kr.soulware.skhuapi.service.JunMemberService
import kr.soulware.skhuapi.service.MemberService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@Slf4j
@SpringBootTest
class SkhuapiApplicationTests {

    @Resource
    MemberService memberService
    JunMemberService junMemberService
    @Test
    void contextLoads() {
        Long id = 1
        def memberOrg = memberService.getMember(id)
        log.info("memberOrg : {}", memberOrg.toData())


        def data =["email":"georg1e.bluth@reqres.in",
                   "first_name":"George1",
                   "last_name":"Bluth1",
                   "avatar":"https://reqres.in/img/faces/1-image.jpg"]

        /*Map data = [email     : "kim41900@naver.com",
                    first_name: "k",
                    last_name : "i",
                    nick      : "u",
                    password  : "w",
                    username  : "ki"]
*/
        def member = memberService.editUser(1, data)
        log.info("member{}",member)

        def memberOrg2 = memberService.getMember(id)
        log.info("memberOrg2 : {}", memberOrg2.toData())

        //log.info("Long {}@@@@@@@@@@@{}", id)
        //def member = memberService.getMember(id)
       // log.info("id {}@@@@@@@@@@@", member)
    }


    @Test
    void valindationCheckTest(){

    }


    @Test
//    void valindationCheckTest(){
//         String data = "hj"
//       M= Member.findByUsername(data)
//
//    }


}