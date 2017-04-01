package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.Groups;

public interface ServiceGroups {
    Iterable<Groups> listAllGroups();

    Groups saveGroups(Groups groups);

    void deleteGroups(long id);

    Groups getGroupsById(long id);
}
