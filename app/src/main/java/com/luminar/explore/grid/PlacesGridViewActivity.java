package com.luminar.explore.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.luminar.explore.R;
import com.luminar.explore.ViewDetails.ViewDetailsActivity;

public class PlacesGridViewActivity extends AppCompatActivity {

    GridView gvPlaces;
    String[] name,url,country,address;
    double[] lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_grid_view);

        init();

        country = new String[]{
               "Italy", "Australia", "India", "Brazil", "Russia", "Paris", "Kuwait", "London",
                "Dubai", "Jordan", "Switzerland", "Malaysia"
        };

        name = new String[]{
                "Amalfi Coast","Sydney Opera House", "Taj Mahal",
                "Cristo Redentor", "St. Peterburg", "Eiffel Tower", "Kuwait Towers", "Tower Bridge",
                "Burj Khalifa", "The Great Temple", "The Matterhorn", "Petronas Twin Towers"
        };

        lat = new double[]{
                40.6333,33.8568,27.1751,22.9519,59.9311,48.8584,29.3759,51.5055,25.1972,30.3287,45.9766,3.1580
        };

        lon = new double[]{
                14.6029,151.2153,78.0421,43.2105,30.3609,2.2945,47.9774,0.0754,55.2744,35.4423,7.6585,101.7118
        };

        address = new String[]{
                "84011 Amalfi, Province of Salerno, Italy" ,
                "Bennelong Point, Sydney NSW 2000, Australia",
                "Dharmapuri, Forest Colony, Tajganj, Agra, Uttar Pradesh 282001",
                "Parque Nacional da Tijuca - Alto da Boa Vista, Rio de Janeiro - RJ, Brazil",
                "City in Russia",
                "Champ de Mars, 5 Av. Anatole France, 75007 Paris, France",
                "Kuwait City",
                "Tower Bridge Rd, London SE1 2UP, United Kingdom",
                "1 Sheikh Mohammed bin Rashid Blvd - Downtown Dubai - Dubai - United Arab Emirates",
                "8CHR+FWF, Wadi Musa, Jordan",
                "Mountain in Europe",
                "Concourse Level, Petronas Twin Tower, Lower Ground, Kuala Lumpur City Centre, 50088 Kuala Lumpur, Malaysia"
        };

        url = new String[]{
                "https://career-asset.com/wp-content/uploads/2021/02/Italybeautifulplaces.jpg",
                "https://2.bp.blogspot.com/-gTbNoBmuVsE/Vx4KJneCugI/AAAAAAAAAC4/mN9uZDfBKuIZpFQCSzvRYfBwVn6YqMfzQCLcB/s1600/0.jpg",
                "https://r9m8n7i9.stackpathcdn.com/wp-content/uploads/2015/07/taj-mahal-river-sunrise.png",
                "https://www.exoticca.com/uk/magazine/wp-content/uploads/2018/02/brasil.jpg",
                "https://www.anadolujet.com/documents/sehir_rehberi/moskova.jpg",
                "https://www.parisdigest.com/photos/view-paris-eiffel-tower.jpg",
                "https://www.myholidays.com/blog/content/images/2021/01/places-to-visit-in-Kuwait.jpg",
                "https://www.howerobinson.com/wp-content/uploads/2017/12/London-Sharpened2.jpg",
                "https://www.schindler.com/ae/internet/en/schindler-middle-east/_jcr_content/stage/image.1600068540717.transform/image_480/1600068557647.jpg",
                "https://www.nationsonline.org/gallery/Jordan/Wadi-Rum-landscape-Jordan.jpg",
                "https://img.traveltriangle.com/blog/wp-content/tr:w-700,h-400/uploads/2015/10/Matterhorn.jpg",
                "https://images.musement.com/cover/0001/45/petronas-twin-towers-jpg_header-44511.jpeg?q=50&fit=crop&auto=format&w=1024&h=400",

        };

        gvPlaces.setAdapter(new AdapterGridViewPlaces(getApplicationContext(),country,name,url));

        gvPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ViewDetailsActivity.class);
                intent.putExtra("name",name[i]);
                intent.putExtra("address",address[i]);
                intent.putExtra("country",country[i]);
                intent.putExtra("lat",lat[i]);
                intent.putExtra("lon",lon[i]);
                intent.putExtra("url",url[i]);
                startActivity(intent);
            }
        });
    }

    private void init(){
        gvPlaces = findViewById(R.id.gvPlaces);
    }

}