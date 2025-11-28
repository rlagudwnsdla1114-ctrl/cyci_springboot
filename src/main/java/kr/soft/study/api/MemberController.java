package kr.soft.study.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.study.dto.BoardDTO;
import kr.soft.study.dto.MemberDTO;
import kr.soft.study.mapper.MemberMapper;
import kr.soft.study.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j // logger사용할 수 있음
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public void print() {
        System.out.println("first");

        log.info("가나다");

        MemberDTO member = new MemberDTO();
        member.setUserId("가나다");
        log.info("data: {}", member);

        BoardDTO  board = new BoardDTO(5, "title", "content");

        BoardDTO  board2 = BoardDTO
                .builder()
                .idx(5)
                .title("title2")
                .content("content2")
                .build();

        log.info("data: {}", board2.toString());
    }

    @GetMapping("/data")
    public String data() {
        return "hello world";
    }

    @GetMapping("/member")
    public MemberDTO member() {
        MemberDTO member = new MemberDTO();
        member.setUserId("superman");
        member.setUserPw("123456");
        return member;
    }

    @GetMapping("/idCheck")
    public MemberDTO idCheck(HttpServletRequest request) {
        String id = request.getParameter("userId");
        //DB


        MemberDTO member = new MemberDTO();
        member.setUserId(id);

        return member;
    }

    @PostMapping("/join")
    public MemberDTO join(@RequestBody MemberDTO memberDTO) {

        return memberDTO;
    }

    @GetMapping("/test")
    public void test() {
        memberService.testConnection();
    }
}