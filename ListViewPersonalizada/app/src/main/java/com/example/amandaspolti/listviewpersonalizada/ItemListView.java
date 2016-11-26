package com.example.amandaspolti.listviewpersonalizada;

/**
 * Created by amandaspolti on 26/11/16.
 */
public class ItemListView {

    private String texto;
    private int iconeRid;
    private String txt_botao;

    public ItemListView() {
    }

    public ItemListView(String texto, int iconeRid) {
        this.texto = texto;
        this.iconeRid = iconeRid;

    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    public String getTxt_botao() {
        return txt_botao;
    }

    public void setTxt_botaoç(String txt_botao) {
        this.txt_botao = txt_botao;
    }
}