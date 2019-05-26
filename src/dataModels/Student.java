package dataModels;

public class Student {
    String name;
    boolean IsChecked = false;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return IsChecked;
    }

    public void setChecked(boolean checked) {
        IsChecked = checked;
    }
}

