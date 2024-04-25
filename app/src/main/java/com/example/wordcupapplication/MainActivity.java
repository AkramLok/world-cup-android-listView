package com.example.wordcupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    ListView teamsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamsListView = (ListView)findViewById(android.R.id.list);
        //getTeams : build a fixed list of teams
        List<Team> teams = getTeams();
        //association avec l'adaptateur
        teamsListView.setAdapter(new ArrayTeamAdapter(this, teams));
        teamsListView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id){
        Team team = (Team)
                teamsListView.getAdapter().getItem(position);
        Intent intent = new Intent(this, TeamActivity.class);
        intent.putExtra("Team", team);
        startActivity(intent);
    }
    private List<Team> getTeams() {
        List<Team> teams = null ;
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("teams_infos.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            TeamXMLHandler myXMLHandler = new TeamXMLHandler(this);
            xr.setContentHandler(myXMLHandler);
            InputSource inStream = new InputSource(is);
            xr.parse(inStream);
            teams = myXMLHandler.getCartList();
            is.close();
        } catch (Exception e) {
            Log.getStackTraceString(e);
        }
        return teams;
    }
}