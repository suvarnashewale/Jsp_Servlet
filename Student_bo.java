package com.bin;

public class Student_bo {
	  private String id;
	  private String name;
	  private String age;
	  private String course;
	
	
	  
	  
	  public String getId() {
			return id;
		}
	  
		public void setId(String id) {
        this.id= id;
		}



	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getAge() {
		return age;
	}





	public void setAge(String age) {
		this.age = age;
	}





	public String getCourse() {
		return course;
	}





	public void setCourse(String course) {
		this.course = course;
	}





	@Override
	public String toString()
	{
		return "Student_bo [ id=" + id +", name=" + name + ", age=" + age + ", course="+ course +"]";	
	}




}
