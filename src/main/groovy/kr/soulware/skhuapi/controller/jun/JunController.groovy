package kr.soulware.skhuapi.controller.jun

import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import kr.soulware.skhuapi.service.JunMemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

@Slf4j
//@CrossOrigin(origins = "http://localhost:8080")
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


    @GetMapping(value = "/api/jun/users/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    Map listDetail(@PathVariable("id") long id) {
         junMemberService.getListDeatail(id).toData() as Map

    }


    @PostMapping(value = "api/jun/users")
    @ResponseStatus(value = HttpStatus.OK)
    boolean ListPost(@RequestBody Member member){
        log.info("뭐에요"+member)
       junMemberService.SaveListPost(member)
        return true
    }

    @DeleteMapping("/api/jun/users/{id}")
    boolean delete(@PathVariable("id") int id) {
        junMemberService.deleteById(id)
        return true;
    }



}
