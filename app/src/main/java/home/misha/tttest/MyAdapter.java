package home.misha.testy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Misha on 15.04.2016.
 */
public class MyAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Pytannja> objects;

    MyAdapter(Context context, ArrayList<Pytannja> pytannjas){

        ctx=context;
        objects=pytannjas;
        lInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;

        if (view==null) {view=lInflater.inflate(R.layout.list, parent, false);}
        Pytannja pytannja=getPytannja(position);
        ((TextView)view.findViewById(R.id.text_nameList)).setText(pytannja.getName());
         ((TextView)view.findViewById(R.id.textDodatok_List)).setText(pytannja.getDodatok_name());
          return view;
    }



    Pytannja getPytannja(int Id){
        return (Pytannja)getItem(Id);
    }



}
