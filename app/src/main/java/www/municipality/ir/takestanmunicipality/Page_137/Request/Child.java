package www.municipality.ir.takestanmunicipality.Page_137.Request;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Child extends ChildViewHolder {

    public CustomTextView Date;
    public CustomTextView Response;
    public CustomTextView Info;


    public Child(View itemView) {
        super(itemView);


        Date = itemView.findViewById(R.id.Child_Date);
        Response = itemView.findViewById(R.id.Child_Response);
        Info = itemView.findViewById(R.id.Child_Info);


    }
}
