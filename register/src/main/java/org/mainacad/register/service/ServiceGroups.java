package org.mainacad.register.service;

import org.mainacad.register.domain.Groups;

/**
 * Created by genich on 27.03.17.
 */

public interface ServiceGroups {
    Iterable<Groups> listAllGroups();

    Groups saveGroups(Groups groups);

    void deleteGroups(long id);

    Groups getGroupsById(long id);
}
