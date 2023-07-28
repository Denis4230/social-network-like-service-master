package kata.academy.eurekalikeservice.repository;

import kata.academy.eurekalikeservice.model.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

    boolean existsByIdAndCommentIdAndUserId(Long commentLikeId, Long commentId, Long userId);

    boolean existsByCommentIdAndUserId(Long commentId, Long userId);

    @Query("""
            SELECT cl.id
            FROM CommentLike cl
            WHERE cl.commentId = :commentId
                                """)
    List<Long> findAllIdsByCommentId(Long commentId);

    Optional<CommentLike> findByIdAndCommentIdAndUserId(Long commentLikeId, Long commentId, Long userId);

    int countByCommentIdAndPositive(Long commentId, Boolean positive);
}
