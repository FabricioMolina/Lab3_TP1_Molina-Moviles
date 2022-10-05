package com.ragnar.lab3_tp1_molina.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ragnar.lab3_tp1_molina.R;
import com.ragnar.lab3_tp1_molina.model.Usuario;
import com.ragnar.lab3_tp1_molina.ui.login.MainActivityViewModel;

public class RegistroActivity extends AppCompatActivity {
    private RegistroViewModel mView;
    private EditText etDniRegistro, etNombreRegistro,etApellidoRegistro,etEmailRegistro,etContraseñaRegistro;
    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mView = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);

        mView.getDniMutable().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                etDniRegistro.setText(aLong + "");
            }
        });
        mView.getNombreMutalbe().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etNombreRegistro.setText(s);
            }
        });
        mView.getApellidoMutalbe().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etApellidoRegistro.setText(s);
            }
        });
        mView.getEmailMutalbe().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etEmailRegistro.setText(s);
            }
        });
        mView.getContraseñaMutalbe().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etContraseñaRegistro.setText(s);
            }
        });
        inicializarVista();
    }

    private void inicializarVista() {
        etDniRegistro = findViewById(R.id.etDniRegistro);
        etNombreRegistro = findViewById(R.id.etNombreRegistro);
        etApellidoRegistro = findViewById(R.id.etApellidoRegistro);
        etEmailRegistro = findViewById(R.id.etEmailRegistro);
        etContraseñaRegistro = findViewById(R.id.etContraseñaRegistro);
        btnGuardar = findViewById(R.id.btnGuardar);
        mView.leerDatos();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario user = new Usuario(Long.parseLong(etDniRegistro.getText().toString()), etNombreRegistro.getText().toString(), etApellidoRegistro.getText().toString(),etEmailRegistro.getText().toString(),etContraseñaRegistro.getText().toString());
                mView.guardarDatos(user);
            }
        });
    }
}