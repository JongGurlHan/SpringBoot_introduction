package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;//sequence: 0, 1,2.. key 값 생성시켜주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    //아이디는 시스템이 알이서 순차적으로 번호부여, 이름은 유저가 입력

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id))  ;
    }//null로 반환될 가능성이 있다면!

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member-> member.getName().equals(name))
                .findAny();
        //람다사용, 루프를 돌리면서 memeber.getName이 파라미터로 넘어온 name과
        //같은지 확인, 같은 경우에만 필터링, 그중 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
