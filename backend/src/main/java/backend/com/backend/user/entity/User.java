package backend.com.backend.user.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

import backend.com.backend.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String full_name;
    @Column(nullable = false)
    private String display_name;
    @Column(nullable = false, updatable = false)
    private String password;
    @Column(updatable = false)
    private String location;
    private int total_questions;
    private int total_answers;
    private UserStatus user_status = UserStatus.USER_ACTIVE;
    public enum UserStatus{
        USER_ACTIVE("활동 중"),
        USER_SLEEP("휴면 상태"),
        USER_QUIT("탈퇴 상태");
        @Getter
        private String statusDesciption;

        UserStatus(String statusDesciption) {
            this.statusDesciption = statusDesciption;
        }
    }
}