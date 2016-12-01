package com.example.amandaspolti.telasminhas;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by amandaspolti on 01/12/16.
 */
public class ItemDAO extends ItenDBDAO{

    public ItemDAO(Context context) {
        super(context);
    }
    public long save(Item item) {
        ContentValues values = new ContentValues();
        //values.put(TabelaItem.COLUMN_ID, item.get_id());
        values.put(TabelaItem.COLUMN_ITEM, item.getText());
        values.put(TabelaItem.COLUMN_NIVEL, item.getNivel());
        values.put(TabelaItem.COLUMN_DUEDATE, item.getDueDate());
        values.put(TabelaItem.COLUMN_STATUS, false);

        return db.insert(TabelaItem.TABLE_ITENS, null, values);
    }

}

