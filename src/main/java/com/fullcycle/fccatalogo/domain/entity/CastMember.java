package com.fullcycle.fccatalogo.domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum CastMemberType {
    TYPE1(1),
    TYPE2(2);

    private final Integer type;
    private final static Map<Integer, CastMemberType> values = new HashMap<>();

    CastMemberType(Integer type) {
        this.type = type;
    }

    static {
        for (CastMemberType type : CastMemberType.values()){
            values.put(type.type, type);
        }
    }

    public Integer getType(){
        return this.type;
    }

    public static Boolean valueOf(CastMemberType type){
        CastMemberType castMemberType = values.get(type.type);
        return castMemberType != null;
    }

}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CastMemberType getType() {
        return type;
    }

    public void setType(CastMemberType type) {
        if (type == null) throw new IllegalArgumentException("type is marked non-null but is null");
        if (!CastMemberType.valueOf(type)) throw new IllegalArgumentException("");
        this.type = type;
    }
}
