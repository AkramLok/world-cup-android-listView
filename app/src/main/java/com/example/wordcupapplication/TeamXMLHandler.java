package com.example.wordcupapplication;

import android.content.Context;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class TeamXMLHandler extends DefaultHandler {
    boolean currentElement = false;
    String currentValue = "";
    ArrayList<Team> teamList;
    private Team team;
    private Context context;
    public TeamXMLHandler(Context c) {
        this.context = c;
    }
    public ArrayList<Team> getCartList() {
        return teamList;
    }
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        currentElement = true;
        if (qName.equals("Teams")){
            teamList = new ArrayList<Team>();
        }
        else if (qName.equals("Team")) {
            team = new Team();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        currentElement = false;
        if (qName.equalsIgnoreCase("Name")){
            team.setName(currentValue.trim());
        }
        else if (qName.equalsIgnoreCase("Nickname"))
            team.setNickname(currentValue.trim());
        else if (qName.equalsIgnoreCase("Description"))
            team.setDescription(currentValue.trim());
        else if (qName.equalsIgnoreCase("Participation"))
            team.setParticipation(Integer.parseInt(currentValue.trim()));
        else if (qName.equalsIgnoreCase("Winner"))
            team.setWinner(Integer.parseInt(currentValue.trim()));
        else if (qName.equalsIgnoreCase("Logo")){
            int drawableResourceId = context.getResources()
                    .getIdentifier(currentValue.trim(),
                            "drawable", context.getPackageName());
            team.setIcon(drawableResourceId);
        }
        else if (qName.equalsIgnoreCase("Photo")){
            int drawableResourceId = context.getResources()
                    .getIdentifier(currentValue.trim(),
                            "drawable", context.getPackageName());
            team.setPhoto(drawableResourceId);
        }

        else if (qName.equalsIgnoreCase("Team"))
            teamList.add(team);
        currentValue = "";
    }
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (currentElement) {
            currentValue = currentValue +
                    new String(ch, start, length);
        }
    }
}
