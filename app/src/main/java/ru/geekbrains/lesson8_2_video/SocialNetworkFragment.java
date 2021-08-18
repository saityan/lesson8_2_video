package ru.geekbrains.lesson8_2_video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SocialNetworkFragment extends Fragment {
    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        //String[] data = getResources().getStringArray(R.array.test_title);
        CardSource data = new CardSourceImplementation(getResources()).init();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(data);
        socialNetworkAdapter.setMyOnClickListener(new MyOnClickListener() {
            @Override
            public void onMyClick(View view, int position) {
                Toast.makeText(getContext(), "Тяжелая обработка для " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(socialNetworkAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }
}
