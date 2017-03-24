package org.mainacad.register.service;

import org.mainacad.register.domain.Grouppy;
import org.mainacad.register.domain.Teacher;
import org.mainacad.register.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by genich on 22.03.17.
 */
@Service

public class ServiceGroupImpl implements ServiceGroup {

    private GroupRepository groupRepository;

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }

    @Override
    public Iterable<Grouppy> listAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Grouppy saveGroup(Grouppy grouppy) {
        return groupRepository.save(grouppy);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.delete(id);
    }

    @Override
    public Iterable<Teacher> getTeachers() {
        return new ServiceTeacherImpl().listAllTeachers();
    }

    @Override
    public Grouppy getGroupById(Long id) {
        return groupRepository.findOne(id);
    }
}
