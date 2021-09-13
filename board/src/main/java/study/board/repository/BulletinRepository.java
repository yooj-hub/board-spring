package study.board.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.board.domain.Bulletin;
import study.board.web.BulletinListDtoV2;

import java.util.List;

public interface BulletinRepository extends JpaRepository<Bulletin, Long> {

    @Query("select b from Bulletin b where b.subject like %:subject%")
    List<Bulletin> findAllBySubject(@Param("subject") String subject);

    @Query("select new study.board.web.BulletinListDtoV2(b.id,b.subject,b.author) from Bulletin b order by b.id desc ")
    List<BulletinListDtoV2> findAllByBulletinListDto();

}
