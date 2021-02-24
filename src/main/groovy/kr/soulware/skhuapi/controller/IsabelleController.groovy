package kr.soulware.skhuapi.controller

import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import kr.soulware.skhuapi.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
@RestController
class IsabelleController {

    @Resource
    MemberService memberService

    @GetMapping(value = "/api/users")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    def list(@RequestParam(value="page", defaultValue = "1") Integer page,
             @RequestParam(value="max", defaultValue = "6") Integer max  ) {
        def listData = memberService.getList([page:page, max:max])
        def result = [page: page]
        result.putAll(listData)
        result
    }

    @GetMapping(value = "/api/users/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    def matchlist(@PathVariable("id") long id) {
        def member = memberService.getMember(id).toData()
        [page: id, data: member]
    }


    @GetMapping(value = "/api/unique/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    boolean vuelidateMember(@PathVariable("username") String username) {
        log.info(username)
        boolean check = memberService.isUnique(username)
        return check
    }

    @PostMapping(value = "/api/users")
    @ResponseStatus(value = HttpStatus.OK)
    Long userPost(@RequestBody Map data) {
        /*  if(!data.containsKey('id')) {
            data.id = "13"
          }*/
        Long createdId = memberService.createMember(data)
        log.info("createdId {}", createdId)
        return createdId
    }

    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    Void delete(@PathVariable("id") long id) {
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@createMember {}", id)
        Long deleteId = memberService.deleteMember(id)
        log.info("~~~~~~~~~~~deleteId {}", deleteId)
    }
    @PutMapping("/api/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    Long edit(@PathVariable("id") Long id, @RequestBody Map data) {
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@editUser {}, {}", id, data)
        Long updateId = memberService.editUser(id, data)
        return updateId
    }
    /*
    @PostMapping(value = "/api/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    Long loginUser(@PathVariable("id") long id) {
        Long loginId = memberService.loginMember(id)
        log.info("createdId {}", loginId)
        return loginId
    }
     */

}
