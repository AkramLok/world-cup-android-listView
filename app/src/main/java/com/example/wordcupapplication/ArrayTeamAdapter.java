package com.example.wordcupapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArrayTeamAdapter  extends ArrayAdapter<Team> {
    private LayoutInflater inflater;
    private List<Team> teams;
    public ImageView icon;
    public ArrayTeamAdapter(Context context, List<Team> teams) {
        super(context, R.layout.activity_team, teams);
        this.inflater = LayoutInflater.from(context);
        this.teams = teams;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_team, null);
            holder.name = (TextView) convertView.findViewById(R.id.teamName);
            holder.nickname = (TextView) convertView.findViewById(R.id.teamNickname);

            holder.icon = (ImageView) convertView.findViewById(R.id.teamLogo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(teams.get(position).getName());
        holder.nickname.setText(teams.get(position).getNickname());
        holder.icon.setImageDrawable(parent.getResources()
                .getDrawable(teams.get(position).getIcon()));
        return convertView;
    }
    static class ViewHolder {
        public TextView name ;
        public TextView nickname;
        public ImageView icon;
    }

}
