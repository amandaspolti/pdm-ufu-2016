package com.example.amandaspolti.telasminhas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO do Item.
 */
public class ItemDAO {
    private SQLiteDatabase db;
    private String[] columns = {TabelaItem.COLUMN_ID, TabelaItem.COLUMN_ITEM,
            TabelaItem.COLUMN_NIVEL, TabelaItem.COLUMN_DUEDATE, TabelaItem.COLUMN_DONE};

    private TabelaItem mTIHelper;

    private static ItemDAO ourInstance;

    public static ItemDAO getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new ItemDAO(context);
        return ourInstance;
    }

    private ItemDAO(Context c) {
        mTIHelper = TabelaItem.getInstance(c);
        db = mTIHelper.open();
    }


    public long create(String text, String dueDate, int nivel) {
        ContentValues values = new ContentValues();

        values.put(TabelaItem.COLUMN_ITEM, text);
        values.put(TabelaItem.COLUMN_NIVEL, nivel);
        if (dueDate != null) {
            values.put(TabelaItem.COLUMN_DUEDATE, dueDate);
        }
        values.put(TabelaItem.COLUMN_DONE, false);

        return db.insert(TabelaItem.TABLE_ITENS, null, values);
    }

    public void delete(Item item) {
        long id = item.get_id();
        db.delete(TabelaItem.TABLE_ITENS,
                TabelaItem.COLUMN_ID + '=' + id, null);
    }

    public List<String> getAll() {
        List<String> itens = new ArrayList<>();
        Cursor c = db.query(TabelaItem.TABLE_ITENS, columns,
                null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String data = c.getString(3);
            data = data.equals("") ? "null" : data;

            String item = Long.toString(c.getLong(0)) + "||" + c.getString(1) + "||" + c.getInt(2)
                    + "||" + data + "||" + c.getInt(4);

            itens.add(item);
            c.moveToNext();
        }
        c.close();
        return itens;
    }
}
