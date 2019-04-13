import java.util*;

public class Matcher {
   private Mentee mentee;
   private Map<String, Set<Mentor>> mentorMap;
   
   public Matcher(Mentee mentee, Map<String, Set<Mentor>> mentorMap) {
      this.mentee = mentee;
      this.mentorMap = mentorMap;
      if (!mentorMap.containsKey(mentee.getCompany())) {
         System.out.println("No mentors available");
      }
   }
   
   //Reduces and prints the list of available mentors based on mentee's company name 
   public void reduceList() {
      for (company : mentorMap.keySet()) {
         if (company.isEqual(mentee.getCompany())) {
            Set<Mentor> set = mentorMap.get(company);
            for (mentor : set) {
               System.out.println(mentor.getName());
            }
         }
      }
   }
}