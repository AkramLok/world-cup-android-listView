package com.example.wordcupapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_list);
        Team team = (Team)this.getIntent().getExtras().get("Team");
        ((TextView) findViewById(R.id.teamName)).setText(team.getName());

        ((TextView) findViewById(R.id.teamNickname))
                .setText("Surnom: "+ team.getNickname());
        ((TextView) findViewById(R.id.teamWinner))
                .setText("Vainqueur: "+ team.getWinner());
        ((TextView) findViewById(R.id.teamParticipation))
                .setText("Participation: "+ team.getParticipation());
        ((TextView) findViewById(R.id.teamDescription))
                .setText("Description: "+ team.getDescription());
        ((ImageView) findViewById(R.id.teamLogo))
                .setImageResource(team.getIcon());
        ((ImageView) findViewById(R.id.teamPhoto))
                .setImageResource(team.getPhoto());


    }

}
