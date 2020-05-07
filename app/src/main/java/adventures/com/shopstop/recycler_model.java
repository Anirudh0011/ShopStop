package adventures.com.shopstop;

public class recycler_model {

    public recycler_model(String Pid, String name, String price, int pic){

        this.Pid=Pid;
        this.name=name;
        this.price=price;
        this.pic=pic;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    String Pid="";
    String name="";

    public String getName(){
        return name;
    }
    public void setName (String name) {
        this.name=name;
    }



    public String getPrice () {
        return price;
    }
    public void setPrice (String Price) {
        this.price=price;
    }



    public int getPic(){
        return pic;
    }

    public void setPic(int pic){
        this.pic=pic;
    }

    String price="";
    int pic;
}