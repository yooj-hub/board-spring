package study.board.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.board.domain.Bulletin;

import java.util.List;

public interface BulletinRepository extends JpaRepository<Bulletin, Long> {

    @Query("select b from Bulletin b where b.subject like %:subject%")
    List<Bulletin> findAllBySubject(@Param("subject") String subject);

}
