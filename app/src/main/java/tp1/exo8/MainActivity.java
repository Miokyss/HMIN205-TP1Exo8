package tp1.exo8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] CITIES = new String[] {
                getString(R.string.valence), getString(R.string.montpellier), getString(R.string.paris), getString(R.string.lyon), getString(R.string.toulouse)
        };

        final Trajet[] TRAJETS = new Trajet[] {
                new Trajet(getString(R.string.valence),getString(R.string.montpellier),"12h52"),
                new Trajet(getString(R.string.valence),getString(R.string.montpellier),"13h05"),
                new Trajet(getString(R.string.montpellier), getString(R.string.valence),"14h32"),
                new Trajet(getString(R.string.lyon),getString(R.string.montpellier),"18h02"),
                new Trajet(getString(R.string.lyon),getString(R.string.montpellier),"02h52"),
                new Trajet(getString(R.string.paris),getString(R.string.montpellier),"17h41"),
                new Trajet(getString(R.string.paris),getString(R.string.toulouse),"06h52"),
                new Trajet(getString(R.string.valence),getString(R.string.toulouse),"16h52"),
                new Trajet(getString(R.string.valence),getString(R.string.paris),"15h52")
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, CITIES);
        AutoCompleteTextView startCity = findViewById(R.id.cities_list1);
        startCity.setAdapter(adapter);
        AutoCompleteTextView endCity = findViewById(R.id.cities_list2);
        endCity.setAdapter(adapter);

        Button searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout resultLayout = findViewById(R.id.result_layout);
                resultLayout.removeAllViews();

                String startCity =  ((AutoCompleteTextView) findViewById(R.id.cities_list1)).getText().toString();
                String endCity = ((AutoCompleteTextView) findViewById(R.id.cities_list2)).getText().toString();

                for(Trajet t : TRAJETS){
                    if(startCity.equals(t.startCity)&&endCity.equals(t.endCity)){
                        TextView trajet = new TextView(getApplicationContext());
                        trajet.setText(startCity+"-"+endCity+" : "+t.horaire);
                        resultLayout.addView(trajet);
                    }
                }

                if (resultLayout.getChildCount()==0){
                    TextView trajet = new TextView(getApplicationContext());
                    trajet.setText("Il n'y a pas de train pour ce trajet");
                    resultLayout.addView(trajet);
                }
            }
        });

    }

    private void displayResults(final LinearLayout grid,String start,String end){
        grid.removeAllViews();

    }
}