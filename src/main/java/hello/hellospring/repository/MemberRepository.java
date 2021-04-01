package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //회원을 저장소에 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금껏 저장된 모든 회원 리스트 반환환
    //Optional: 가져온 값이 없으면(null) optional로 감싸서 반환
}
