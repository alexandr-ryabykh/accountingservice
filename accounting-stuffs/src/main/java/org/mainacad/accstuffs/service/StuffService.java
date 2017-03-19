package org.mainacad.accstuffs.service;

import org.mainacad.accstuffs.model.Stuff;

/**
 * Created by Fujitsu on 05.03.2017.
 */
public interface StuffService {

    public void saveStuff(Stuff good);

    public void deleteStuff(Long id);

    public Stuff getStuff(Long id);

    public Iterable<Stuff> listStuff();
}
