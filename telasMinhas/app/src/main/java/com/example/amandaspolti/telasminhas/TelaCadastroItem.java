package com.example.amandaspolti.telasminhas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TelaCadastroItem extends AppCompatActivity {

    private ItemCadastroTask mAuthTask = null;

    // UI references.
    private EditText mEditItem;
    private EditText mEditData;
    private View mProgressView;
    private View mCadastroItemFormView;
    RadioButton mRadioFacil, mRadioMedio, mRadioDificil;
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_item);


        mEditItem = (EditText) findViewById(R.id.cadastro_item_text);
        mEditData = (EditText) findViewById(R.id.cadastro_item_data);

        mRadioFacil = (RadioButton) findViewById(R.id.radioFacil);
        mRadioMedio = (RadioButton) findViewById(R.id.radioMedio);
        mRadioDificil = (RadioButton) findViewById(R.id.radioHard);


        Button mEmailSignInButton = (Button) findViewById(R.id.cadastro_item_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarItem();
            }
        });

        mCadastroItemFormView = findViewById(R.id.item_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void cadastrarItem() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEditItem.setError(null);
        mEditData.setError(null);
        mRadioFacil.setError(null);

        // Store values at the time of the login attempt.
        String item_text = mEditItem.getText().toString();
        String dueDate = mEditData.getText().toString();


        boolean cancel = false;
        View focusView = null;

        if (!mRadioFacil.isChecked() && !mRadioMedio.isChecked() && !mRadioDificil.isChecked()) {
            mRadioFacil.setError(getString(R.string.error_field_required));
            focusView = mRadioFacil;
            cancel = true;
        }

        if (TextUtils.isEmpty(item_text)) {
            mEditItem.setError(getString(R.string.error_field_required));
            focusView = mEditItem;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {

            showProgress(true);
            int nivelItem = 0;
            if (mRadioFacil.isChecked()) {
                nivelItem = 1;
            } else if (mRadioMedio.isChecked()) {
                nivelItem = 2;
            } else if (mRadioDificil.isChecked()) {
                nivelItem = 3;
            }

            mAuthTask = new ItemCadastroTask(item_text, nivelItem, dueDate);
            mAuthTask.execute((Void) null);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mCadastroItemFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mCadastroItemFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mCadastroItemFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mCadastroItemFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    public class ItemCadastroTask extends AsyncTask<Void, Void, Boolean> {

        private final String mText;
        private final int mNivel;
        private final String mDueDate;

        ItemCadastroTask(String text, int nivel, String dueDate) {
            mText = text;
            mNivel = nivel;
            mDueDate = dueDate;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return false;
            }

            ItemDAO itemdao = ItemDAO.getInstance(TelaCadastroItem.this);
            long id = itemdao.create(mText, mDueDate, mNivel);
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);
            if (success) {
                finish();
            } else {
              //TODO tratar o erro
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }


    public /*String*/ void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
//        DatePickerFragment dt  = (DatePickerFragment) newFragment;
//        return dt.dataUser;

    }


    public void onBtnCadastrarItem(View view) {


        //TODO Como pegar data e colocar em no banco

        //  dueDate = (byte) findViewById(R.id.due_date);
//
//        Item itemo = item_DAO.create(item.getText().toString(), data.getText().toString(), nivel);
//        objeto.setText(item.getText().toString());
//        objeto.setNivel(nivel);
        //objeto.setDueDate(data.getText());
//        objeto.setStatus(0);

        // Toast.makeText(this, item.getText().toString(), Toast.LENGTH_LONG).show();
        //     Item objeto = new Item(item.getText().toString(), nivel);
        //   item_DAO.save(objeto);
        //     Toast.makeText(this, "Item Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();

    }
}

