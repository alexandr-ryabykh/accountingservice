package org.mainacad.db.register.service;


import org.mainacad.db.register.domain.Stuff;
import org.mainacad.db.register.repositories.StuffCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Fujitsu on 05.03.2017.
 */

@Service
public class StuffServiceImpl implements StuffService {

    private StuffCrudRepository stuffCrudRepository;


    @Autowired
    public void setStuffCrudRepository(StuffCrudRepository stuffCrudRepository) {
        this.stuffCrudRepository = stuffCrudRepository;
    }

    @Override
    @Transactional
    public void saveStuff(Stuff stuff) {
        stuffCrudRepository.save(stuff);

    }

    @Override
    @Transactional
    public void deleteStuff(Long id) {
        stuffCrudRepository.delete(id);

    }


    @Override
    @Transactional
    public Stuff getStuff(Long id) {
        return stuffCrudRepository.findOne(id);

    }

    @Override
    @Transactional
    public Iterable<Stuff> listStuff() {
        return stuffCrudRepository.findAll();
    }
}
