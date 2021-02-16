package kr.soulware.skhuapi.controller

import groovy.util.logging.Slf4j
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
}
