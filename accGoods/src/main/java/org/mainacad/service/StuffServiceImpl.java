package org.mainacad.service;

import org.mainacad.dao.StuffDao;
import org.mainacad.model.Stuff;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Fujitsu on 05.03.2017.
 */

@Service
public class StuffServiceImpl implements StuffService {

    private StuffDao stuffDao;

    public void setStuffDao(StuffDao stuffDao) {
        this.stuffDao = stuffDao;
    }

    @Override
    @Transactional
    public void addStuff(Stuff stuff) {
        this.stuffDao.addStuff(stuff);

    }

    @Override
    @Transactional
    public void deleteStuff(int id) {
        this.stuffDao.deleteStuff(id);

    }

    @Override
    @Transactional
    public void updateStuff(Stuff stuff) {
        this.stuffDao.updateStuff(stuff);

    }

    @Override
    @Transactional
    public Stuff getStuff(int id) {
        return this.stuffDao.getStuff(id);

    }

    @Override
    @Transactional
    public List<Stuff> listStuff() {
        return this.stuffDao.listStuff();
    }
}
