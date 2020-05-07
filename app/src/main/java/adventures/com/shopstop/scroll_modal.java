package adventures.com.shopstop;

public class scroll_modal {

    public scroll_modal(String name,int pic){
        this.name=name;
        this.pic=pic;
    }

    String name="";

    public String get_name(){return name;}
    public void setName (String name){this.name=name;}

    public int get_pic(){return pic;}
    public void setpic (int pic){this.pic=pic;}

    int pic;
}
