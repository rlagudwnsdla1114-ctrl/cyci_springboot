package kr.soft.study.api;


import kr.soft.study.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/study")
public class StudyController {

    @GetMapping("/data")
    public void data() {
        log.info("/api/study/data");

        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/post")
    public void post() {
        log.info("/api/study/post");
    }

}
