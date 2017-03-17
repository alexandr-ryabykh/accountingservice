package org.mainacad.accGoods.service;

import org.mainacad.accGoods.model.Stuff;

/**
 * Created by Fujitsu on 05.03.2017.
 */
public interface StuffService {

    public void saveStuff(Stuff good);

    public void deleteStuff(int id);

    public Stuff getStuff(int id);

    public Iterable<Stuff> listStuff();
}
