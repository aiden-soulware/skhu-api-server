package kr.soulware.skhuapi.service

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import kr.soulware.skhuapi.domain.Member
import org.springframework.stereotype.Service
import kr.soulware.skhuapi.domain.auth.UserRole

@Slf4j
@Transactional
@Service
class MemberService {

    List getList(Map params) {
        Integer offset = params.offset
        Integer max = params.max
        def total = Member.count()
        def total_pages = total/max
        Member.findAll(offset : 1, max : 6) as List
    }

    Member getMember(long id) {
        Member.get(id) as Member
    }

    Long createMember(Map data) {
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!createMember {}", data)

        Member member = new Member()
        member.setData(data)

        if (member.validate()) {
            try {
                member.save()
            } catch (e) {
                log.error(e.message)
                throw new RuntimeException(e.message)
            }
        } else {
            throw new RuntimeException(member.errors.allErrors.toString())
        }
        member.save()
        return member.id
    }

    Member deleteMember(long id) {
        def roles = UserRole.findAllByUser(Member.get(id))
        roles.each {
            it.delete()
        }
        Member deleteObj = Member.get(id)
        deleteObj.delete()
    }

    Long editUser(Map data, long id) {
        Member member = new Member()
        member.get(id)
        log.info("####################{}deitMember", member.get(id))
        member.setData(data)
        member.save()
        return member.id
    }

    boolean isUnique(String username) {
        int count = Member.countByUsername(username)
        return count == 0
    }


}