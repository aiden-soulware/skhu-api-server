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
    Member.findAll() as List
  }
}
