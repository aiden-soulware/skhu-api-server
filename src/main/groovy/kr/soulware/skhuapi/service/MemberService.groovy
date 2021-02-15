package kr.soulware.skhuapi.service

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import org.springframework.stereotype.Service

@Slf4j
@Transactional
@Service
class MemberService {

  List getList(Map params) {
    //Integer offset = params.offset
    //Integer max = params.max
    //def total = Member.count()
    //def total_pages = total/max
    //Member.findAll(offset : 1, max : 6) as List
    Member.findAll() as List
  }
}
