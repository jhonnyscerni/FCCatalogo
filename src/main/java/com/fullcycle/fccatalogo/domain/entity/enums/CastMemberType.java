package com.fullcycle.fccatalogo.domain.entity.enums;

import java.util.HashMap;
import java.util.Map;

public enum CastMemberType {
    TYPE1(1),
    TYPE2(2);

    private final Integer type;
    private static final Map<Integer, CastMemberType> values = new HashMap<>();

    CastMemberType(Integer type) {
        this.type = type;
    }

    static {
        for (CastMemberType type : CastMemberType.values()) {
            values.put(type.type, type);
        }
    }

    public Integer getType() {
        return this.type;
    }

    public static Boolean valueOf(CastMemberType type) {
        CastMemberType castMemberType = values.get(type.type);
        return castMemberType != null;
    }

}
