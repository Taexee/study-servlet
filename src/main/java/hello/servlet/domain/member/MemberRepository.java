package hello.servlet.domain.member;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    // 싱글톤 방식
    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    // 회원 저장
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // 아이디로 회원 찾기
    public Member findById(Long id){
        return store.get(id);
    }

    // 회원 모두 조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 모두 삭제(테스트용)
    public void clearStore() {
        store.clear();
    }
}
