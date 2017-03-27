package org.mainacad.register.service;

import org.mainacad.register.domain.Grouppy;
import org.mainacad.register.domain.Teacher;

/**
 * Created by genich on 27.03.17.
 */
public interface ServiceGroup {
    Iterable<Grouppy> listAllGroups();

    Grouppy saveGroup(Grouppy grouppy);

    void deleteGroup(Long id);

    Grouppy getGroupById(Long id);

    Iterable<Teacher> getTeachers();
}

