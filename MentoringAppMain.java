import java.util.*;
import java.io.*;
public class MentoringAppMain {

   public static void main(String[] args) throws FileNotFoundException, IOException {
      System.out.println("Welcome to Mentor Match!");
      
      File file = new File("MentorData");
      Scanner sc = new Scanner(file);
      
      Map<String, Set<Mentor>> companyMentors = new HashMap<String, Set<Mentor>>();
      
      while (sc.hasNextLine()) {
         String info = sc.nextLine();
         String[] splitInfo = info.split(":");
         String name = splitInfo[0];
         String company = splitInfo[1].toLowerCase();
         String position = splitInfo[2];
         String linkedin = splitInfo[3];
         String availability = splitInfo[4];
         Mentor mentor = new Mentor(company, name, position, linkedin, availability);
         if (!companyMentors.containsKey(company)) {
            companyMentors.put(company, new HashSet<Mentor>());
         }
         companyMentors.get(company).add(mentor);
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
            System.out.println("Position?");
            String position = scan.nextLine();
            System.out.println("LinkedIn?");
            String linkedin = scan.nextLine();
            System.out.println("Number of meetings per month?");
            String availability = scan.nextLine();
            
            Mentor mentor = new Mentor(company, name, position, linkedin, availability);
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String mentorInfo = name + ":" + company + ":" + position + ":" + linkedin + ":" + availability + " times per month";
            writer.newLine();
            writer.append(mentorInfo);
            writer.close();
            
            
            if (!companyMentors.containsKey(company)) {
               companyMentors.put(company, new HashSet<Mentor>());
            }
            companyMentors.get(company).add(mentor);
         } else if (input.equalsIgnoreCase("mentee")) {
            System.out.println("Name?");
            String name = scan.nextLine();
            System.out.println("Company?");
            String company = scan.nextLine().toLowerCase();
            System.out.println("Position?");
            String position = scan.nextLine();
            Mentee user = new Mentee(name, company, position);
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
