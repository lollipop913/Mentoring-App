import java.util.*;
import java.io.*;
public class MentoringAppMain {

   public static void main(String[] args) throws FileNotFoundException {
      File file = new File("MentorData");
      Scanner sc = new Scanner(file);
      
      Map<String, Set<Mentor>> companyMentors = new HashMap<String, Set<Mentor>>();
      
      while (sc.hasNextLine()) {
         String info = sc.nextLine();
         String[] splitInfo = info.split(":");
         String name = splitInfo[0];
         String company = splitInfo[1];
         String position = splitInfo[2];
         String linkedin = splitInfo[3];
         String availability = splitInfo[4];
         Mentor mentor = new Mentor(company, name, position, linkedin, availability);
         if (!companyMentors.containsKey(company)) {
            companyMentors.put(company, new HashSet<Mentor>());
         }
         companyMentors.get(company).add(mentor);
      }
      
      /*for (String company: companyMentors.keySet()) {
         System.out.println("Company: " + company + " Mentors: " + companyMentors.get(company)); 
      }*/
      
      Mentee user = new Mentee("Audrey", "Microsoft");
      Matcher m = new Matcher(user, companyMentors);
      m.reduceList();
      
   
   }

}
