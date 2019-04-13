public class Mentor {
   private String company;
   private String name;
   private String position;
   private String linkedin;
   private String availability;
   
   public Mentor(String company, String name, String position, String linkedin, String availability) {
      this.company = company;
      this.name = name;
      this.position = position;
      this.linkedin = linkedin;
      this.availability = availability;
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
   
   public String getLinkedin() {
      return linkedin;
   }
   
   public String getAvailability() {
      return availability;
   }
}