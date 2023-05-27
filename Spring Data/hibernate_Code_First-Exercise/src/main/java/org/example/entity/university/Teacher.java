package org.example.entity.university;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{
   private String email;
   private double salaryPerHour;
   private Set<Course> courses;

   public Teacher() {
      courses=new HashSet<>();
   }

   @OneToMany(mappedBy = "teacher")
   public Set<Course> getCourses() {
      return courses;
   }

   public void setCourses(Set<Course> courses) {
      this.courses = courses;
   }

   @Column(nullable = false)
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
@Column(name = "salary_per_hour")
   public double getSalaryPerHour() {
      return salaryPerHour;
   }

   public void setSalaryPerHour(double salaryPerHour) {
      this.salaryPerHour = salaryPerHour;
   }
}
