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
  def list() {
    def members = memberService.getList().collect {
      it.toData()
    } as List

    [page : 1, data : members]
  }

  @GetMapping(value = "/api/users/{id}")
  @ResponseBody
  @ResponseStatus(value = HttpStatus.OK)
  def matchlist(@PathVariable("id")long id){
    def member = memberService.getMember(id).toData()
    [page : 1, data : member]
  }


  @PostMapping(value = "api/user")
  @ResponseStatus(value = HttpStatus.OK)
  Long userPost(@RequestBody Map data){
  /*  if(!data.containsKey('id')) {
      data.id = "13"
    }*/
    Long createdId = memberService.createMember(data)
    log.info("createdId {}", createdId)
    return createdId
  }

  @DeleteMapping("/api/users/{id}")
  Map delete(@PathVariable("id") long id) {
    memberService.deleteMember(id)
    log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@createMember {}", id)
  }



}
