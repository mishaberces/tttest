package home.misha.testy;

import android.os.Parcel;
import android.os.Parcelable;


public class Pytannja implements  Parcelable {
    private String name;
    private String dodatok_name;
    private String detali;
    private int id;

    public void setName(String _name){
        this.name=_name;
    }

    public String getName(){
        return this.name;
    }

    public void setDodatok_name(String _dodatok_name){
        this.dodatok_name=_dodatok_name;
    }

    public String getDodatok_name(){
        return this.dodatok_name;
    }

    public void setDetali(String _detali){
        this.detali=_detali;
    }

    public String getDetali(){
        return this.detali;
    }

    public void setId(int _id){
        this.id=_id;
    }

    public int getId(){
        return this.id;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
     dest.writeString(name);
     dest.writeString(dodatok_name);
     dest.writeString(detali);
     dest.writeInt(id);
    }

    public static final Parcelable.Creator<Pytannja> CREATOR = new Parcelable.Creator<Pytannja>() {

        public Pytannja createFromParcel(Parcel in) {

            return new Pytannja(in);
        }

        public Pytannja[] newArray(int size) {
            return new Pytannja[size];
        }
    };

    private Pytannja(Parcel dest){
        this.name=dest.readString();
        this.dodatok_name=dest.readString();
        this.detali=dest.readString();
        this.id=dest.readInt();

    }


    public Pytannja(String name, String dodatok_name, String detali, int id ){
        this.name=name;
        this.dodatok_name=dodatok_name;
        this.detali=detali;
        this.id=id;
    }




}
