package com.example.prueba1orquera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prueba1orquera.model.usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText gamP, nomP, appP,correoP;
    ListView listV_usuarios;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gamP = findViewById(R.id.txt_gamerUsuario);
        nomP = findViewById(R.id.txt_nombreUsuario);
        appP = findViewById(R.id.txt_appUsuario);
        correoP = findViewById(R.id.txt_correoUsuario);

        listV_usuarios = findViewById(R.id.lv_datosUsuarios);

        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String nombre = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String apellido = appP.getText().toString();
        String gamertag = gamP.getText().toString();

        switch (item.getItemId()){
            case R.id.icon_add:{
                if (nombre.equals("")||correo.equals("")||gamertag.equals("")||apellido.equals("")){
                    validacion();

                }else{
                    usuario p = new usuario();
                    p.setGamertag(gamertag);
                    p.setNombre(nombre);
                    p.setApellido(apellido);
                    p.setCorreo(correo);
                    databaseReference.child("Usuario").child(p.getGamertag()).setValue(p);
                    Toast.makeText(this,"Agregar",Toast.LENGTH_LONG).show();
                    limpiarCajas();

                }
                break;

            }
            case R.id.icon_save:{
                Toast.makeText(this,"Guardar",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.icon_delete:{
                Toast.makeText(this,"Eliminar",Toast.LENGTH_LONG).show();
                break;
            }
            default:break;

        }
        return true;
    }

    private void limpiarCajas() {
        nomP.setText("");
        correoP.setText("");
        appP.setText("");
        gamP.setText("");
    }

    private void validacion() {

        String nombre = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String apellido = appP.getText().toString();
        String gamertag = gamP.getText().toString();

        if(nombre.equals("")){
            nomP.setError("Valor Obligatorio");
        }else if(apellido.equals("")){
            appP.setError("Valor Obligatorio");
        }else if(correo.equals("")){
            correoP.setError("Valor Obligatorio");
        }else if(gamertag.equals("")){
            gamP.setError("Valor Obligatorio");
        }
    }
}