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
    int row1,row2,choice;
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
            {"Can Tho","Da Nang","Haiphong","Hanoi","Ho Chi Minh"},
            {"Katmandu","Pokhara","Lalitpur","BaharatPur","Birganj"},
            {"Los Angeles","Chicago","California","Texas","Ohio"},
            {"Toronto","Montreal","Calgary","Ottawa","Edmonton"},
            {"Rio","Salvador","Mananus","Curitiba","Porto Alegre"},
            {"Mexico city","Acolman","Guadalajara","Tijuana","Zapopan"},
            {"Buenos Aires","Cordoba","Rosario","Mendoza","La Plata"},
            {"Havana","Santa Clara","Las Tunas","Bayamo","Matanzas"},
            {"Lima","Arequipa","Trujillo","Chiclayo","Piura"},
            {"Berlin","Hamburg","Munich","Bremen","Dresden"},
            {"Liverpool","London","Manchester","Lincoln","Lancaster"},
            {"Rome","Venice","Milan","Naples","Catania"},
            {"Lyon","Paris","Nice","Toulouse","Montpellier"},
            {"Madrid","Barcelona","Seville","Bilbao","Zaragoza"},
            {"Amsterdam","Leiden","Rotterdam","The Hague","Haarlem"},
            {"Stockholm","Arboga","Arvika","Sigtuna","Uppsala"}};
    String [][]infoA={{"1200000","295km^2"},{"4390000","696km^2"},{"397000","550km^2"},{"570000","123"},{"475000","-----"},
            {"3300000","527k^2"},{"310400","---__----"},{"299000","192km^2"},{"324000","1111"},{"315200","50km^2"},
            {"5000000","173"},{"3340000","254"},{"950000","750"},{"298000","idk"},{"208000","idk2"},
            {"8000000","1170km^2"},{"2280000","499"},{"2550000","3080"},{"1495000","1024"},{"873000","idk3"},
            {"3350000","220"},{"1200000","320"},{"947000","idk4"},{"928000","idk5"},{"632000","370"},
            {"2300000","614"},{"639000","1010"},{"564000","idk6"},{"419000","idk7"},{"360000","idk8"},
            {"9500000","3085"},{"5200000","2679"},{"8800000","1579"},{"744000","250"},{"506000","416"}};
   String [][] infoAs={{"13920000","2200"},{"2660000","223"},{"1475000","827"},{"738000","390"},{"720000","328"},
            {"12400000","603"},{"16780000","1500"},{"8440000","709"},{"7000000","426"},{"4500000","206"},
            {"21500000","16410"},{"15621000","12000"},{"5300000","13590"},{"859000","2063"},{"8000000","11434"},
            {"8305000","1560"},{"250000","39"},{"190200","36"},{"156000","21"},{"416500","534"},
            {"158700","1590"},{"716700","150"},{"190000","554"},{"5170000","7355"},{"308000","542"},
            {"1280000","1430"},{"1130000","1285"},{"2028000","1520"},{"8000000","3300"},{"8990000","2060"},
            {"1440000","49"},{"523000","464"},{"513200","37"},{"280000","433"},{"204000","75"}};
    String [][] infoAm={{"3700000","1300"},{"2695000","606"},{"39512000","163600"},{"28995800","695600"},{"11689000","116000"},
            {"2700500","630"},{"1700600","431"},{"1200200","825"},{"934000","2790"},{"932500","767"},
            {"6718000","1220"},{"2800000","693"},{"2180000","11400"},{"1900000","430"},{"1400000","496"},
            {"8900000","1480"},{"136000","86"},{"1460100","151"},{"1900000","637"},{"1155000","893"},
            {"2891000","203"},{"1391000","576"},{"1270000","178"},{"115000","54"},{"765000","203"},
            {"2130000","728"},{"242400","514"},{"171000","891"},{"222000","918"},{"145000","317"},
            {"8800000","2600"},{"1000000","69"},{"919000","1100"},{"552000","174"},{"484000","621"}};
    String [][] infoEu={{"3700000","890"},{"1800000","755"},{"1400000","310"},{"567000","326"},{"556700","328"},
            {"498000","111"},{"8900000","1572"},{"552000","115"},{"97500","35"},{"52000","idk!"},
            {"4340000","1280"},{"260000","414"},{"1399000","181"},{"967000","119"},{"311500","182"},{"311000","182"},
            {"516000","47"},{"2140000","105"},{"340000","71"},{"479000","118"},{"285000","56"},
            {"3200000","604"},{"1620000","101"},{"688000","140"},{"345000","41"},{"666880","973"},
            {"872680","219"},{"124000","23"},{"651000","324"},{"544000","98"},{"161000","32"},
            {"975000","188"},{"10330","9"},{"14000","10"},{"8400","4"},{"172000","48"}};

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
                row1=pos;
                countries.setOnItemSelectedListener(this);
            }
        }
        else if(s2.getId()==R.id.countries){
            if(pos==0){
                cities.setAdapter(null);

            }
            else{
                if(row1==1) {
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos - 1]);
                    cities.setAdapter(lVAdp);
                    row2= pos;
                    cities.setOnItemClickListener(this);
                }
                else if(row1==2){
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos+7- 1]);
                    cities.setAdapter(lVAdp);
                    row2= pos;
                    cities.setOnItemClickListener(this);
                }
                else if(row1==3){
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos+14- 1]);
                    cities.setAdapter(lVAdp);
                    row2= pos;
                    cities.setOnItemClickListener(this);
                }
                else if(row1==4){
                    ArrayAdapter<String> lVAdp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesA[pos+21- 1]);
                    cities.setAdapter(lVAdp);
                    row2= pos;
                    cities.setOnItemClickListener(this);
                }
            }
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(row1==1) {
            if (row2 == 1) choice = 0;
            else if (row2 == 2) choice = 5;
            else if (row2 == 3) choice = 10;
            else if (row2 == 4) choice = 15;
            else if (row2 == 5) choice = 20;
            else if (row2 == 6) choice = 25;
            else if (row2 == 7) choice = 30;
            pop.setText(infoA[choice+i][0]);
            area.setText(infoA[choice+i][1]);
        }
        else if(row1==2){
            if (row2 == 1) choice = 0;
            else if (row2 == 2) choice = 5;
            else if (row2 == 3) choice = 10;
            else if (row2 == 4) choice = 15;
            else if (row2 == 5) choice = 20;
            else if (row2 == 6) choice = 25;
            else if (row2 == 7) choice = 30;
            pop.setText(infoAs[choice+i][0]);
            area.setText(infoAs[choice+i][1]);
        }
        else if(row1==3){
            if (row2 == 1) choice = 0;
            else if (row2 == 2) choice = 5;
            else if (row2 == 3) choice = 10;
            else if (row2 == 4) choice = 15;
            else if (row2 == 5) choice = 20;
            else if (row2 == 6) choice = 25;
            else if (row2 == 7) choice = 30;
            pop.setText(infoAm[choice+i][0]);
            area.setText(infoAm[choice+i][1]);
        }
        else if(row1==4){
            if (row2 == 1) choice = 0;
            else if (row2 == 2) choice = 5;
            else if (row2 == 3) choice = 10;
            else if (row2 == 4) choice = 15;
            else if (row2 == 5) choice = 20;
            else if (row2 == 6) choice = 25;
            else if (row2 == 7) choice = 30;
            pop.setText(infoEu[choice+i][0]);
            area.setText(infoEu[choice+i][1]);
        }
    }
}
//END