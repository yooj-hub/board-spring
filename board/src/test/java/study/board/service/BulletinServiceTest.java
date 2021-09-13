package study.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.Bulletin;
import study.board.web.BulletinListDtoV2;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BulletinServiceTest {
    @Autowired
    BulletinService bulletinService;

    @Test
    void 가입_및_조회() throws Exception {
        //given
        Bulletin bulletin = new Bulletin("hello", "content");
        bulletinService.save(bulletin);
        System.out.println("bulletin = " + bulletin);
        //when
        Bulletin findBulletin = bulletinService.findOne(bulletin.getId());

        //then
        assertThat(findBulletin).isSameAs(bulletin);
    }

    @Test
    void 리스트조회() throws Exception {
        //given
        Bulletin bulletin1 = new Bulletin("hello1", "content");
        Bulletin bulletin2 = new Bulletin("hello2", "content");
        bulletinService.save(bulletin1);
        bulletinService.save(bulletin2);

        //when
        List<BulletinListDtoV2> result = bulletinService.findAll();

        //then
        assertThat(result).contains(new BulletinListDtoV2(bulletin1), new BulletinListDtoV2(bulletin2));
    }


}
