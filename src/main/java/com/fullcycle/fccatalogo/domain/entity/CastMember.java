package com.fullcycle.fccatalogo.domain.entity;

import com.fullcycle.fccatalogo.domain.entity.enums.CastMemberType;
import java.util.UUID;

public class CastMember extends BaseEntity {
    private String name;
    private CastMemberType type;

    public CastMember() {
    }

    public CastMember(UUID id, String name, CastMemberType type) {
        super.setId(id);
        this.setName(name);
        this.setType(type);
    }

    public CastMember(String name, CastMemberType type) {
        super.generateUUID();
        this.setName(name);
        this.setType(type);
    }

    public CastMember(String name) {
        super.generateUUID();
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is marked non-null but is null");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("name is marked non-blank but is null");
        }
        this.name = name;
    }

    public CastMemberType getType() {
        return type;
    }

    public void setType(CastMemberType type) {
        if (type == null) throw new IllegalArgumentException("type is marked non-null but is null");
        if (Boolean.FALSE.equals(CastMemberType.valueOf(type))) throw new IllegalArgumentException("type is marked as valid ");
        this.type = type;
    }
}
