package bako.community.domain.board;

import bako.community.domain.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> childComments = new ArrayList<>();
}
