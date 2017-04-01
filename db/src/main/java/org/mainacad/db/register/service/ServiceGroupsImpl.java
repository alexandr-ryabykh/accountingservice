package org.mainacad.db.register.service;

import lombok.Setter;

import org.mainacad.db.register.domain.Groups;
import org.mainacad.db.register.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
