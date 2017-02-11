package com.example.hp_pc.myapplication;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
class VoiceRecog extends Activity {
    class Confirm extends VoiceInteractor.ConfirmationRequest {
        public Confirm(String ttsPrompt, String visualPrompt) {
            VoiceInteractor.Prompt prompt = new VoiceInteractor.Prompt(
                new String[] {ttsPrompt}, visualPrompt);
            super(prompt, null);
            }

        @Override
        public void onConfirmationResult(
            boolean confirmed, Bundle null) {
                if (confirmed) {
                    doAction();
                }
            finish();
            }
        };

    @Override
    public void onResume() {
        if (isVoiceInteraction()) {
            String ttsPrompt = getConfirmationTts();
            String visualPrompt = getConfirmationDisplayText();
            getVoiceInteractor().sendRequest(new Confirm(ttsPrompt, visualPrompt));
            } else {
            finish();
            }
        }
}*/