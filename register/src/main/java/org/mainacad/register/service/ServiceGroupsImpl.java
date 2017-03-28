package org.mainacad.register.service;

import lombok.Setter;
import org.mainacad.register.domain.Groups;
import org.mainacad.register.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by genich on 27.03.17.
 */
@Service
public class ServiceGroupsImpl implements ServiceGroups {
    @Autowired
    @Setter
    private GroupsRepository groupsRepository;

    @Override
    public Iterable<Groups> listAllGroups() {
        return groupsRepository.findAll();
    }

    @Override
    public Groups saveGroups(Groups groups) {
        return groupsRepository.save(groups);
    }

    @Override
    public void deleteGroups(long id) {
        groupsRepository.delete(id);
    }

    @Override
    public Groups getGroupsById(long id) {
        return groupsRepository.findOne(id);
    }
}
