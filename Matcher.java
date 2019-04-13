import java.util.*;

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
      for (String company : mentorMap.keySet()) {
         if (company.equalsIgnoreCase(mentee.getCompany())) {
            Set<Mentor> set = mentorMap.get(company);
            System.out.println("Available Mentors:");
            System.out.println();
            for (Mentor mentor : set) {
               System.out.println(mentor.getName());
               System.out.println("   Position:" + position);
               System.out.println("   LinkedIn:" + linkedin);
               System.out.println("   Availability:" + availability);
               System.out.println();
            }
         }
      }
   }
}
