package com.forum.units;

import java.util.UUID;

public abstract class AbstractEntity {
    private String id;

    public AbstractEntity() {
        this.id = autoGenerateId();
    }

    public String getId() {
        return id;
    }

    public void setId(String lastEntry) {
        this.id = lastEntry;
    }

    public String autoGenerateId() {
        return UUID.randomUUID().toString();
    }
}
