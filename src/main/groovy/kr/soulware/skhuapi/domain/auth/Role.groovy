package kr.soulware.skhuapi.domain.auth

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@EqualsAndHashCode(includes = 'authority')
@ToString(includes = 'authority', includeNames = true, includePackage = false)
@Entity
class Role implements GormEntity<Role>, Serializable {

  private static final long serialVersionUID = 1

  String authority

  static constraints = {
    authority nullable: false, blank: false, unique: true
  }

  static mapping = {
    table 'auth_role'
    cache true
  }
}
