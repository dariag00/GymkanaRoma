package com.kloso.gymkanamicuela.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kloso.gymkanamicuela.Question;
import com.kloso.gymkanamicuela.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<Question> questions = new ArrayList<>();

    private int currentQuestion = 0;

    private String TAG =  this.getClass().getName();
    private String CURRENT_QUESTION_TAG = "CURRENT_QUESTION";
    private QuestionFragment questionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            System.out.println("Entro");
            currentQuestion = savedInstanceState.getInt(CURRENT_QUESTION_TAG);
            getSupportFragmentManager().getFragment(savedInstanceState, "questionFragment");
        }

        ButterKnife.bind(this);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Preferences", 0);
        currentQuestion = preferences.getInt(getString(R.string.current_question), 0);

        checkInstructions();

        questions = populateQuestions();

        commitFragment();

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_QUESTION_TAG, currentQuestion);
    }

    private void checkInstructions(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Preferences", 0);
        boolean instructionsRead = preferences.getBoolean(getString(R.string.instructions_read), false);
        if(!instructionsRead){
            Intent introIntent = new Intent(this, IntroActivity.class);
            startActivity(introIntent);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(getString(R.string.instructions_read), true);
            editor.apply();
        }
    }


    private List<Question> populateQuestions(){

        List<Question> questions = new ArrayList<>();

        //Hide the pain Harold
        Question question = new Question();
        question.setQuestion("1- ¿En que año se fundó Roma?");
        question.setClues(Arrays.asList(""));
        question.setSolution("753 aC");
        question.setHasDialog(true);
        question.setDialogContent("Para calentar un poco, antes de pasar a mis explicaciones, vamos a repasar algunas cosillas de Roma");
        questions.add(question);

        question = new Question();
        question.setQuestion("2- ¿Quién fundó Roma?");
        question.setClues(Arrays.asList("Se cargó a su hermano", "La movida de la loba y tal", "Es un poco mitardo, tbh. Ya te iré contando"));
        question.setSolution("Romulo");
        questions.add(question);

        question = new Question();
        question.setQuestion("3- ¿En que región está Roma?");
        question.setClues(Arrays.asList("Pereza"));
        question.setSolution("Lazio");
        questions.add(question);

        question = new Question();
        question.setQuestion("4- ¿Que rio atraviesa la ciudad?");
        question.setClues(Arrays.asList("Pereza"));
        question.setSolution("Tiber");
        questions.add(question);

        question = new Question();
        question.setQuestion("5- ¿Sobre cuantas colinas se asentó roma?");
        question.setClues(Arrays.asList("Es un número"));
        question.setSolution("7");
        questions.add(question);

        question = new Question();
        question.setQuestion("6- ¿Que ciudad estado está en Roma?");
        question.setClues(Arrays.asList("PedoCountry"));
        question.setSolution("Vaticano");
        questions.add(question);

        question = new Question();
        question.setQuestion("7- ¿Cual era el epicentro de la vida diaria en Roma?");
        question.setClues(Arrays.asList("Lo vamos a visitar", "Hay varios", "Que si romano, que si imperial, que si trajano"));
        question.setSolution("Foro");
        questions.add(question);

        question = new Question();
        question.setQuestion("8- ¿En que año erupcionó el Vesubio?");
        question.setClues(Arrays.asList("Sale en Loki jeje", "Llevaba tantisimos años sin erupcionar, que los romanos no sabían que era un volcán"));
        question.setSolution("79");
        questions.add(question);

        question = new Question();
        question.setQuestion("9- ¿Cuál es el mausoleo que el emperador Adriano mandó construir para él?");
        question.setClues(Arrays.asList("Vamos a ir a verlo", "Está en el vaticano", "Micaela PLS"));
        question.setSolution("Miguel Angel");
        questions.add(question);

        question = new Question();
        question.setQuestion("10- ¿Autor de El Juicio Final de la boveda de la capilla sixtina?");
        question.setClues(Arrays.asList("Vamos a ir a verlo", "Está cerca del vaticano", "Ha sido un fuerte, una residencia papal y un museo"));
        question.setSolution("Castel Sant Angelo");
        questions.add(question);

        question = new Question();
        question.setQuestion("11- ¿Quien ordena a Lucio Voreno llevar unos dineros a lo nazi desde Ostia hasta Roma?");
        question.setClues(Arrays.asList("Tito Pullo no es", "Salio mal y casi se cargan a los del voreno", "El personaje muere en la serie"));
        question.setSolution("Marco Antonio");
        question.setHasDialog(true);
        question.setDialogContent("Ya que vamos pues asi repasamos. A partir de ahora las preguntas las podrás responder según vayamos viendo cosas de Roma");
        questions.add(question);

        question = new Question();
        question.setQuestion("12- ¿Que Artista tuvo la supuesta movida en la Plaza Navona con Bernini");
        question.setClues(Arrays.asList("Uno hizo la plaza", "Y otro la iglesia", "El tema de las esculturas de la plaza que miran feo"));
        question.setHasDialog(true);
        question.setDialogContent("Mu mieen! La siguiente pregunta la podrás responder en un coso que echa agua");
        question.setSolution("Borromini");
        questions.add(question);

        question = new Question();
        question.setQuestion("13- ¿A quien se atribuye falsamente la Fontana di Trevi");
        question.setClues(Arrays.asList("Atiende mas para la siguiente"));
        question.setHasDialog(true);
        question.setDialogContent("Meow bieen! Nos vamos a la iglesia más antigua de Roma");
        question.setSolution("Bernini");
        questions.add(question);

        question = new Question();
        question.setQuestion("14- ¿Que famoso artista está enterrado en esta iglesia?");
        question.setClues(Arrays.asList("La iglesia tiene muchos años", "Hemos tenido que ver la tumba", "Es mega famoso el man wtf", "Angeles y demonios uwú"));
        question.setHasDialog(true);
        question.setDialogContent("Mu mieen! La siguiente pregunta la podrás responder en un coso que echa agua");
        question.setSolution("Rafael");
        questions.add(question);

        question = new Question();
        question.setQuestion("15- ¿Como se llama la famosa fuente que hemos visto y que es mu jocosa?");
        question.setClues(Arrays.asList("También se llama Fuente del Moisés", "Para suministrar agua a los barrios pobres", "Hecha por Sixto V", "Está al lado de una iglesia con una escultura que representa al fuego en Angelesmy Demonios"));
        question.setHasDialog(true);
        question.setDialogContent("Mu mieen! La siguiente ya me da que hasta mañana nada :(");
        question.setSolution("Fuente del Agua Feliz");
        questions.add(question);

        question = new Question();
        question.setQuestion("16- ¿De que colina viene el nombre Palacio?");
        question.setClues(Arrays.asList("Atiende"));
        question.setSolution("Palatina");
        questions.add(question);

        question = new Question();
        question.setQuestion("17- Segun la leyenda, ¿Donde fue asesinado en el foro romano el amigo Romulo?");
        question.setClues(Arrays.asList("Puedes preguntarme uwu", "No busques en internet", "Realmente o se si se ve ahaha"));
        question.setSolution("Piedra Negra");
        questions.add(question);

        question = new Question();
        question.setQuestion("18- ¿Donde vivian virgenes?");
        question.setClues(Arrays.asList("Se llama casa de X", "uwú ahi no puedes entrar"));
        question.setSolution("Casa de las vestales");
        questions.add(question);

        question = new Question();
        question.setQuestion("19- ¿Cual es la puerta de entrada a Roma?");
        question.setClues(Arrays.asList("Atiende", "Se supone que aqui estamos despues de comer", "La actual puerta la hizo Bernini en 1655"));
        question.setSolution("Puerta Flaminia");
        questions.add(question);

        question = new Question();
        question.setQuestion("20- ¿Que emperador romano fue enterrado en este lugar y creo tremendas movidas?");
        question.setClues(Arrays.asList("Instigó un incendio en el 64", "Se suicidó en el 68", "Quemaron el nogal y to"));
        question.setSolution("Nerón");
        question.setHasDialog(true);
        question.setDialogContent("Adentremonos en el parque jeje");
        questions.add(question);

        question = new Question();
        question.setQuestion("21- ¿De que artista es Apolo y Dafne?");
        question.setClues(Arrays.asList("Si no hemos visto el museo pues F"));
        question.setSolution("Bernini");
        questions.add(question);

        question = new Question();
        question.setQuestion("22- ¿En que hoja cuenta la leyenda, convirtió Apolo a Dafne?");
        question.setClues(Arrays.asList("Si no hemos visto el museo pues F"));
        question.setSolution("Laurel");
        question.setHasDialog(true);
        question.setDialogContent("Ahora es cuando te cuento la movida de las carreras y tal");
        questions.add(question);

        question = new Question();
        question.setQuestion("23- ¿Que tipo de arbol rodea un famoso reloj?");
        question.setClues(Arrays.asList("Está dentro del parque", "Es un reloj único", "Tan úncio que es de agua"));
        question.setHasDialog(true);
        question.setDialogContent("Y con esto me da a mi ya que hasta mañana");
        question.setSolution("Reloj de Agua de Pincio");
        questions.add(question);

        question = new Question();
        question.setQuestion("24- ¿De quien es la estatua ecuestre que hemos visto esta mañana?");
        question.setClues(Arrays.asList("Está fuera y dentro, la de fuera es una replica", "Sale en gladiator"));
        question.setSolution("Marco Aurelio");
        questions.add(question);

        question = new Question();
        question.setQuestion("24- ¿Que hizo Romulo para sofocar el problema de Roma con su futuro");
        question.setClues(Arrays.asList("Que necesita una ciudad para persistir?", "Lo mas importante de todo", "No es el agua pero si bebe agua uwu",
                "Alguno de VOX lo haria ahora", "Hay un cuadro de esto en el museo"));
        question.setSolution("Rapto de las sabinas");
        questions.add(question);

        question = new Question();
        question.setQuestion("25- ¿De que personaje de la serie de Roma hay un busto en una sala con muchos bustos?");
        question.setClues(Arrays.asList("Salio las 2 temporadas", "Se lo cargó Tito Pullo", "Me caia bien", "Iba de blanco"));
        question.setHasDialog(true);
        question.setDialogContent("Ahora me dices que te cuente lo de ir de blanco y lo del candidato. BTW, a buscar un mirador");
        question.setSolution("Cicerón");
        questions.add(question);

        question = new Question();
        question.setQuestion("26- ¿Cuantas columnas se ven desde el mirador del museo?");
        question.setClues(Arrays.asList("Del primer edificio solo"));
        question.setSolution("8");
        question.setHasDialog(true);
        question.setDialogContent("Ya no hay más en el museo");
        questions.add(question);

        question = new Question();
        question.setQuestion("27- ¿Quienes mantuvieron el foro boarium en buen estado?");
        question.setClues(Arrays.asList("Atiende"));
        question.setSolution("Los griegos");
        questions.add(question);

        question = new Question();
        question.setQuestion("28- ¿De donde tiraban a criminales, traidores, etc?");
        question.setClues(Arrays.asList("Atiende", "De una roca"));
        question.setSolution("Roca Tarpeya");
        questions.add(question);

        question = new Question();
        question.setQuestion("29- ¿Que 3 paises se ven desde el Aventino?");
        question.setClues(Arrays.asList("Aquí vivia Lucio Voreno btw", "Uno es facil, dos se ve y el tercero lo tienes delante"));
        question.setSolution("Italia, Vaticano y Malta");
        questions.add(question);

        question = new Question();
        question.setQuestion("30- ¿De quien es la pirámide que vamos a ver?");
        question.setClues(Arrays.asList("Checke a ver"));
        question.setSolution("Cayo Cestio");
        question.setHasDialog(true);
        question.setDialogContent("Se viene lo mas grandeee");
        questions.add(question);

        question = new Question();
        question.setQuestion("31- ¿Quien hizo el coliseo?");
        question.setClues(Arrays.asList("O te lo cuento yo, o te lo cuenta el guia", "Me la agarra con la mano"));
        question.setSolution("Vespasiano");
        questions.add(question);

        question = new Question();
        question.setQuestion("32 - Cual es el nombre original?");
        question.setClues(Arrays.asList("Coliseo no es"));
        question.setSolution("Anfiteatro Flavio");
        questions.add(question);

        question = new Question();
        question.setQuestion("33 - Que gran reliquia está guardada en una iglesia que hemos visto?");
        question.setClues(Arrays.asList("Es San Pedro de no se que uwu", "EL nombre TIENE qwue ver", "Quizas prueba traduciendolo"));
        question.setSolution("Cadenas de San pedro");
        questions.add(question);

        question = new Question();
        question.setQuestion("33 - Que pone en la tumba del gran escultos que hemos visto estos dias, concretamente ayer?");
        question.setClues(Arrays.asList("Primero habra que buscar donde está enterrado", "Es en una iglesia", "Los trenes pasan cerca", "El coliseo y san pietro in vincoli forman una linea"));
        question.setSolution("IOANNES LAVRENTIVS BERNINI DECVS ARTIVM ET VRBIS HIC HVMILITER QVIESCIT");
        question.setHasDialog(true);
        question.setDialogContent("Bieeeen. Se terminó :(");
        questions.add(question);




        return questions;
    }

    public void goToNextQuestion(){
        currentQuestion++;
        saveCurrentQuestionState();
        if(currentQuestion >= questions.size()){
            Log.i(TAG, "Llegamos al final del juego");
            commitFinalFragment();
        } else {
            Log.i(TAG, "Lanzamos el fragment con id de la pregunta " + currentQuestion);
            commitFragment();
        }
    }

    private void saveCurrentQuestionState(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Preferences", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.current_question), currentQuestion);
        editor.apply();
    }

    private void commitFragment(){
        if(currentQuestion >= questions.size()){
            Log.i(TAG, "Llegamos al final del juego");
            commitFinalFragment();
        } else {
            questionFragment = new QuestionFragment();
            questionFragment.setQuestion(questions.get(currentQuestion));
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.animator.fade_in, android.R.animator.fade_out)
                    .replace(R.id.step_container, questionFragment)
                    .commit();

        }

    }

    private void commitFinalFragment(){
        FinalFragment finalFragment = new FinalFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.step_container, finalFragment)
                .commit();

    }

    public void resetGame(){
        currentQuestion = 0;
        saveCurrentQuestionState();
        commitFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.help:
                Intent introIntent = new Intent(this, IntroActivity.class);
                startActivity(introIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
