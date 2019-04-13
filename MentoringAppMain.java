import java.util.*;
import java.io.*;
public class MentoringAppMain {

   public static void main(String[] args) throws FileNotFoundException {
      File file = new File("MentorData");
      Scanner sc = new Scanner(file);
      
      Map<String, Set<Mentor>> companyMentors = new HashMap<String, Set<Mentor>>();
      
      while (sc.hasNextLine()) {
         String name = sc.nextLine();
         String company = sc.nextLine();
         Mentor mentor = new Mentor(company, name);
         if (!companyMentors.containsKey(company)) {
            companyMentors.put(company, new HashSet<Mentor>());
         }
         companyMentors.get(company).add(mentor);
      }
      
      for (String company: companyMentors.keySet()) {
         System.out.println("Company: " + company + " Mentors: " + companyMentors.get(company)); 
      }
      
      Mentee user = new Mentee("Audrey", "Facebook");
      
   
   }

}