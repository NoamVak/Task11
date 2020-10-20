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
            {"Accra","Kumasi","Tamale","Ashaiman","Sunyani"},
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
    String [][]info={{"1200000","295km^2","4390000","696km^2","397000","550km^2","570000","123","475000","-----"},
            {"3300000","527k^2","310400","---__----","299000","192km^2","324000","1111","315200","50km^2"},
            {"5000000","173","3340000","254","950000","750","298000","idk","208000","idk2"},
            {"8000000","1170km^2","2280000","499","2550000","3080","1495000","1024","873000","idk3"},
            {"3350000","220","1200000","320","947000","idk4","928000","idk5","632000","370"},
            {"2300000","614","639000","1010","564000","idk6","419000","idk7","360000","idk8"},
            {"9500000","3085","5200000","2679","8800000","1579","744000","250","506000","416"},
            {"13920000","2200","2660000","223","1475000","827","738000","390","720000","328"},
            {"12400000","603","16780000","1500","8440000","709","7000000","426","4500000","206"},
            {"21500000","16410","15621000","12000","5300000","13590","859000","2063","8000000","11434"},
            {}};

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