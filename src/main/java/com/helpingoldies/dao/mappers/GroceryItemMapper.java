package com.helpingoldies.dao.mappers;

import com.helpingoldies.domain.groceries.GroceryItem;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class GroceryItemMapper implements ResultSetMapper<GroceryItem> {

    @Override
    public GroceryItem map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return GroceryItem.rebuildGrocertyItem(UUID.fromString(resultSet.getString("id")), resultSet.getString("description"), UUID.fromString(resultSet.getString("owner_id")), new Date(resultSet.getDate("creatieDatum").getTime()));
    }
}
