import java.util.HashSet;
import java.util.Set;

public class StudentManagement {
    Student[] students = new Student[100];
    int sizeManagement = 0;

    public void addStudent(Student newStudent) {
        students[sizeManagement] = newStudent;
        sizeManagement++;
    }

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }
    
    /**
    * This is studentsByGroup.
    * @return tra ve ket qua String
    */
    public String studentsByGroup() {
        String[] forGroup = new String[100];
        int size = sizeManagement;
        Set<String> str = new HashSet<String>();
        for (int i = 0; i < size; ++i) {
            if (forGroup[0] != this.students[i].getGroup()) {
                str.add(this.students[i].getGroup());
            }
        }

        forGroup = str.toArray(forGroup);
        int index = str.size() - 1;
        String forReturn = "";

        while (index >= 0) {
            forReturn += forGroup[index] + "\n";
            for (int j = 0; j < size; ++j) {
                if (forGroup[index].equals(this.students[j].getGroup())) {
                    forReturn += this.students[j].getInfo() + "\n";
                }
            }
            index--;
        }
        return forReturn;
    }
    
    /**
    * This is removeStudent method.
    * @param id so sanh id 
    */
    public void removeStudent(String id) {
        int size = sizeManagement;
        for (int i = 0; i < size; ++i) {
            if (this.students[i].getId().equals(id)) {
                for (int j = i; j < size - 1; ++j) {
                    students[j] = students[j + 1];
                }
            }
        }
        sizeManagement--;
    }

    public static void main(String[] args) {

    }
}