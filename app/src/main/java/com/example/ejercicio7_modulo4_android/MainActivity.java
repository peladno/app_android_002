package com.example.ejercicio7_modulo4_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ejercicio7_modulo4_android.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        class Game {
            private final String title;
            private final String msg;
            private final int id;
            private final int image;

            public Game(String title, String msg, int id, int image) {
                this.title = title;
                this.msg = msg;
                this.id = id;
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public String getMessage() {
                return msg;
            }

            public int getImageId() {
                return id;
            }

            public int getImage() {
                return image;
            }
        }


        List<Game> games = new ArrayList<>();
        games.add(new Game("Dota 2", "Dota 2 (En español Defensa de los Ancestros 2) es un videojuego " +
                "perteneciente al género de Arena de batalla en línea ARTS " +
                "(«estrategia " +
                "de acción en tiempo real»), también conocido en inglés como MOBA, " +
                "fue lanzado el 9 de julio del año 2013.", R.id.dota, R.drawable.icons8_dota_240));
        games.add(new Game("Animal Crossing", "Animal Crossing (どうぶつの森もり Dōbutsu no Mori?, lit. «Bosque de " +
                "los animales») es una serie de videojuegos de simulación de vida publicada por " +
                "Nintendo y creada por Katsuya Eguchi y Hisashi Nogami, " +
                "en la que el jugador vive en un pueblo habitado por animales antropomórficos, " +
                "llevando a cabo diversas actividades", R.id.animalCrossing, R.drawable.icons8_animal_crossing_240));
        games.add(new Game("Overwatch", "Overwatch fue un videojuego de disparos en primera persona multijugador, " +
                "desarrollado por Blizzard Entertainment. Fue lanzado al público el 24 de mayo " +
                "del 2016, para las plataformas PlayStation 4, Xbox One y " +
                "Microsoft Windows; posteriormente fue lanzado para Nintendo Switch", R.id.overwatch, R.drawable.icons8_overwatch_240));
        games.add(new Game("WoW", "World of Warcraft (abreviado como WoW, literalmente en español Mundo de " +
                "Warcraft) es un videojuego de rol multijugador masivo en línea desarrollado por " +
                "Blizzard Entertainment. Es el cuarto juego lanzado establecido en el universo " +
                "fantástico de Warcraft, el cual fue introducido por primera vez por Warcraft: " +
                "Orcs & Humans en 1994", R.id.wow, R.drawable.icons8_world_of_warcraft_240));


        for (final Game game : games) {
            ImageButton imageButton = mainBinding.getRoot().findViewById(game.getImageId());
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialog(game.getTitle(), game.getMessage(), game.getImage());
                }
            });
        }


        mainBinding.buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
            }
        });

    }

    private void showAlertDialog(String title, String message, int image) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("msg", message);
                        intent.putExtra("title", title);
                        intent.putExtra("image", image);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
