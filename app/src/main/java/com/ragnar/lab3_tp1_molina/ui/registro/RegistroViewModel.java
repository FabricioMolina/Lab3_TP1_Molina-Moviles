package com.ragnar.lab3_tp1_molina.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ragnar.lab3_tp1_molina.model.Usuario;
import com.ragnar.lab3_tp1_molina.request.ApiClient;

public class RegistroViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Long> dniMutable;
    private MutableLiveData<String> nombreMutable;
    private MutableLiveData<String> apellidoMutable;
    private MutableLiveData<String> emailMutable;
    private MutableLiveData<String> contraseñaMutable;

    public RegistroViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }
    public LiveData<String> getNombreMutalbe(){
        if(this.nombreMutable == null){
            this.nombreMutable = new MutableLiveData<>();
        }
        return nombreMutable;
    }
    public LiveData<String> getApellidoMutalbe(){
        if(this.apellidoMutable == null){
            this.apellidoMutable = new MutableLiveData<>();
        }
        return apellidoMutable;
    }
    public LiveData<String> getEmailMutalbe(){
        if(this.emailMutable == null){
            this.emailMutable = new MutableLiveData<>();
        }
        return emailMutable;
    }
    public LiveData<String> getContraseñaMutalbe(){
        if(this.contraseñaMutable == null){
            this.contraseñaMutable = new MutableLiveData<>();
        }
        return contraseñaMutable;
    }
    public LiveData<Long> getDniMutable(){
        if(this.dniMutable == null){
            this.dniMutable = new MutableLiveData<>();
        }
        return dniMutable;
    }



    public void leerDatos(){
        Usuario usuario = ApiClient.leer(context);
        if (usuario.getApellido() != "null"){
            long dni = usuario.getDni();
            String nombre = usuario.getNombre();
            String apellido = usuario.getApellido();
            String email = usuario.getEmail();
            String contraseña = usuario.getContraseña();

            this.dniMutable.setValue(dni);
            this.nombreMutable.setValue(nombre);
            this.apellidoMutable.setValue(apellido);
            this.emailMutable.setValue(email);
            this.contraseñaMutable.setValue(contraseña);
        }

    }
    public void guardarDatos(Usuario user){
        ApiClient.guardar(context, user);
        Toast.makeText(context, "Usuario Registrado", Toast.LENGTH_SHORT).show();
    }
}
