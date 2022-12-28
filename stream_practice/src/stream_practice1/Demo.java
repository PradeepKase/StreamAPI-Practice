package stream_practice1;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Demo {
public static void main(String[] args) {
	List<Student> students=new ArrayList<>();
	
	students.add(new Student(1,"pradeep",88));
	students.add(new Student(2,"paddu",90));
	students.add(new Student(3,"chandru",99));
	students.add(new Student(4,"singh",75));
	students.add(new Student(6,"laddu",63));
	students.add(new Student(7,"akash",99));
	students.add(new Student(8,"sudhir",89));
	students.add(new Student(10,"pradeep",88));
	
	// get the list of students whose marks is greater then 90
	//using java
//	Stream<Student> str1=students.stream();
//	Stream<Student> str2=str1.filter(s->s.getMarks()>90);
//	List<Student> filtered_students= str2.collect(Collectors.toList());
//	filtered_students.forEach(s->System.out.println(s));
	
    //	 System.out.println(filtered_students);

	
	
	
	
	//Usig functional programming here  flterd by name also
	System.out.println("Usig functional programming here  flterd by name also");
	List<Student>fs= students.stream().filter(s->s.getMarks()>80 && s.getName()=="pradeep").collect(Collectors.toList());
	fs.forEach(s->System.out.println(s));
	
	
	
	
	//update all student marks by 5marks
	System.out.println("update all student marks by 5marks");
	// to do this we use map() function
	List<Student> updatedstudents= students.stream().map(s->new Student(s.getRoll(),s.getName(),s.getMarks()+5)).collect(Collectors.toList());
	updatedstudents.forEach(s->System.out.println(s));
	
	
	
	
	
	//min and max method
	//these methods are also terminal methods which will take a comparator object using which we can decide min&max
	//This min & max method will return minmum & maximum value object in the form of Optional class object.
	//This class is introduced in java8 to avoid NULL POINT EXCEPTIONS .
	//To get the element form Optional class, we need call get() method.
	
	//ex: to get the minimum marks of the student
	System.out.println("to get the minimum marks of the student");
	Optional<Student> OS =students.stream().min( (s1,s2) -> s1.getMarks() > s2.getMarks() ? +1 :-1);
	Student minmarks_students=OS.get();
	System.out.println(minmarks_students);
	
	
	System.out.println("to get the maximum marks of the student");
	
		Optional<Student>	opt=students.stream().max((s1,s2)->s1.getMarks() > s2.getMarks()? +1 : -1);
		Student maxmarks_student= opt.get();
		System.out.println(maxmarks_student);
		
		
		
		//Count()
	//this is q terminal method and return long 
	//ex: Count the students whose marks is less then 80
		
		long scount=students.stream().filter(s->s.getMarks()<80).count();
		System.out.println(scount);
		
		
		
		
		
		//Allmatch(), anymatch(),nonMATCH();
		// This method will return boolean output
		//EX: find is there student whose marks is >120?
		
		boolean b=students.stream().anyMatch(s->s.getMarks()>90);
		System.out.println(b);
		
		
		boolean b2=	students.stream().allMatch(s->s.getMarks()<60);
		System.out.println(b2);
		
		boolean b3=students.stream().noneMatch(s->s.getMarks()<400);
		System.out.println(b3);
		

		
		
		
		
		// sorting student by marks 
		Collections.sort(students,new Comparator<Student>() {
			
			public int compare(Student s1, Student s2) {
				if(s1.getMarks()< s2.getMarks()) {
				return -1;
				}
				else {
				return +1;
				}
			}
		});
		
		System.out.println(students);
		
}

}
