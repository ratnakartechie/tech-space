package com.test.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

public class StudentLambda {
	
	List<Student> students=new ArrayList<>();
	
	StudentLambda()
	{
		Student s1=new Student();
		s1.setStudentId("S1");
		s1.setStudentName("Rajiv");
		s1.setCourse("Java");
		students.add(s1);
		
		Student s2=new Student();
		s2.setStudentId("S2");
		s2.setStudentName("Harish");
		s2.setCourse("Java");
		students.add(s2);

		
		Student s3=new Student();
		s3.setStudentId("S3");
		s3.setStudentName("Jayant");
		s3.setCourse("Dot Net");
		students.add(s3);		
		
	}
	
	public static void main(String[] args)
	{
		StudentLambda studList=new StudentLambda();
		studList.students.stream()	
		.filter(s->s.getCourse().equalsIgnoreCase("Java"))
		.forEach(student-> System.out.println(student.getStudentName()));
	}
	
	
	

}
