package com.helpingoldies.domain.groceries;

import java.util.UUID;

class Owner {

    private final UUID id;

    static Owner buildOwner(UUID ownerID) {
        return new Owner(ownerID);
    }

    static Owner rebuildOwner(UUID id) {
        return new Owner(id);
    }

    public Owner() {
        this(null);
    }

    private Owner(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }


}
