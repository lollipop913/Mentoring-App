public class Mentee{
   private String name;
   private String company;
   private String position;
   
   public Mentee(String name, String company, String position) {
      this.name = name;
      this.company = company;
      this.position = position;
   }
   
   public String getCompany() {
      return company;
   }
   
   public String getName() {
      return name;
   }
   
   public String getPosition() {
      return position;
   }
   
   public void setCompany(String company){
      this.company = company;
   }
   
}