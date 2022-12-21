
package com.k5008.hib2;

import javax.persistence.*;
import java.util.*;
import javax.persistence.GeneratedValue;

@Entity
@Table (name ="STUDENT")
public class Student {
    @Id
    @Column (name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    @Column (name = "NAME")
    private String name;
    @ManyToMany(targetEntity=Module.class,cascade=CascadeType.ALL)
    @JoinTable(
            name="STUMOD",
            joinColumns={@JoinColumn(name="STUID",referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name="MODID",referencedColumnName="ID")}
    ) 
    private Set<Module> modules;
//)
    
    public Student()
    {
        this("");
    }
    public Student( String name)
    {
        this.ID = -1;
        this.name = name;
        modules = new HashSet<>();
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
             this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addModule(Module m)
    {
        getModules().add(m);
    }
    public void removeModule(Module m)
    {
        getModules().remove(m);
    }
    public String listModules()
    {
        String result = ID + " " + name + "\n is on the folloing modules \n";
        for(Module m : getModules()) 
            result += "   "+ m.toString() + "\n";
        return result;
    }
    @Override
    public String toString()
    {
        return ID + " " + name + listModules(); 
    }
    @Override
    public boolean equals(Object o)
    {
       if (o == null)
           return false;
       if (! (o instanceof Student))
           return false;
       int otherID = ((Student)o).ID;
       if (!( this.ID == otherID) ) 
          return false;
       return true;     
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.ID;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }
    public Set<Module> getModules() {
        return modules;
    }
    
    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
