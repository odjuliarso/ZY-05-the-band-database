package com.zybooks.thebanddatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import java.util.List;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        LinearLayout layout = (LinearLayout) rootView;

        // Create the buttons using the band names and ids from BandRepository
        List<Band> bandList = BandRepository.getInstance(requireContext()).getBands();
        for (Band band : bandList) {
            Button button = new Button(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 0, 10);   // 10px bottom margin
            button.setLayoutParams(layoutParams);

            // Display band's name on button
            button.setText(band.getName());

            // Navigate to detail screen when clicked
            button.setOnClickListener(buttonView -> {
                Navigation.findNavController(buttonView).navigate(R.id.show_item_detail);
            });

            // Add button to the LinearLayout
            layout.addView(button);
        }

        Button button2 = new Button(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 10);   // 10px bottom margin
        button2.setLayoutParams(layoutParams);

        // Display band's name on button
        button2.setText("Settings");

        //Navigate to settings screen on clicked
        button2.setOnClickListener(buttonView -> {
            Navigation.findNavController(buttonView).navigate(R.id.action_list_fragment_to_settings_fragment);
        });

        // Add button to the LinearLayout
        layout.addView(button2);

        return rootView;
    }
}