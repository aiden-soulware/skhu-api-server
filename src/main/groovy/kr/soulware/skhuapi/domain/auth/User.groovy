package kr.soulware.skhuapi.domain.auth

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@EqualsAndHashCode(includes = 'username')
@ToString(includeNames = true, includePackage = false, includes = ['username'])
@Entity
class User implements GormEntity<User>, Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    // date
    Date dateCreated
    Date lastUpdated

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
        table 'auth_user'
        password column: '`password`'
    }
}
