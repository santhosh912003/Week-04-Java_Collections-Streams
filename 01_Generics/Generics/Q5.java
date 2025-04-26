import java.util.*;


class Q5 {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

        resumeList.add(new Resume<>(new SoftwareEngineer("Rajesh Kumar")));
        resumeList.add(new Resume<>(new DataScientist("Sneha Mehta")));
        resumeList.add(new Resume<>(new ProductManager("Ankit Verma")));

        System.out.println("=== Individual Resume Processing ===\n");
        for (Resume<? extends JobRole> resume : resumeList) {
            resume.process();
        }

        System.out.println("\n=== Bulk Screening Pipeline ===\n");
        // Extract job roles for bulk screening
        List<JobRole> jobRoles = new ArrayList<>();
        for (Resume<? extends JobRole> resume : resumeList) {
            jobRoles.add(resume.getJobRole());
        }

        ScreeningSystem.processResumes(jobRoles);
    }
}

abstract class JobRole{
  protected String candidateName;
  
  
  public JobRole(String candidateName){
    this.candidateName = candidateName;
  }
  
  public abstract void screen();
  
  public String getCandidateName(){
    return candidateName;
  }
}


class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    public void screen() {
        System.out.println(candidateName + " screened for Software Engineer role: Checking coding skills, system design, and DSA.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }

    @Override
    public void screen() {
        System.out.println(candidateName + " screened for Data Scientist role: Checking statistics, ML models, and data wrangling.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }

    @Override
    public void screen() {
        System.out.println(candidateName + " screened for Product Manager role: Checking communication, product thinking, and leadership.");
    }
}

class Resume<T extends JobRole>{
  private T jobRole;
  
  public Resume(T jobRole){
    this.jobRole = jobRole;
  }
  
  public void process(){
    System.out.println("Process reume for: "+ jobRole.getCandidateName());
    jobRole.screen();
    System.out.println("--------------------------------------------------");
    
  }
  
  public T getJobRole(){
    return jobRole;
  }
}

class ScreeningSystem{
  public static void processResumes(List<? extends JobRole> candidates){
    for(JobRole j: candidates){
      System.out.println("AI Screening");
      j.screen();
      System.out.println(" ");
    }
  }
}

