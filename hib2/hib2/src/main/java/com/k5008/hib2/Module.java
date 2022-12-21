package com.k5008.hib2;
import javax.persistence.*;
import java.util.*;


@Entity
@Table (name ="MODULE")
public class Module 
{
    @Id
    @Column (name = "ID")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    @Column (name = "CODE")
    private String code;
    @Column (name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "modules", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Student> students;
    
    public Module ()
    {
        this("","");
    }
    public Module (String code, String name)
    {
        this.ID = -1;
        this.code = code;
        this.name = name;
        students = new HashSet<>();
    }

    public String getCode() {
        return code;
    }
   public void setID(int ID) {
        this.ID = ID;
    }


    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addStudent(Student s)
    {
        students.add(s);
    }
    public void removeStudent(Student s)
    {
        students.remove(s);
    }
    public String listStudents()
    {
        String result = toString()+ "\n has the following students \n";
        for(Student s : students)
            result += "   " + s.toString() +"\n"; 
        return result;
    }
    
   @Override
   public String toString()
   {
       return code + " " + name;
   }
   @Override
   public boolean equals(Object o)
   {
       if (o == null)
           return false;
       if (! (o instanceof Module))
           return false;
       if (!this.code.equals(((Module)o).code))  
          return false;
       return true;   
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.code);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.ID);
        return hash;
    }


    public int getID() {
        return ID;
    }


    public void setID(int ID, Object originator) {
        this.setID(ID);
    }

    public Set<Student> getStudents() {
        return students;
    }
}


