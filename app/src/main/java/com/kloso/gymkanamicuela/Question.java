package com.kloso.gymkanamicuela;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

    private String question;
    private List<String> clues;
    private String solution;
    private boolean hasDialog;
    private String dialogContent;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getClues() {
        return clues;
    }

    public void setClues(List<String> clues) {
        this.clues = clues;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public boolean hasDialog() {
        return hasDialog;
    }

    public void setHasDialog(boolean hasDialog) {
        this.hasDialog = hasDialog;
    }

    public String getDialogContent() {
        return dialogContent;
    }

    public void setDialogContent(String dialogContent) {
        this.dialogContent = dialogContent;
    }
}
