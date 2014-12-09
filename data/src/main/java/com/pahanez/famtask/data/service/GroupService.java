package com.pahanez.famtask.data.service;

import com.pahanez.famtask.data.enity.GroupEntity;

/**
 * Created by pindziukou on 09.12.14.
 */
public interface GroupService {
    void createGroup(GroupEntity groupEntity, String ownerId);
    void removeGroup(String ownerId);
    void addUserToGroup(String userId);
    void removeUserFromGroup(String userId);
    void joinGroup(GroupEntity groupEntity, String memberId);
}
