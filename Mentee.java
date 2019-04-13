public class Mentee{
   private String name;
   private String company;
   
   public Mentee(String name, String company) {
      this.name = name;
      this.company = company;
   }
   
   public String getCompany() {
      return company;
   }
   
   public String getName() {
      return name;
   }
   
   public void setCompany(String company){
      this.company = company;
   }
   
}