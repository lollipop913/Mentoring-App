import java.util.*;
import java.io.*;
public class MentoringAppMain {

   public static void main(String[] args) throws FileNotFoundException {
      File file = new File("MentorData");
      Scanner sc = new Scanner(file);
      
      Map<String, Set<Mentor>> companyMentors = new HashMap<String, Set<Mentor>>();
      
      while (sc.hasNextLine()) {
         String name = sc.nextLine();
         String company = sc.nextLine().toLowerCase();
         Mentor mentor = new Mentor(company, name);
         if (!companyMentors.containsKey(company)) {
            companyMentors.put(company, new HashSet<Mentor>());
         }
         companyMentors.get(company).add(mentor);
      }
      
      for (String company: companyMentors.keySet()) {
         System.out.println("Company: " + company + " Mentors: " + companyMentors.get(company)); 
      }
      
      
      Scanner scan = new Scanner(System.in);
      System.out.println("Mentor or Mentee?");
      String input = scan.nextLine();
      
      while (!input.equalsIgnoreCase("quit")) {
         if (input.equalsIgnoreCase("mentor")) {
            System.out.println("Name?");
            String name = scan.nextLine();
            System.out.println("Company?");
            String company = scan.nextLine().toLowerCase();
            Mentor mentor = new Mentor(company, name);
            if (!companyMentors.containsKey(company)) {
               companyMentors.put(company, new HashSet<Mentor>());
            }
            companyMentors.get(company).add(mentor);
            System.out.println("company: " + company);
            System.out.println("mentors in company: " + companyMentors.get(company));
         } else if (input.equalsIgnoreCase("mentee")) {
            System.out.println("Name?");
            String name = scan.nextLine();
            System.out.println("Company?");
            String company = scan.nextLine();
            Mentee user = new Mentee(name, company);
            Matcher m = new Matcher(user, companyMentors);
            m.reduceList();
         } else {
            System.out.println("invalid input");
         }
         System.out.println("Mentor or Mentee?");
         input = scan.nextLine();
      }
      
   
   }

}
