package green.guemjjoki.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.lang.reflect.Member;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@EntityListeners(AutoCloseable.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoBoard {

    @Builder
    public TodoBoard(String title, String content,Member member){
        this.title = title;
        this.content = content;
        this.writer = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @Column(length = 15, nullable = false)
    private Member writer;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;
}
