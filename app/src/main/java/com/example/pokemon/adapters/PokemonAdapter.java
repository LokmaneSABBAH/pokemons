package com.example.pokemon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemon.R;
import com.example.pokemon.model.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>{

    private ArrayList<Pokemon> pokemonList = new ArrayList<>();
    private Context mContext;

    public PokemonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.PokemonViewHolder holder, int position) {

        holder.pokemonNameTextView.setText(pokemonList.get(position).getName());

        Glide.with(mContext).load(pokemonList.get(position).getUrl())
                .into(holder.pokemonImageView);

    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private ImageView pokemonImageView;
        private TextView pokemonNameTextView;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImageView = itemView.findViewById(R.id.pokemonImageView);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
        }
    }

    public void setList(ArrayList<Pokemon> list){
        this.pokemonList = list;
    }

    public Pokemon getPokemonAt(int position){
        return pokemonList.get(position);
    }
}
