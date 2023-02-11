package task;

public class SingleTonClass {

	public static void main(String[] args) {
	      Database dataBaseObject= Database.getInstance();
	      //System.out.println("Hash Code : "+dataBaseObject.hashCode());
	      dataBaseObject.getConnection();
	}
}

class Database {
	   private static Database databaseObject;
	   
	   private Database() {  
		   System.out.println("A private constructor that restricts creating objects outside of the class.");
	   }

	   public static Database getInstance() {
	      if(databaseObject == null) {
	         databaseObject = new Database();
	      }
	       return databaseObject;
	   }

	   public void getConnection() {
	       System.out.println("Singletons can be used while working with databases.");
	   }
	}
