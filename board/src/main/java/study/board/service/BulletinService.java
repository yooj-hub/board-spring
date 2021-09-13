package study.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.Bulletin;
import study.board.repository.BulletinRepository;
import study.board.web.BulletinListDtoV2;
import study.board.web.BulletinModificationForm;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BulletinService {

    private final BulletinRepository bulletinRepository;

    @Transactional
    public Long save(Bulletin bulletin) {
        Bulletin savedBulletin = bulletinRepository.save(bulletin);
        return savedBulletin.getId();
    }

    @Transactional
    public void deleteById(Long id){
        bulletinRepository.deleteById(id);
    }


    public Bulletin findOne(Long id) {
        return bulletinRepository.findById(id).orElse(null);

    }

    public List<BulletinListDtoV2> findAll() {
        return bulletinRepository.findAllByBulletinListDto();

    }



    @Transactional
    public void updateBulletin(BulletinModificationForm form) {
        Bulletin bulletin = findOne(form.getId());
        bulletin.changeBulletin(form);
    }

    public List<BulletinListDtoV2> findAllBySubject(String subject) {
        List<BulletinListDtoV2> result = bulletinRepository.findAllBySubject(subject).stream().map(a -> new BulletinListDtoV2(a.getId(), a.getSubject(), a.getAuthor())).collect(toList());
        Collections.reverse(result);
        return result;
    }



}
