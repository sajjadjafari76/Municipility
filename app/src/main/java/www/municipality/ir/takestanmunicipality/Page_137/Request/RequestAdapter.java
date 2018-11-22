package www.municipality.ir.takestanmunicipality.Page_137.Request;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import www.municipality.ir.takestanmunicipality.DataModel.ChildModel;
import www.municipality.ir.takestanmunicipality.DataModel.ParentModel;
import www.municipality.ir.takestanmunicipality.R;

public class RequestAdapter extends ExpandableRecyclerAdapter<Parent, Child> {

    private Context context;
    private List<ParentModel> parentModels;
    private List<ChildModel> childModels;

    public RequestAdapter(Context context, List<ParentObject> parentItemList,List<ParentModel> parentModel, List<ChildModel> childModel) {
        super(context, parentItemList);
        this.parentModels = parentModel;
        this.context = context;
        this.childModels = childModel;
    }

    @Override
    public Parent onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.parent_layout, viewGroup, false);
        return new Parent(view);
    }

    @Override
    public Child onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_layout, viewGroup, false);
        return new Child(view);
    }

    @Override
    public void onBindParentViewHolder(Parent parent, int i, Object o) {

        if (o instanceof ParentModel) {
            Log.e("check", "parent" + " | ");
        }else if (o instanceof ChildModel) {
            Log.e("check", "not parent" + " | " );
        }else {
            Log.e("check", "not" + " | " );
        }

        Log.e("parentmodel", i + " | " + parentModels.size());
        ParentModel parentModel = parentModels.get(1);
        parent.ProblemText.setText(parentModel.getContent());
        parent.TrackingCode.setText(parentModel.getTrackingCode());

    }

    @Override
    public void onBindChildViewHolder(Child child, int i, Object o) {
        Log.e("childModels", i + " | " + childModels.size());
        ChildModel childModel = childModels.get(0);

        child.Date.setText("پاسخ داده شده توسط واحد "  + childModel.getType() + " در تاریخ " + childModel.getResponse());
        child.Response.setText(childModel.getResponse());
        child.Info.setText("پاسخ داده شده توسط" + childModel.getInfo());

    }
}
