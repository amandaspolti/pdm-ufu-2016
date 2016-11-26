package cecilia.org.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe resposavel pela criação da tabela de itens
 */
public class TabelaItem extends SQLiteOpenHelper {
    public static final String TABLE_ITENS = "itens";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ITEM = "item";
    public static final String COLUMN_DUEDATE = "dueDate";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_NIVEL = "nivel";


    public static final String DATABASE_NAME = " itens.db";
    public static final int DATABASE_VERSION = 1;

    private static String SQL = "CREATE TABLE " + TABLE_ITENS + " ( " + COLUMN_ID +
            " integer primary key autoincrement, " + COLUMN_ITEM + " text not null, " + COLUMN_NIVEL
            + " tinyint not null, " + COLUMN_DUEDATE + " blob, " + COLUMN_STATUS + " BOOLEAN )";

    public TabelaItem(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase d) {
        d.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) { //TODO repensar isso aqui
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITENS);
        onCreate(db);
    }
}
