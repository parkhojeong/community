package bako.community.domain.board;

import bako.community.domain.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Board { // 게시글
    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;


}
