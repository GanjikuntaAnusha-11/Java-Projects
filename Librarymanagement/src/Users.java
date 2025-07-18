public class Users {
    private String id;
    private String name;
    private String mobileNo;

    public Users(String id, String name, String mobileNo) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo(){
        return mobileNo;
    }
}
