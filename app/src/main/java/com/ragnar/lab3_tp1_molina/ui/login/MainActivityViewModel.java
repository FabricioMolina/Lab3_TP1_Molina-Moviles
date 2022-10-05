package com.ragnar.lab3_tp1_molina.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ragnar.lab3_tp1_molina.model.Usuario;
import com.ragnar.lab3_tp1_molina.request.ApiClient;
import com.ragnar.lab3_tp1_molina.ui.registro.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private ApiClient ap = new ApiClient();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }
    public void login(String mail, String pass){

        if(ApiClient.login(context,mail, pass) != null){
            Intent i = new Intent(context, RegistroActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }else{
            Toast.makeText(context, "Email o Contraseña equivocados.", Toast.LENGTH_SHORT).show();
        }
    }
    public void registro(){
        Intent i = new Intent(context, RegistroActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

}
