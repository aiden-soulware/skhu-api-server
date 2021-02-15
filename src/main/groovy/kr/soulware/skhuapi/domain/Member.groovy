package kr.soulware.skhuapi.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString
import kr.soulware.skhuapi.domain.auth.User
import org.grails.datastore.gorm.GormEntity

@ToString(includeNames = true, includePackage = false, includeSuper = true, includes = ['nick'])
@Entity
class Member extends User implements GormEntity<Member> {
  String nick

  static constraints = {
    nick nullable: true
  }

  static mapping = {
    nick length: 100
    version false
  }

  Map<String, Object> toData() {
    [id             : id,
     username       : username,
     dateCreated    : dateCreated,
     nick           : nick,
    ] as Map<String, Object>
  }
}
