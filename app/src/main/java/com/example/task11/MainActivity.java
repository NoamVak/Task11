package com.example.task11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
    Spinner cont;
    Spinner countries;
    ListView cities;
    TextView area,pop;
    int row,choice;
    String [] contA;
    String [][] countryA={{"","Kenya","Ethiopia","Ghana","Nigeria","Morocco","Sudan","Egypt"},
            {"","Japan","India","China","Thailand","South Korea","Vietnam","Nepal"},
            {"","United states","Canada","Brazil","Mexico","Argentina","Cuba","Peru"},
            {"","Germany","United Kingdom","Italy","France","Spain","Netherlands","Sweden"}};
    String [][] citiesA={{"Mombasa","Nairobi","Kisumu","Nakuru","Eldoret"},
            {"Addis Ababa","Mekelle","Gondar","Adama","Hawassa"},
            {"Accra","Kumsai","Tamale","Ashaiman","Sunyani"},
            {"Lagos","Kano","Ibadan","Benin City","Jos"},
            {"Casablanca","Fez","Tangier","Marrakesh","Meknes"},
            {"Omdurman","Khartoum","Nyala","Kassala","El-Gadarif"},
            {"Cairo","Alexandria","Giza","Suez","Luxor"},
            {"Tokyo","Osaka","Kyoto","Kumamoto","Sagamihara"},
            {"Mumbai","Delhi","Bangalore","Chennai","Kolkata"},
            {"Beijing","Tianjin","Anqing","Chaohu","Hefei"},
            {"Bangkok","Nonthaburi","Pak kret","Hat Yai","Phuket"},
            {"Andong","Ansan","Anseong","Anyang","Asan"},
            {"Chan Tho","Da Nang","Haiphong","Hanoi","Ho Chi Minh"},
            {"Katmandu","Pokhara","Lalitpur","BaharatPur","Birganj"},
            {"Los Angeles","Chicago","California","Texas","Ohio"},
            {"Toronto","Montreal","Calgary","Ottawa","Edmonton"},
            {"Rio","Salvador","Mananus","Curitiba","Porto Alegre"},
            {"Mexico city","Ecatepec","Guadalajara","Tijuana","Zapopan"},
            {"Buenos Aires","Cordoba","Rosairo","Mendoza","La Plata"},
            {"Havana","Santa Clara","Las Tunas","Bayamo","Matanzas"},
            {"Lima","Arequipa","Trujillo","Chiclayo","Piura"},
            {"Berlin","Hamburg","Munich","Bremen","Dresden"},
            {"Liverpool","London","Manchester","Lincoln","Lancaster"},
            {"Rome","Venice","Milan","Naples","Catania"},
            {"Lyon","Paris","Nice","Toulouse","Montpellier"},
            {"Madrid","Barcelona","Seville","Bilbao","Zaragoza"},
            {"Amsterdam","Leiden","Rotterdam","The Hague","Haarlem"},
            {"Stockholm","Arboga","Arvika","Sigtuna","Uppsala"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cont=(Spinner)findViewById(R.id.cont);
        countries=(Spinner)findViewById(R.id.countries);
        cities=(ListView)findViewById(R.id.cities);
        area=(TextView)findViewById(R.id.area);
        pop=(TextView)findViewById(R.id.pop);

        contA=getResources().getStringArray(R.array.cont);

        cont.setOnItemSelectedListener(this);
        countries.setOnItemSelectedListener(this);
        cities.setOnItemSelectedListener(this);

        ArrayAdapter<String> spAdp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,contA);
        cont.setAdapter(spAdp);

        countries.setAdapter(null);
        cities.setAdapter(null);




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?>  adapterView, View view, int pos, long rowId) {
        Spinner s1=(Spinner)adapterView;
        Spinner s2=(Spinner)adapterView;
        if(s1.getId()==R.id.cont){
            if(pos==0){
                countries.setAdapter(null);

            }
            else{
                ArrayAdapter<String> sp2Adp= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countryA[pos-1]);
                countries.setAdapter(sp2Adp);
                row=pos;
                countries.setOnItemSelectedListener(this);
            }
        }
        else if(s2.getId()==R.id.countries){
            if(pos==0){
                cities.setAdapter(null);

            }
            else{
                if(row==1) {
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos - 1]);
                    cities.setAdapter(lVAdp);
                    cities.setOnItemSelectedListener(this);
                }
                else if(row==2){
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos+7- 1]);
                    cities.setAdapter(lVAdp);
                    cities.setOnItemSelectedListener(this);
                }
                else if(row==3){
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos+14- 1]);
                    cities.setAdapter(lVAdp);
                    cities.setOnItemSelectedListener(this);
                }
                else if(row==4){
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos+21- 1]);
                    cities.setAdapter(lVAdp);
                    cities.setOnItemSelectedListener(this);
                }
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}