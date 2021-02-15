package kr.soulware.skhuapi.controller

import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

@Slf4j
@RestController
class MemberController {

  @Resource
  MemberService memberService

  @GetMapping(value = "/members")
  @ResponseBody
  @ResponseStatus(value = HttpStatus.OK)
  List list() {
    memberService.getList().collect {
      it.toData()
    } as List
  }
}
