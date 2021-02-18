package kr.soulware.skhuapi.service

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import kr.soulware.skhuapi.domain.auth.UserRole
import org.springframework.stereotype.Service

@Slf4j
@Transactional

//create error
@Service
class JunMemberService {
    //All Map params 추가 해서 사용
    List getList(Map params) {

        //params.offset
        //params.max
        //def params = [offset : 0, max:6, keyworkd:'test']

        Member.findAll() as List
    }
    //detail
    Member getListDeatail(long id) {

        Member.get(id) as Member


    }
    // list create
    Member saveListPost(Member member) {

        Member createObj = new Member(username: member.username, password: '12341234', nick: '오른쪽', "email": member.email, "first_name": member.first_name, "last_name": member.last_name, "avatar": member.avatar)
        if (createObj.validate()) {
            createObj.save()
        } else {
            throw new IllegalArgumentException(createObj.errors.allErrors.toString())
        }
    }

//    Long saveListPost(Map data) {
//
//        Member createObj = new Member(data)
//        if(createObj.validate()) {
//            createObj.save()
//        }else {
//            throw new IllegalArgumentException(createObj.errors.allErrors.toString())
//        }
//
//        createObj.id
//    }

    Member deleteById(long id) {
        def roles = UserRole.findAllByUser(Member.get(id))
        roles.each {
            it.delete()
        }
        Member deleteObj = Member.get(id)
        log.info((deleteObj.email))
        deleteObj.delete()
    }

    Member updateList(data, id) {

        def obj = Member.get(id)
        obj.username = data.username
        obj.email = data.email
        obj.first_name = data.first_name
        obj.last_name = data.last_name
        obj.avatar = data.avatar

//        obj.setData(data)

        //obj = member
        obj.save()

    }


}