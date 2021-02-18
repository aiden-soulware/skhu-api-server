package kr.soulware.skhuapi.controller.jun

import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import kr.soulware.skhuapi.service.JunMemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/jun/users")
class JunController {
    @Resource
    JunMemberService junMemberService


    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    List list(Map params) {
        junMemberService.getList().collect {

            it.toData()
        } as List
    }


    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Map listDetail(@PathVariable("id") long id) {
        junMemberService.getListDeatail(id).toData() as Map

    }


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    boolean ListPost(@RequestBody Member member) {
        log.info("뭐에요" + member.email)
        junMemberService.saveListPost(member)
        return true
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    boolean ListDelete(@PathVariable("id") int id) {
        log.info("delete")
        junMemberService.deleteById(id)
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    boolean update(@PathVariable("id") long id, @RequestBody Member member) {
        log.info("zzz" + id)
        junMemberService.updateList(member, id)
        return true;
    }


}
