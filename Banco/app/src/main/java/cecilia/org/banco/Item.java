package cecilia.org.banco;

/**
 * Classe responsável pelo Item.
 */
public class Item {
    private long _id;
    private boolean status;
    private String text;
    private byte[] dueDate;
    private byte nivel; //1 facil 2 medio 3 dificil


    public byte[] getDueDate() {
        return dueDate;
    }

    public void setDueDate(byte[] dueDate) {
        this.dueDate = dueDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status =
                Boolean.parseBoolean(Integer.toString(status));
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = Byte.parseByte(Integer.toString(nivel));
    }
}
