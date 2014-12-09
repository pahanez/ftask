package com.pahanez.famtask.data.enity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by pindziukou on 09.12.14.
 */
public class GroupEntity implements IdentifiedEntity{

    private String mGroupId;
    private String mGroupName;
    private Collection<String> mGroupMembersIds = Collections.EMPTY_LIST;




    @Override
    public String getID() {
        return mGroupId;
    }

    public void setGroupId(String mGroupId) {
        this.mGroupId = mGroupId;
    }

    public String getGroupName() {
        return mGroupName;
    }

    public void setGroupName(String mGroupName) {
        this.mGroupName = mGroupName;
    }

    public Collection<String> getGroupMembersIds() {
        return mGroupMembersIds;
    }

    public void setGroupMembersIds(Collection<String> mGroupMembersIds) {
        this.mGroupMembersIds = mGroupMembersIds;
    }
}
