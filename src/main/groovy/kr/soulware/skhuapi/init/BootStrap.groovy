package kr.soulware.skhuapi.init

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import kr.soulware.skhuapi.domain.auth.Role
import kr.soulware.skhuapi.domain.auth.User
import kr.soulware.skhuapi.domain.auth.UserRole
import org.springframework.stereotype.Service

@Slf4j
@Transactional
@Service
class BootStrap {


  void init() {
    if (Role.count == 0) {
      Role adminRole = new Role(authority: 'ROLE_ADMIN')
      adminRole.save()
      Role userRole = new Role(authority: 'ROLE_USER')
      userRole.save()
      Member temp = new Member(username: "test",password: '12341234', nick:'왼쪽', "email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth")
      temp.save()
      new UserRole(user: temp, role: userRole).save()
      Member temp2 = new Member(username: "test2",password: '12341234', nick:'오른쪽', "email":"janet.weaver@reqres.in")
      temp2.save()
      new UserRole(user: temp2, role: userRole).save()
    }
  }
}
