package org.mainacad.db.register.service;


import org.mainacad.db.register.domain.Stuff;

/**
 * Created by Fujitsu on 05.03.2017.
 */
public interface StuffService {

    public void saveStuff(Stuff good);

    public void deleteStuff(Long id);

    public Stuff getStuff(Long id);

    public Iterable<Stuff> listStuff();
}
