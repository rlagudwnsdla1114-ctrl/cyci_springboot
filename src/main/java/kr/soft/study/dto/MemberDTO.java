package kr.soft.study.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
// @Data는 @Getter @Setter @ToString가 전부 들어있음
public class MemberDTO {
    private String userId;
    private String userPw;

}
