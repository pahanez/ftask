package com.pahanez.famtask.data.service.mock;

import com.pahanez.famtask.data.enity.GroupEntity;
import com.pahanez.famtask.data.service.GroupService;

import java.util.UUID;

/**
 * Created by pindziukou on 09.12.14.
 */
public class MockGroupService implements GroupService{

    private GroupEntity mGroup;

    @Override
    public void createGroup(GroupEntity groupEntity, String ownerId) {
        String id = UUID.randomUUID().toString();
        groupEntity.setGroupId(id);
        mGroup = groupEntity;
    }

    @Override
    public void removeGroup(String ownerId) {
        mGroup = null;
    }

    @Override
    public void addUserToGroup(String userId) {
        mGroup.getGroupMembersIds().add(userId);
    }

    @Override
    public void removeUserFromGroup(String userId) {
        mGroup.getGroupMembersIds().remove(userId);
    }

    @Override
    public void joinGroup(GroupEntity groupEntity,String memberId) {
        String id = UUID.randomUUID().toString();
        groupEntity.setGroupId(id);
        mGroup = groupEntity;
        mGroup.getGroupMembersIds().add(memberId);
    }
}
