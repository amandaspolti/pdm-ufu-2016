package cecilia.org.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO do Item.
 */
public class ItemDAO {
    private SQLiteDatabase db;
    private String[] columns = {TabelaItem.COLUMN_ID,
            TabelaItem.COLUMN_ITEM, TabelaItem.COLUMN_DUEDATE,
            TabelaItem.COLUMN_STATUS};

    private TabelaItem sqLiteOpenHelper;

    public ItemDAO(Context c) {
        sqLiteOpenHelper =
                new TabelaItem(c);
    }

    public void open() throws SQLException {
        db = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close() {
        sqLiteOpenHelper.close();
    }

    public Item create(String item, String dueDate, boolean status) {
        ContentValues values = new ContentValues();

        if (dueDate != null) {
            values.put(TabelaItem.COLUMN_DUEDATE, dueDate);
        }

        values.put(TabelaItem.COLUMN_ITEM, item);
        values.put(TabelaItem.COLUMN_STATUS, status);


        long insertId = db.insert(TabelaItem.TABLE_ITENS, null,
                values);


        Cursor c = db.query(TabelaItem.TABLE_ITENS, columns,
                TabelaItem.COLUMN_ID + "=" +
                        insertId, null, null, null, null);
        c.moveToFirst();

        Item newItem = new Item();
        newItem.set_id(c.getLong(0));
        newItem.setText(c.getString(1));
        newItem.setDueDate(c.getBlob(2));
        newItem.setStatus(c.getInt(3));
        c.close();
        return newItem;
    }

    public void delete(Item item) {
        long id = item.get_id();
        db.delete(TabelaItem.TABLE_ITENS,
                TabelaItem.COLUMN_ID + '=' + id, null);

    }

    public List<Item> getAll() {
        List<Item> itens = new ArrayList<>();
        Cursor c = db.query(TabelaItem.TABLE_ITENS, columns,
                null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Item newItem = new Item();
            newItem.set_id(c.getLong(0));
            newItem.setText(c.getString(1));
            newItem.setDueDate(c.getBlob(2));
            newItem.setStatus(c.getInt(3));
            itens.add(newItem);
            c.moveToNext();
        }
        c.close();
        return itens;
    }
}
