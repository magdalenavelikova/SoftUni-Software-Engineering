package definingClassesExercise.familyTree;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parentsList;
    private List<Person> childrenList;


    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

   public void addToParentList(Person person){
        if(isNew(person,parentsList)) {
            this.parentsList.add(person);
        }
   }
    public void addToChildrenList(Person person){
        if(isNew(person,childrenList)) {
            this.childrenList.add(person);
        }
    }
public boolean isNew(Person person, List<Person> personList){
    for (Person p : personList) {
        if(p.equals(person)){
            return false;
        }
    }
        return true;
}
    public void setChildrenList(List<Person> childrenList) {
        this.childrenList = childrenList;
    }

    public String getOutputForParents(List<Person> parentList) {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Parents:%n"));
        if (!parentList.isEmpty()) {
            for (Person parent : parentList) {
                output.append(String.format("%s %s%n", parent.getName(), parent.getBirthday()));
            }
        }
        return output.toString();
    }

    public String getOutputForChildren(List<Person> childList) {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Children:%n"));
        if (!childList.isEmpty()) {
            for (Person child : childList) {
                output.append(String.format("%s %s%n", child.getName(), child.getBirthday()));
            }
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s%s", name, String.join("/", birthday), getOutputForParents(parentsList), getOutputForChildren(childrenList));
    }
}
