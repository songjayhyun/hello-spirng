package hello.hellospirng.service;

import hello.hellospirng.aop.TimeTraceApp;
import hello.hellospirng.repository.JdbcMemberRepository;
import hello.hellospirng.repository.JdbcTemplateMemberRepository;
import hello.hellospirng.repository.JpaMemberRepository;
import hello.hellospirng.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;
    private DataSource dataSource;
    private final MemberRepository memberRepository;

    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//    @Bean
//    public TimeTraceApp timeTraceApp() {
//        return new TimeTraceApp();
//    }

/*
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    };
*/
}
