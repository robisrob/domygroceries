package com.helpingoldies.dao;

import com.helpingoldies.dao.mappers.GroceryItemMapper;
import com.helpingoldies.domain.groceries.GroceryItem;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface GroceryListDOA {

    @Mapper(GroceryItemMapper.class)
    @SqlQuery("SELECT * FROM groceryitem where owner_id = :ownerId")
    List<GroceryItem> findGroceries(@Bind("ownerId") String ownerId);

    @SqlUpdate("insert into groceryitem (id, description, owner_id, creatiedatum) values (:id, :description, :ownerId, :creatieDatum)")
    void createGroceryItem(@Bind("id") String id, @Bind("description") String description, @Bind("ownerId") String ownerId, @Bind("creatieDatum") Date creatieDatum);
}
