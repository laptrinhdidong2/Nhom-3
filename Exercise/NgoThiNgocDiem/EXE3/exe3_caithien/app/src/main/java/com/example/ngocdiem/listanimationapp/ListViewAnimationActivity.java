package com.example.ngocdiem.listanimationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewAnimationActivity extends AppCompatActivity {

    private  static final String TAG = "ListViewAnimationActivity";

    public static int animationItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);

        // create the pokemon info
        pokemon alakazam = new pokemon("Alakazam", R.drawable.alakazam);
        pokemon arbok = new pokemon("Arbok", R.drawable.arbok);
        pokemon arcanine = new pokemon("Arcanine", R.drawable.arcanine);
        pokemon blastoise = new pokemon("Blastoise", R.drawable.blastoise);
        pokemon bulbasaur = new pokemon("Bulbasaur", R.drawable.bulbasaur);

        pokemon charizard = new pokemon("Charizard", R.drawable.charizard);
        pokemon charmander = new pokemon("Charmander", R.drawable.charmander);
        pokemon charmeleon = new pokemon("Charmeleon", R.drawable.charmeleon);
        pokemon clefable = new pokemon("Clefable", R.drawable.clefable);
        pokemon cubone = new pokemon("Cubone", R.drawable.cubone);

        pokemon diglett = new pokemon("Diglett", R.drawable.diglett);
        pokemon ditto = new pokemon("Ditto", R.drawable.ditto);
        pokemon dragonair = new pokemon("Dragonair", R.drawable.dragonair);
        pokemon dratini = new pokemon("Dratini", R.drawable.dratini);
        pokemon eevee = new pokemon("Eevee", R.drawable.eevee);

        pokemon ekans = new pokemon("Ekans", R.drawable.ekans);
        pokemon farfetch = new pokemon("Farfetch", R.drawable.farfetch);
        pokemon golbat = new pokemon("Golbat", R.drawable.golbat);
        pokemon goldeen = new pokemon("Goldeen", R.drawable.goldeen);
        pokemon golem = new pokemon("Golem", R.drawable.golem);

        pokemon gyarados = new pokemon("Gyarados", R.drawable.gyarados);
        pokemon hitmonchan = new pokemon("Hitmonchan", R.drawable.hitmonchan);
        pokemon jolteon = new pokemon("Jolteon", R.drawable.jolteon);
        pokemon kakuna = new pokemon("Kakuna", R.drawable.kakuna);
        pokemon kangaskhan = new pokemon("Kangaskhan", R.drawable.kangaskhan);

        pokemon lickitung = new pokemon("Lickitung", R.drawable.lickitung);
        pokemon machamp = new pokemon("Machamp", R.drawable.machamp);
        pokemon magneton = new pokemon("Magneton", R.drawable.magneton);
        pokemon meowth = new pokemon("Meowth", R.drawable.meowth);
        pokemon metapod = new pokemon("Metapod", R.drawable.metapod);

        pokemon nidoking = new pokemon("Nidoking", R.drawable.nidoking);
        pokemon nidoran = new pokemon("Nidoran", R.drawable.nidoran);
        pokemon ninetales = new pokemon("Ninetales", R.drawable.ninetales);
        pokemon pidgey = new pokemon("Pidgey", R.drawable.pidgey);
        pokemon pikachu = new pokemon("Pikachu", R.drawable.pikachu);

        pokemon primeape = new pokemon("Primeape", R.drawable.primeape);
        pokemon raichu = new pokemon("Raichu", R.drawable.raichu);
        pokemon rhydon = new pokemon("Rhydon", R.drawable.rhydon);
        pokemon rhyhorn = new pokemon("Rhyhorn", R.drawable.rhyhorn);
        pokemon seel = new pokemon("Seel", R.drawable.seel);

        pokemon shellder = new pokemon("Shellder", R.drawable.shellder);
        pokemon slowpoke = new pokemon("Slowpoke", R.drawable.slowpoke);
        pokemon squirtle = new pokemon("Squirtle", R.drawable.squirtle);
        pokemon venusaur = new pokemon("Venusaur", R.drawable.venusaur);
        pokemon vulpix = new pokemon("Vulpix", R.drawable.vulpix);

        // add the pokemon objects to an arraylist
        ArrayList<pokemon> pokemonList = new ArrayList<>();

        pokemonList.add(alakazam);
        pokemonList.add(arbok);
        pokemonList.add(arcanine);
        pokemonList.add(blastoise);
        pokemonList.add(bulbasaur);

        pokemonList.add(charizard);
        pokemonList.add(charmander);
        pokemonList.add(charmeleon);
        pokemonList.add(clefable);
        pokemonList.add(cubone);

        pokemonList.add(diglett);
        pokemonList.add(ditto);
        pokemonList.add(dragonair);
        pokemonList.add(dratini);
        pokemonList.add(eevee);

        pokemonList.add(ekans);
        pokemonList.add(farfetch);
        pokemonList.add(golbat);
        pokemonList.add(goldeen);
        pokemonList.add(golem);

        pokemonList.add(gyarados);
        pokemonList.add(hitmonchan);
        pokemonList.add(jolteon);
        pokemonList.add(kakuna);
        pokemonList.add(kangaskhan);

        pokemonList.add(lickitung);
        pokemonList.add(machamp);
        pokemonList.add(magneton);
        pokemonList.add(meowth);
        pokemonList.add(metapod);

        pokemonList.add(nidoking);
        pokemonList.add(nidoran);
        pokemonList.add(ninetales);
        pokemonList.add(pidgey);
        pokemonList.add(pikachu);

        pokemonList.add(primeape);
        pokemonList.add(raichu);
        pokemonList.add(rhydon);
        pokemonList.add(rhyhorn);
        pokemonList.add(seel);

        pokemonList.add(shellder);
        pokemonList.add(slowpoke);
        pokemonList.add(squirtle);
        pokemonList.add(venusaur);
        pokemonList.add(vulpix);

        PokemonListAdapter adapter = new PokemonListAdapter(this, R.layout.adapter_listitem_layout, pokemonList);
        mListView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        animationItem = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
