package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStrore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Woody");
        repository.save(member);
        Member test_result = repository.findById(member.getId()).get();
        assertThat(test_result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member_1 = new Member();
        member_1.setName("Buzz");
        repository.save(member_1);

        Member member_2 = new Member();
        member_2.setName("Jessie");
        repository.save(member_2);

        Member test_result = repository.findByName("Buzz").get();
        assertThat(test_result).isEqualTo(member_1);

        Member test_result_2 = repository.findByName("Jessie").get();
        assertThat(test_result_2).isEqualTo(member_2);
    }

    @Test
    public void findAll(){
        Member member_1 = new Member();
        member_1.setName("Buzz");
        repository.save(member_1);

        Member member_2 = new Member();
        member_2.setName("Jessie");
        repository.save(member_2);

        Member member_3 = new Member();
        member_3.setName("Woody");
        repository.save(member_3);

        List<Member> test_result = repository.findAll();
        assertThat(test_result.size()).isEqualTo(3);
    }
}
