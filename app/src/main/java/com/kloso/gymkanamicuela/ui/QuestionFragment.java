package com.kloso.gymkanamicuela.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.kloso.gymkanamicuela.Question;
import com.kloso.gymkanamicuela.R;
import com.ornach.nobobutton.NoboButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionFragment extends Fragment {

    @BindView(R.id.button_clue)
    NoboButton clueButton;
    @BindView(R.id.button_send)
    NoboButton sendButton;
    @BindView(R.id.tv_clue)
    TextView clueView;
    @BindView(R.id.tv_question)
    TextView questionView;
    @BindView(R.id.et_solution)
    EditText solutionEditText;

    private Question currentQuestion;
    private int currentClue;

    private String TAG = QuestionFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.question_fragment, container, false);
        ButterKnife.bind(this, rootView);

        setInitialData();

        clueButton.setOnClickListener(list -> {

            AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
            anim.setDuration(200);
            anim.setRepeatCount(1);
            anim.setRepeatMode(Animation.REVERSE);

            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) { }

                @Override
                public void onAnimationEnd(Animation animation) { }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    clueView.setText(getNextClue());
                }
            });

            clueView.startAnimation(anim);
        });
        sendButton.setOnClickListener(list -> {
            String solution = solutionEditText.getText().toString();
            if(isCorrect(solution)){
                if(currentQuestion.hasDialog()) {
                    DialogFragment dialogFragment = new LevelDialog(currentQuestion.getDialogContent());
                    dialogFragment.show(this.getActivity().getSupportFragmentManager(), "test");
                }
                ((MainActivity) getActivity()).goToNextQuestion();
            } else {
                System.out.println("Respuesta inválida");
                Toast.makeText(this.getContext(), "Noup, prueba otra vez.", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            currentQuestion = (Question) savedInstanceState.getSerializable("question");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Guardamos el fragment");
        outState.putSerializable("question", currentQuestion);
    }

    private String getNextClue(){
        currentClue++;
        if(currentClue == currentQuestion.getClues().size())
            currentClue = 0;

        return currentQuestion.getClues().get(currentClue);
    }

    private boolean isCorrect(String value){
        if(value.endsWith("."))
            Toast.makeText(this.getContext(), "No se ponen puntos donde no hay que ponerlos desgracia humanda", Toast.LENGTH_LONG).show();
        return value.toLowerCase().trim().equals(currentQuestion.getSolution().toLowerCase().trim());
    }

    private void setInitialData(){
        clueView.setText(currentQuestion.getClues().get(currentClue));
        questionView.setText(currentQuestion.getQuestion());
    }

    public void setQuestion(Question question){
        this.currentQuestion = question;
    }

}
