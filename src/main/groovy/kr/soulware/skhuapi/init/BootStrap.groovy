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
      Member temp = new Member(username: "1",password: '12341234', nick:'왼쪽',"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://reqres.in/img/faces/1-image.jpg")
      temp.save()
      new UserRole(user: temp, role: userRole).save()
      Member temp2 = new Member(username: "2",password: '12341234', nick:'오른쪽',"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg")
      temp2.save()
      new UserRole(user: temp2, role: userRole).save()
      Member temp3 = new Member(username: "3",password: '12341234', nick:'오른쪽',"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://reqres.in/img/faces/3-image.jpg")
      temp3.save()
      new UserRole(user: temp3, role: userRole).save()
      Member temp4 = new Member(username: "4",password: '12341234', nick:'오른쪽', "email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://reqres.in/img/faces/4-image.jpg")
      temp4.save()
      new UserRole(user: temp4, role: userRole).save()
      Member temp5 = new Member(username: "5",password: '12341234', nick:'오른쪽',"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://reqres.in/img/faces/5-image.jpg")
      temp5.save()
      new UserRole(user: temp5, role: userRole).save()
      Member temp6 = new Member(username: "6",password: '12341234', nick:'오른쪽',"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://reqres.in/img/faces/6-image.jpg")
      temp6.save()
      new UserRole(user: temp6, role: userRole).save()
      Member temp7 = new Member(username: "7",password: '12341234', nick:'오른쪽',"email":"michael.lawson@reqres.in","first_name":"Michael","last_name":"Lawson","avatar":"https://reqres.in/img/faces/7-image.jpg")
      temp7.save()
      new UserRole(user: temp7, role: userRole).save()
      Member temp8 = new Member(username: "8",password: '12341234', nick:'오른쪽',"email":"lindsay.ferguson@reqres.in","first_name":"Lindsay","last_name":"Ferguson","avatar":"https://reqres.in/img/faces/8-image.jpg")
      temp8.save()
      new UserRole(user: temp8, role: userRole).save()
      Member temp9 = new Member(username: "9",password: '12341234', nick:'오른쪽',"email":"tobias.funke@reqres.in","first_name":"Tobias","last_name":"Funke","avatar":"https://reqres.in/img/faces/9-image.jpg")
      temp9.save()
      new UserRole(user: temp9, role: userRole).save()
      Member temp10 = new Member(username: "10",password: '12341234', nick:'오른쪽',"email":"byron.fields@reqres.in","first_name":"Byron","last_name":"Fields","avatar":"https://reqres.in/img/faces/10-image.jpg")
      temp10.save()
      new UserRole(user: temp10, role: userRole).save()
      Member temp11 = new Member(username: "11",password: '12341234', nick:'오른쪽',"email":"george.edwards@reqres.in","first_name":"George","last_name":"Edwards","avatar":"https://reqres.in/img/faces/11-image.jpg")
      temp11.save()
      new UserRole(user: temp11, role: userRole).save()
      Member temp12 = new Member(username: "12",password: '12341234', nick:'오른쪽',"email":"rachel.howell@reqres.in","first_name":"Rachel","last_name":"Howell","avatar":"https://reqres.in/img/faces/12-image.jpg")
      temp12.save()
      new UserRole(user: temp12, role: userRole).save()

    }
  }
}
