package com.example.wordcupapplication;
import android.os.Parcel;
import android.os.Parcelable;

public class Team implements Parcelable {
    private String name;
    private String nickname;
    private int icon;
    private int photo;

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int participation;
    private int winner;
    private String description="";
    // Constructor, getters, and setters

    public Team()
    {}

    protected Team(Parcel in) {
        name = in.readString();
        nickname = in.readString();
        icon = in.readInt();
        photo = in.readInt();
        participation = in.readInt();
        winner = in.readInt();
        description = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nickname);
        dest.writeInt(icon);
        dest.writeInt(photo);
        dest.writeInt(participation);
        dest.writeInt(winner);
        dest.writeString(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
