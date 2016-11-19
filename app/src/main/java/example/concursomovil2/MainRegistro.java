package example.concursomovil2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainRegistro extends AppCompatActivity {

    EditText editTextNombre, editTextApellido, editTextCorreo, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);

        editTextNombre=(EditText) findViewById(R.id.editTextNombre);
        editTextApellido=(EditText) findViewById(R.id.editTextApellido);
        editTextCorreo=(EditText) findViewById(R.id.editTextCorreo);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
    }

    public void cerrar(View view) {
        finish();
    }
}
