package com.cornez.shippingcalculator;

class ToDo_Item {

    //MEMBER ATTRIBUTES
    private int _id;
    private String description = "";
    private int is_done = 0;

    private String name;
    private double kneeLen = 0;
    private int age = 0;
    private double height = 0;
    private int gender = 1;
    private double weight = 0;
    private int __activity = 0;
    private int isinput = 1;

    public ToDo_Item() {}
    public ToDo_Item(int id, String desc, int done)
    {
        _id = id;
        description = desc;
        is_done = done;
    }
    public ToDo_Item(int id, String n, int g, int is)
    {
        _id = id;
        description = name = n;
        gender = g;
        isinput = is;
    }

    public int getId() { return _id; }
    public void setId(int id) { _id = id; }

    public String getDescription () { return description; }
    public void setDescription (String desc) { description = desc; }

    public int getIs_done() { return is_done; }
    public void setIs_done(int done) { is_done = done; }

    public String getName() { return name; }
    public void setName(String n) { name = n; }

    public double getKneeLen() { return kneeLen; }
    public void setKneeLen(double nl) { kneeLen = nl; }

    public int getAge() { return age; }
    public void setAge(int a) { age = a; }

    public double getHeight() { return height; }
    public void setHeight(double h) { height = h; }

    public int getGender() { return gender; }
    public void setGender(int g) { gender = g; }

    public double getWeight() { return weight; }
    public void setWeight(double w) { weight = w; }

    public int getActivity() { return __activity; }
    public void setActivity(int a) { __activity = a; }

    public int getIsinput() { return isinput; }
    public void setIsinput(int i) { isinput = i; }
}
