package com.fullcycle.fccatalogo.domain.entity;

import java.util.UUID;
import java.util.regex.Pattern;

public class BaseEntity {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if (id == null) throw new IllegalArgumentException("id is marked non-null but is null");
        if (Boolean.FALSE.equals(this.isValidUUID(id.toString()))) throw new IllegalArgumentException("id is marked as valid UUID but is not valid UUID");
        this.id = id;
    }

    protected UUID generateUUID(){
        this.id = UUID.randomUUID();
        return this.id;
    }

    protected Boolean isValidUUID(String _id) {
        if (_id == null) {
            return false;
        }
        Pattern UUID_REGEX_PATTERN = Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})");

        return UUID_REGEX_PATTERN.matcher(_id).matches();
    }

}
