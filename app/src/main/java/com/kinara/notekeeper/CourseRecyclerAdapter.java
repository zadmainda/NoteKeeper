package com.kinara.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder>{

    private final Context mContext;
    private final List<CourseInfo> mCourses;
    private final LayoutInflater mLayoutInflater;


    public CourseRecyclerAdapter(Context context, List<CourseInfo> courses) {
        mContext = context;
        mCourses = courses;
        mLayoutInflater = LayoutInflater.from(mContext);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_course_list, viewGroup, false);
        return new ViewHolder(itemView);
        // THIS FUNCTION differs from the one on the tutorial: Binding DATA to Recycler view > View Management with a recycler view 5m 3s
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {  //int i differs from tutorial's position
        CourseInfo course = mCourses.get(position);
        viewHolder.mTextCourse.setText(course.getTitle());
        viewHolder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextCourse;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextCourse = (TextView) itemView.findViewById(R.id.text_course);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, mCourses.get(mCurrentPosition).getTitle(),Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }
}
