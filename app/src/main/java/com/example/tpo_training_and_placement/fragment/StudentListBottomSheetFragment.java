package com.example.tpo_training_and_placement.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.adapters.StudentNotificationCardAdapter;
import com.example.tpo_training_and_placement.models.StudentNotificationCardModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentListBottomSheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentListBottomSheetFragment extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public ImageButton backPressImageButton;
    public RecyclerView studentDataRecyclerView;
    public StudentNotificationCardAdapter studentNotificationCardAdapter;

    public StudentListBottomSheetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment studentListBottomSheetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentListBottomSheetFragment newInstance(String param1, String param2) {
        StudentListBottomSheetFragment fragment = new StudentListBottomSheetFragment();
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list_bottom_sheet, container, false);

        backPressImageButton = view.findViewById(R.id.back_pressed_button);
        backPressImageButton.setOnClickListener(view1 -> onStop());

        studentDataRecyclerView = view.findViewById(R.id.id_recycler_view_in_fragment);
        studentDataRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<StudentNotificationCardModel> options =
                new FirebaseRecyclerOptions.Builder<StudentNotificationCardModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students"), StudentNotificationCardModel.class)
                        .build();

        studentNotificationCardAdapter = new StudentNotificationCardAdapter(options);
        studentDataRecyclerView.setAdapter(studentNotificationCardAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        studentNotificationCardAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        studentNotificationCardAdapter.stopListening();
    }
}