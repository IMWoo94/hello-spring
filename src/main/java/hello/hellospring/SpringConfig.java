package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

   /* private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }*/
    //private  DataSource dataSource;

    //@Autowired
    //public SpringConfig(DataSource dataSource){
    //    this.dataSource = dataSource;
    //}

    @Bean
    public MemberService memberService (){
        return  new MemberService(memberRepository);
    }

/*    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository(); //Memory 를 통해서 내장 메모리 사용한 경우
        //return new JdbcMemberRepository(dataSource); //순수 jdbc h2를 통해서 사용한 경우
        //return new JdbcTemplateMemberRepository(dataSource); //JdbcTemplate 사용한 경우
        //return new JpaMemberRepository(em); //jpa를 통해 사용한 경우

    }*/
}
