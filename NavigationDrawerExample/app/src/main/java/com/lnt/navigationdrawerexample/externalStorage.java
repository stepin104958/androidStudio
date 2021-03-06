package com.lnt.navigationdrawerexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link externalStorage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class externalStorage extends Fragment {

    Button button_ExternalStorage;
    TextView display;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public externalStorage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment externalStorage.
     */
    // TODO: Rename and change types and number of parameters
    public static externalStorage newInstance(String param1, String param2) {
        externalStorage fragment = new externalStorage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_external_storage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        button_ExternalStorage=view.findViewById(R.id.button_ExternalStorage);

        display = view.findViewById(R.id.textView2);



        getParentFragmentManager().setFragmentResultListener("requestKey",this,new FragmentResultListener(){
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle){
                String result = bundle.getString("bundleKey");

                Toast.makeText(getContext(),result,Toast.LENGTH_LONG).show();

                display.setText(result);
            }
                });

        button_ExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final NavController navController = Navigation.findNavController(view);

                navController.navigate(R.id.action_nav_externalStorage_to_nav_home);


            }
        });
    }

}