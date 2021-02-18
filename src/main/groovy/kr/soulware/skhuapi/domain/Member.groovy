package kr.soulware.skhuapi.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString
import kr.soulware.skhuapi.domain.auth.User
import org.grails.datastore.gorm.GormEntity

@ToString(includeNames = true, includePackage = false, includeSuper = true, includes = ['nick'])
@Entity
class Member extends User implements GormEntity<Member> {
    String nick
    String email
    String first_name
    String last_name
    String avatar
    static constraints = {
        email nullable: true
        nick nullable: true
        first_name nullable: true
        last_name nullable: true
        avatar nullable: true
    }

    static mapping = {
        email length: 100
        nick length: 100
        first_name length: 100
        last_name length: 100
        avatar length: 500
        version false
    }



  void setData(data) {
    if(data.username) {
      this.username = data.username
    }
    if(data.password) {
      this.password = data.password
    }
    if(data.email) {
      this.email = data.email
    }
    if(data.first_name) {
      this.first_name = data.first_name
    }
    if(data.last_name) {
      this.last_name = data.email
    }
  }

  Map<String, Object> toData() {
    [id             : id,
     email          : email,
     first_name     : first_name,
     last_name      : last_name,
     avatar        : avatar
    ] as Map<String, Object>
  }
}
