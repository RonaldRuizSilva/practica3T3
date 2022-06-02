package com.example.practicat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Retrofit;

@SuppressWarnings("ALL")
public class RegistrarLibroActivity extends AppCompatActivity {

    EditText editTextTextTitlo,editTextTexResumen,editTextFechaPublicacion,editTextTextTienda1,editTextTextTeineda2,editTextTextTeineda3,editTextTextAutor;
    Button imagenBut,registrar;
    ImageView imagen;

    Uri uriImagen;
    String linkImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_libro);

        editTextTextTitlo = findViewById(R.id.editTextTextTitlo);
        editTextTexResumen = findViewById(R.id.editTextTexResumen);
        editTextTextAutor = findViewById(R.id.editTextTextAutor);
        editTextFechaPublicacion = findViewById(R.id.editTextFechaPublicacion);
        editTextTextTienda1 = findViewById(R.id.editTextTextTienda1);
        editTextTextTeineda2 = findViewById(R.id.editTextTextTeineda2);
        editTextTextTeineda3 = findViewById(R.id.editTextTextTeineda3);
        imagenBut = findViewById(R.id.imagenBut);
        imagen = findViewById(R.id.imagen);
        registrar = findViewById(R.id.registrar);
      //  https://6298a8b7f2decf5bb74859ed.mockapi.io/api/v1/addLibro
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6298a8b7f2decf5bb74859ed.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Servicios service = retrofit.create(Servicios.class);
        imagenBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirImagen();
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("link imagen",linkImagen);
                String tittulo = editTextTextTitlo.getEditableText().toString().trim();
                String resumen = editTextTexResumen.getEditableText().toString().trim();
                String autor = editTextTextAutor.getEditableText().toString().trim();
                String fehca_publicacion = editTextFechaPublicacion.getEditableText().toString().trim();
                String tienda_1 = editTextTextTienda1.getEditableText().toString().trim();
                String tienda_2 = editTextTextTeineda2.getEditableText().toString().trim();
                String tienda_3 = editTextTextTeineda3.getEditableText().toString().trim();

                libro post = new libro(
                        tittulo,resumen,autor,fehca_publicacion,tienda_1,tienda_2,tienda_3,"link de imagen"
                );

                Call<Void> entre = service.postCrearLibri(post);
                entre.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        String respuesta = String.valueOf(response.code());
                        if (respuesta.equals("200")) {
                            Toast.makeText(getApplicationContext(), "Libro Registrado", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        } else {
                            Toast.makeText(getApplicationContext(), " Libro no Registrado", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


    private void subirImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, 11);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 11) {
            uriImagen = data.getData();
            imagen.setImageURI(uriImagen);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uriImagen);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                byte[] image = outputStream.toByteArray();
                String encodedString = Base64.encodeToString(image, Base64.DEFAULT);
                linkImagen = encodedString;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}