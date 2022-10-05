package com.ragnar.lab3_tp1_molina.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ragnar.lab3_tp1_molina.R;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mView;
    private EditText etContraseña, etEmail;
    private Button btnLogin, btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializarVista();
    }

    private void inicializarVista() {
        etContraseña = findViewById(R.id.etContraseña);
        etEmail = findViewById(R.id.etEmail);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.login(etEmail.getText().toString(), etContraseña.getText().toString());
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.registro();
            }
        });
    }
}