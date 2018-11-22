package www.municipality.ir.takestanmunicipality.Page_137.Request;

import android.view.View;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Parent extends ParentViewHolder {

    public CustomTextView ProblemText;
    public CustomTextView TrackingCode;

    public Parent(View itemView) {
        super(itemView);

        ProblemText = itemView.findViewById(R.id.Parent_Content);
        TrackingCode = itemView.findViewById(R.id.Parent_Code);

    }
}
