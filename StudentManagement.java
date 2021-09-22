import java.util.HashSet;
import java.util.Scanner;
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

    public String studentsByGroup() {
        String[] for_group = new String[100];
        int size = sizeManagement;
        Set<String> str = new HashSet<String>();
        for (int i = 0; i < size; ++i) {
            if (for_group[0] != this.students[i].getGroup()) {
                str.add(this.students[i].getGroup());
            }
        }
        for_group = str.toArray(for_group);
        String for_return = "";
        int i = 0;
        while (for_group[i] != null) {
            for_return += for_group[i] + "\n";
            for (int j = 0; j < size; ++j) {
                if (for_group[i].equals(this.students[j].getGroup())) {
                    for_return += this.students[j].getInfo() + "\n";
                }
            }
            i++;
        }
        return for_return;
    }

    public void removeStudent(String id) {
        int size = sizeManagement;
        for (int i = 0; i < size; ++i) {
            if (this.students[i].getId().equals(id)) {
                this.students[i].setGroup("");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Student[] s = new Student[100];
        StudentManagement studentManage = new StudentManagement();

        for (int i = 0; i < n; ++i) {
            s[i] = new Student();
            s[i].setName(scanner.next());
            s[i].setId(scanner.next());
            s[i].setGroup(scanner.next());
            s[i].setEmail(s[i].getId() + "@vnu.edu.vn");
            studentManage.addStudent(s[i]);
        }

        scanner.close();

        for (int i = 0; i < n; ++i) {
            System.out.println(s[i].getInfo());
        }
        // studentManage.removeStudent("2002");
        System.out.println(studentManage.studentsByGroup());
    }
}