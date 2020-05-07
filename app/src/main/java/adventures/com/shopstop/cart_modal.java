package adventures.com.shopstop;

public class cart_modal {

    public cart_modal(String name, String price, int pic){

        this.name=name;
        this.price=price;
        this.pic=pic;
    }

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

