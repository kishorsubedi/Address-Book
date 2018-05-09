public class Person{
  String fname;
  String lname;
  String address;
  String phone;
  String city;
  String state;
  String zip;
  
  Person()
  {
    fname = "";
    lname = "";
    address = "";
    phone = "";
    city = "";
    state ="";
    zip = "";
  }
  
  Person(String fname, String lname, String address,String phone, String city, String state, String zip)
  {
    this.fname = fname;
    this.lname = lname;
    this.address = address;
    this.phone = phone;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }
  
  void printPerson()
  {
      System.out.println(fname+"\t"+lname+"\n");
      System.out.println(address+"\n");
      System.out.println(phone+"\n");
      System.out.println(city+"\n");
      System.out.println(state+"\n");
      System.out.println(zip+"\n\n");
  }
}