package kr.soulware.skhuapi.controller.jun

import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.service.JunMemberService

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@Slf4j
@RestController
class JunController {
    @Resource
    JunMemberService junMemberService

    @GetMapping(value = "/api/jun/users")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    List list() {
        junMemberService.getList().collect {
            it.toData()
        } as List
    }



    @GetMapping(value = "/api/jun/users{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    List listDetail() {
        log.info()
        junMemberService.getListDeatail()
    }

}
