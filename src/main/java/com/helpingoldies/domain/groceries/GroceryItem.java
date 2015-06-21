package com.helpingoldies.domain.groceries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

import java.util.Date;
import java.util.UUID;

public class GroceryItem {

    private final UUID id;
    private final String description;
    private final Owner owner;
    private final Date creatieDatum;

    public static GroceryItem buildGrocertyItem(String description, UUID ownerID) {
        return new GroceryItem(UUID.randomUUID(), description, Owner.buildOwner(ownerID), new Date());
    }

    public static GroceryItem rebuildGrocertyItem(UUID id, String description, UUID ownerId, Date creatieDatum) {
        return new GroceryItem(id, description, Owner.rebuildOwner(ownerId), creatieDatum);
    }

    //necessary for JACKSON
    public GroceryItem() {
        this(null, "", null, null);
    }

    private GroceryItem(UUID id, String description, Owner owner, Date creatieDatum) {
        this.id = id;
        this.description = description;
        this.owner = owner;
        this.creatieDatum = creatieDatum;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    @JsonIgnore
    public UUID getOwnerId() {
        return owner.getId();
    }

    public Owner getOwner() {
        return owner;
    }

    public Date getCreatieDatum() {
        return creatieDatum;
    }
}
