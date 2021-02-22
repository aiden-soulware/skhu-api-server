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
    Map getList(Integer pageNum) {
        Integer max = 6
        Integer offset = (pageNum * max) - max
        def total = Member.count()
        Integer total_pages = Math.ceil(total / max)
        def listObj = Member.findAll(offset: offset, max: max).collect().collect {
            it.toData()
        } as List
        log.info("totalpage : {}", total_pages)
        [data: listObj, total_pages: total_pages] as Map

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

    boolean validationsCheck(String username) {
        Member.countByUsername(username) == 0
        // log.info("username" + username)
//        def nameQuery = Member.findAllByUsername(username)
//        log.info(nameQuery.username + "이름")
        // select count(*) from user where username = ?
        // def count = Member.countByUsername(username)
        //  log.info("count : {}", count)
        //if (Member.findAllByUsername(username)) {
        //!(count > 0)
        /*if(count > 0) {
            log.info("문자열 있음")
            return false
        } else {
            return true
        }*/
        // return true

    }


}