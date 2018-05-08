public class Person{
  String fname;
  String lname;
  String address;
  String phone;
  
  Person()
  {
    fname = "";
    lname = "";
    address = "";
    phone = "";
  }
  
  Person(String fname, String lname, String address,String phone)
  {
    this.fname = fname;
    this.lname = lname;
    this.address = address;
    this.phone = phone;
  }
  
  void printPerson()
  {
      System.out.println(fname+"\t"+lname+"\n");
      System.out.println(address+"\n");
      System.out.println(phone+"\n\n");
  }
}