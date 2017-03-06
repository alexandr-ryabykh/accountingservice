package org.mainacad.dao;

import org.mainacad.model.Stuff;

import java.util.List;

/**
 * Created by Fujitsu on 05.03.2017.
 */
public interface StuffDao {

    public void addStuff(Stuff good);
    public void deleteStuff(int id);
    public void updateStuff(Stuff stuff);
    public Stuff getStuff(int id);
    public List<Stuff> listStuff();

}