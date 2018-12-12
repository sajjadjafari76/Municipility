package www.municipality.ir.takestanmunicipality.DataModel;

public class ChildModel {

    private String Date;
    private String Response;
    private String Info;
    private String Type;

    public ChildModel(String Date, String Response, String Info, String Type) {
        this.Date = Date;
        this.Response = Response;
        this.Info = Info;
        this.Type = Type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getResponse() {
        return Response;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
