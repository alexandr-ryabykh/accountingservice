package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.Stuff;

public interface StuffService {

    public void saveStuff(Stuff good);

    public void deleteStuff(Long id);

    public Stuff getStuff(Long id);

    public Iterable<Stuff> listStuff();
}
