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
            {"8305000","1560","250000","39","190200","36","156000","21","416500","534"},
            {"158700","1590","716700","150","190000","554","5170000","7355","308000","542"},
            {"1280000","1430","1130000","1285","2028000","1520","8000000","3300","8990000","2060"},
            {"1440000","49","523000","464","513200","37","280000","433","204000","75"},
            {"3700000","1300","2695000","606","39512000","163600","28995800","695600","11689000","116000"},
            {"2700500","630","1700600","431","1200200","825","934000","2790","932500","767"},
            {"6718000","1220","2800000","693","2180000","11400","1900000","430","1400000","496"},
            {"8900000","1480","136000","86","1460100","151","1900000","637","1155000","893"},
            {"2891000","203","1391000","576","1270000","178","115000","54","765000","203"},
            {"2130000","728","242400","514","171000","891","222000","918","145000","317"},
            {"8800000","2600","1000000","69","919000","1100","552000","174","484000","621"},
            {"3700000","890","1800000","755","1400000","310","567000","326","556700","328"},
            {"498000","111","8900000","1572","552000","115","97500","35","52000","idk!"},
            {"4340000","1280","260000","414","1399000","181","967000","119","311500","182","311000","182"},
            {"516000","47","2140000","105","340000","71","479000","118","285000","56"},
            {"3200000","604","1620000","101","688000","140","345000","41","666880","973"},
            {"872680","219","124000","23","651000","324","544000","98","161000","32"},
            {"975000","188","10330","9","14000","10","8400","4","172000","48"}};

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
        if(row1==1){
            if(row2==1) {
                switch (i) {
                    case 0:
                        pop.setText(info[0][0]);
                        area.setText(info[0][1]);
                        break;
                    case 1:
                        pop.setText(info[0][2]);
                        area.setText(info[0][3]);
                        break;
                    case 2:
                        pop.setText(info[0][4]);
                        area.setText(info[0][5]);
                        break;
                    case 3:
                        pop.setText(info[0][6]);
                        area.setText(info[0][7]);
                        break;
                    case 4:
                        pop.setText(info[0][8]);
                        area.setText(info[0][9]);
                        break;
                }
            }
            else if(row2==2) {
                switch (i) {
                    case 0:
                        pop.setText(info[1][0]);
                        area.setText(info[1][1]);
                        break;
                    case 1:
                        pop.setText(info[1][2]);
                        area.setText(info[1][3]);
                        break;
                    case 2:
                        pop.setText(info[1][4]);
                        area.setText(info[1][5]);
                        break;
                    case 3:
                        pop.setText(info[1][6]);
                        area.setText(info[1][7]);
                        break;
                    case 4:
                        pop.setText(info[1][8]);
                        area.setText(info[1][9]);
                        break;
                }
            }
            else if(row2==3) {
                switch (i) {
                    case 0:
                        pop.setText(info[2][0]);
                        area.setText(info[2][1]);
                        break;
                    case 1:
                        pop.setText(info[2][2]);
                        area.setText(info[2][3]);
                        break;
                    case 2:
                        pop.setText(info[2][4]);
                        area.setText(info[2][5]);
                        break;
                    case 3:
                        pop.setText(info[2][6]);
                        area.setText(info[2][7]);
                        break;
                    case 4:
                        pop.setText(info[2][8]);
                        area.setText(info[2][9]);
                        break;
                }
            }
            else if(row2==4) {
                switch (i) {
                    case 0:
                        pop.setText(info[3][0]);
                        area.setText(info[3][1]);
                        break;
                    case 1:
                        pop.setText(info[3][2]);
                        area.setText(info[3][3]);
                        break;
                    case 2:
                        pop.setText(info[3][4]);
                        area.setText(info[3][5]);
                        break;
                    case 3:
                        pop.setText(info[3][6]);
                        area.setText(info[3][7]);
                        break;
                    case 4:
                        pop.setText(info[3][8]);
                        area.setText(info[3][9]);
                        break;
                }
            }
            else if(row2==5) {
                switch (i) {
                    case 0:
                        pop.setText(info[4][0]);
                        area.setText(info[4][1]);
                        break;
                    case 1:
                        pop.setText(info[4][2]);
                        area.setText(info[4][3]);
                        break;
                    case 2:
                        pop.setText(info[4][4]);
                        area.setText(info[4][5]);
                        break;
                    case 3:
                        pop.setText(info[4][6]);
                        area.setText(info[4][7]);
                        break;
                    case 4:
                        pop.setText(info[4][8]);
                        area.setText(info[4][9]);
                        break;
                }
            }
            else if(row2==6) {
                switch (i) {
                    case 0:
                        pop.setText(info[5][0]);
                        area.setText(info[5][1]);
                        break;
                    case 1:
                        pop.setText(info[5][2]);
                        area.setText(info[5][3]);
                        break;
                    case 2:
                        pop.setText(info[5][4]);
                        area.setText(info[5][5]);
                        break;
                    case 3:
                        pop.setText(info[5][6]);
                        area.setText(info[5][7]);
                        break;
                    case 4:
                        pop.setText(info[5][8]);
                        area.setText(info[5][9]);
                        break;
                }
            }
            else if(row2==7) {
                switch (i) {
                    case 0:
                        pop.setText(info[6][0]);
                        area.setText(info[6][1]);
                        break;
                    case 1:
                        pop.setText(info[6][2]);
                        area.setText(info[6][3]);
                        break;
                    case 2:
                        pop.setText(info[6][4]);
                        area.setText(info[6][5]);
                        break;
                    case 3:
                        pop.setText(info[6][6]);
                        area.setText(info[6][7]);
                        break;
                    case 4:
                        pop.setText(info[6][8]);
                        area.setText(info[6][9]);
                        break;
                }
            }
        }
        else if(row1==2){
            if(row2==1) {
                switch (i) {
                    case 0:
                        pop.setText(info[7][0]);
                        area.setText(info[7][1]);
                        break;
                    case 1:
                        pop.setText(info[7][2]);
                        area.setText(info[7][3]);
                        break;
                    case 2:
                        pop.setText(info[7][4]);
                        area.setText(info[7][5]);
                        break;
                    case 3:
                        pop.setText(info[7][6]);
                        area.setText(info[7][7]);
                        break;
                    case 4:
                        pop.setText(info[7][8]);
                        area.setText(info[7][9]);
                        break;
                }
            }
            else if(row2==2) {
                switch (i) {
                    case 0:
                        pop.setText(info[8][0]);
                        area.setText(info[8][1]);
                        break;
                    case 1:
                        pop.setText(info[8][2]);
                        area.setText(info[8][3]);
                        break;
                    case 2:
                        pop.setText(info[8][4]);
                        area.setText(info[8][5]);
                        break;
                    case 3:
                        pop.setText(info[8][6]);
                        area.setText(info[8][7]);
                        break;
                    case 4:
                        pop.setText(info[8][8]);
                        area.setText(info[8][9]);
                        break;
                }
            }
            else if(row2==3) {
                switch (i) {
                    case 0:
                        pop.setText(info[9][0]);
                        area.setText(info[9][1]);
                        break;
                    case 1:
                        pop.setText(info[9][2]);
                        area.setText(info[9][3]);
                        break;
                    case 2:
                        pop.setText(info[9][4]);
                        area.setText(info[9][5]);
                        break;
                    case 3:
                        pop.setText(info[9][6]);
                        area.setText(info[9][7]);
                        break;
                    case 4:
                        pop.setText(info[9][8]);
                        area.setText(info[9][9]);
                        break;
                }
            }
            else if(row2==4) {
                switch (i) {
                    case 0:
                        pop.setText(info[10][0]);
                        area.setText(info[10][1]);
                        break;
                    case 1:
                        pop.setText(info[10][2]);
                        area.setText(info[10][3]);
                        break;
                    case 2:
                        pop.setText(info[10][4]);
                        area.setText(info[10][5]);
                        break;
                    case 3:
                        pop.setText(info[10][6]);
                        area.setText(info[10][7]);
                        break;
                    case 4:
                        pop.setText(info[10][8]);
                        area.setText(info[10][9]);
                        break;
                }
            }
            else if(row2==5) {
                switch (i) {
                    case 0:
                        pop.setText(info[11][0]);
                        area.setText(info[11][1]);
                        break;
                    case 1:
                        pop.setText(info[11][2]);
                        area.setText(info[11][3]);
                        break;
                    case 2:
                        pop.setText(info[11][4]);
                        area.setText(info[11][5]);
                        break;
                    case 3:
                        pop.setText(info[11][6]);
                        area.setText(info[11][7]);
                        break;
                    case 4:
                        pop.setText(info[11][8]);
                        area.setText(info[11][9]);
                        break;
                }
            }
            else if(row2==6) {
                switch (i) {
                    case 0:
                        pop.setText(info[12][0]);
                        area.setText(info[12][1]);
                        break;
                    case 1:
                        pop.setText(info[12][2]);
                        area.setText(info[12][3]);
                        break;
                    case 2:
                        pop.setText(info[12][4]);
                        area.setText(info[12][5]);
                        break;
                    case 3:
                        pop.setText(info[12][6]);
                        area.setText(info[12][7]);
                        break;
                    case 4:
                        pop.setText(info[12][8]);
                        area.setText(info[12][9]);
                        break;
                }
            }
            else if(row2==7) {
                switch (i) {
                    case 0:
                        pop.setText(info[13][0]);
                        area.setText(info[13][1]);
                        break;
                    case 1:
                        pop.setText(info[13][2]);
                        area.setText(info[13][3]);
                        break;
                    case 2:
                        pop.setText(info[13][4]);
                        area.setText(info[13][5]);
                        break;
                    case 3:
                        pop.setText(info[13][6]);
                        area.setText(info[13][7]);
                        break;
                    case 4:
                        pop.setText(info[13][8]);
                        area.setText(info[13][9]);
                        break;
                }
            }
        }
        else if(row1==3){
            if(row2==1) {
                switch (i) {
                    case 0:
                        pop.setText(info[14][0]);
                        area.setText(info[14][1]);
                        break;
                    case 1:
                        pop.setText(info[14][2]);
                        area.setText(info[14][3]);
                        break;
                    case 2:
                        pop.setText(info[14][4]);
                        area.setText(info[14][5]);
                        break;
                    case 3:
                        pop.setText(info[14][6]);
                        area.setText(info[14][7]);
                        break;
                    case 4:
                        pop.setText(info[14][8]);
                        area.setText(info[14][9]);
                        break;
                }
            }
            else if(row2==2) {
                switch (i) {
                    case 0:
                        pop.setText(info[15][0]);
                        area.setText(info[15][1]);
                        break;
                    case 1:
                        pop.setText(info[15][2]);
                        area.setText(info[15][3]);
                        break;
                    case 2:
                        pop.setText(info[15][4]);
                        area.setText(info[15][5]);
                        break;
                    case 3:
                        pop.setText(info[15][6]);
                        area.setText(info[15][7]);
                        break;
                    case 4:
                        pop.setText(info[15][8]);
                        area.setText(info[15][9]);
                        break;
                }
            }
            else if(row2==3) {
                switch (i) {
                    case 0:
                        pop.setText(info[16][0]);
                        area.setText(info[16][1]);
                        break;
                    case 1:
                        pop.setText(info[16][2]);
                        area.setText(info[16][3]);
                        break;
                    case 2:
                        pop.setText(info[16][4]);
                        area.setText(info[16][5]);
                        break;
                    case 3:
                        pop.setText(info[16][6]);
                        area.setText(info[16][7]);
                        break;
                    case 4:
                        pop.setText(info[16][8]);
                        area.setText(info[16][9]);
                        break;
                }
            }
            else if(row2==4) {
                switch (i) {
                    case 0:
                        pop.setText(info[17][0]);
                        area.setText(info[17][1]);
                        break;
                    case 1:
                        pop.setText(info[17][2]);
                        area.setText(info[17][3]);
                        break;
                    case 2:
                        pop.setText(info[17][4]);
                        area.setText(info[17][5]);
                        break;
                    case 3:
                        pop.setText(info[17][6]);
                        area.setText(info[17][7]);
                        break;
                    case 4:
                        pop.setText(info[17][8]);
                        area.setText(info[17][9]);
                        break;
                }
            }
            else if(row2==5) {
                switch (i) {
                    case 0:
                        pop.setText(info[18][0]);
                        area.setText(info[18][1]);
                        break;
                    case 1:
                        pop.setText(info[18][2]);
                        area.setText(info[18][3]);
                        break;
                    case 2:
                        pop.setText(info[18][4]);
                        area.setText(info[18][5]);
                        break;
                    case 3:
                        pop.setText(info[18][6]);
                        area.setText(info[18][7]);
                        break;
                    case 4:
                        pop.setText(info[18][8]);
                        area.setText(info[18][9]);
                        break;
                }
            }
            else if(row2==6) {
                switch (i) {
                    case 0:
                        pop.setText(info[19][0]);
                        area.setText(info[19][1]);
                        break;
                    case 1:
                        pop.setText(info[19][2]);
                        area.setText(info[19][3]);
                        break;
                    case 2:
                        pop.setText(info[19][4]);
                        area.setText(info[19][5]);
                        break;
                    case 3:
                        pop.setText(info[19][6]);
                        area.setText(info[19][7]);
                        break;
                    case 4:
                        pop.setText(info[19][8]);
                        area.setText(info[19][9]);
                        break;
                }
            }
            else if(row2==7) {
                switch (i) {
                    case 0:
                        pop.setText(info[20][0]);
                        area.setText(info[20][1]);
                        break;
                    case 1:
                        pop.setText(info[20][2]);
                        area.setText(info[20][3]);
                        break;
                    case 2:
                        pop.setText(info[20][4]);
                        area.setText(info[20][5]);
                        break;
                    case 3:
                        pop.setText(info[20][6]);
                        area.setText(info[20][7]);
                        break;
                    case 4:
                        pop.setText(info[20][8]);
                        area.setText(info[20][9]);
                        break;
                }
            }
        }
        else if(row1==4){
            if(row2==1) {
                switch (i) {
                    case 0:
                        pop.setText(info[21][0]);
                        area.setText(info[21][1]);
                        break;
                    case 1:
                        pop.setText(info[21][2]);
                        area.setText(info[21][3]);
                        break;
                    case 2:
                        pop.setText(info[21][4]);
                        area.setText(info[21][5]);
                        break;
                    case 3:
                        pop.setText(info[21][6]);
                        area.setText(info[21][7]);
                        break;
                    case 4:
                        pop.setText(info[21][8]);
                        area.setText(info[21][9]);
                        break;
                }
            }
            else if(row2==2) {
                switch (i) {
                    case 0:
                        pop.setText(info[22][0]);
                        area.setText(info[21][1]);
                        break;
                    case 1:
                        pop.setText(info[22][2]);
                        area.setText(info[21][3]);
                        break;
                    case 2:
                        pop.setText(info[22][4]);
                        area.setText(info[21][5]);
                        break;
                    case 3:
                        pop.setText(info[22][6]);
                        area.setText(info[21][7]);
                        break;
                    case 4:
                        pop.setText(info[22][8]);
                        area.setText(info[22][9]);
                        break;
                }
            }
            else if(row2==3) {
                switch (i) {
                    case 0:
                        pop.setText(info[23][0]);
                        area.setText(info[23][1]);
                        break;
                    case 1:
                        pop.setText(info[23][2]);
                        area.setText(info[23][3]);
                        break;
                    case 2:
                        pop.setText(info[23][4]);
                        area.setText(info[23][5]);
                        break;
                    case 3:
                        pop.setText(info[23][6]);
                        area.setText(info[23][7]);
                        break;
                    case 4:
                        pop.setText(info[23][8]);
                        area.setText(info[23][9]);
                        break;
                }
            }
            else if(row2==4) {
                switch (i) {
                    case 0:
                        pop.setText(info[24][0]);
                        area.setText(info[24][1]);
                        break;
                    case 1:
                        pop.setText(info[24][2]);
                        area.setText(info[24][3]);
                        break;
                    case 2:
                        pop.setText(info[24][4]);
                        area.setText(info[24][5]);
                        break;
                    case 3:
                        pop.setText(info[24][6]);
                        area.setText(info[24][7]);
                        break;
                    case 4:
                        pop.setText(info[24][8]);
                        area.setText(info[24][9]);
                        break;
                }
            }
            else if(row2==5) {
                switch (i) {
                    case 0:
                        pop.setText(info[25][0]);
                        area.setText(info[25][1]);
                        break;
                    case 1:
                        pop.setText(info[25][2]);
                        area.setText(info[25][3]);
                        break;
                    case 2:
                        pop.setText(info[25][4]);
                        area.setText(info[25][5]);
                        break;
                    case 3:
                        pop.setText(info[25][6]);
                        area.setText(info[25][7]);
                        break;
                    case 4:
                        pop.setText(info[25][8]);
                        area.setText(info[25][9]);
                        break;
                }
            }
            else if(row2==6) {
                switch (i) {
                    case 0:
                        pop.setText(info[26][0]);
                        area.setText(info[26][1]);
                        break;
                    case 1:
                        pop.setText(info[26][2]);
                        area.setText(info[26][3]);
                        break;
                    case 2:
                        pop.setText(info[26][4]);
                        area.setText(info[26][5]);
                        break;
                    case 3:
                        pop.setText(info[26][6]);
                        area.setText(info[26][7]);
                        break;
                    case 4:
                        pop.setText(info[26][8]);
                        area.setText(info[26][9]);
                        break;
                }
            }
            else if(row2==7) {
                switch (i) {
                    case 0:
                        pop.setText(info[27][0]);
                        area.setText(info[27][1]);
                        break;
                    case 1:
                        pop.setText(info[27][2]);
                        area.setText(info[27][3]);
                        break;
                    case 2:
                        pop.setText(info[27][4]);
                        area.setText(info[27][5]);
                        break;
                    case 3:
                        pop.setText(info[27][6]);
                        area.setText(info[27][7]);
                        break;
                    case 4:
                        pop.setText(info[27][8]);
                        area.setText(info[27][9]);
                        break;
                }
            }
        }
    }
}
//END