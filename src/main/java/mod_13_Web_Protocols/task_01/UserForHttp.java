package mod_13_Web_Protocols.task_01;

public class UserForHttp {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return "\n{" +
                "\n  id: " + id +
                "\n  name: \"" + name + '\"' +
                "\n  username: \"" + username + '\"' +
                "\n  email: \"" + email + '\"' +
                "\n  address: " + address +
                "\n  phone: \"" + phone + '\"' +
                "\n  website: \"" + website + '\"' +
                "\n  company: " + company +
                "\n}";
    }
}

class Address{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Override
    public String toString() {
        return "{" +
                "\n    street: \"" + street + '\"' +
                "\n    suite: \"" + suite + '\"' +
                "\n    city: \"" + city + '\"' +
                "\n    zipcode: \"" + zipcode + '\"' +
                "\n    geo: " + geo +
                "\n  }";
    }
}

class Company{
    private String name;
    private String catchPhrase;
    private String bs;

    @Override
    public String toString() {
        return "{" +
                "\n    name: \"" + name + '\"' +
                "\n    catchPhrase: \"" + catchPhrase + '\"' +
                "\n    bs: \"" + bs + '\"' +
                "\n  }";
    }
}

class Geo{
    private String lat;
    private String lng;

    @Override
    public String toString() {
        return "{" +
                "\n      lat:\"" + lat + '\"' +
                "\n      lng:\"" + lng + '\"' +
                "\n    }";
    }
}