package kr.soulware.skhuapi.service

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import org.springframework.stereotype.Service

@Slf4j
@Transactional
//create error
@Service
class JunMemberService {

    List getList() {

        Member.findAll() as List
    }

    Member getListDeatail(long id) {
        Member.get(id) as Member
    }
    Member SaveListPost(Member member){
        Member createObj = new Member(member)
        createObj.save()
    }

    Member deleteById(long id) {
        def deleteObj = Member.get(id)
        deleteObj.delete()
    }


}