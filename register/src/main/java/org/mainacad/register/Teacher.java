package org.mainacad.register;

public class Teacher {
    private String firstName, lastName;
    private int id;

    public Teacher(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (getId() != teacher.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(teacher.getFirstName()) : teacher.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(teacher.getLastName()) : teacher.getLastName() != null)
            return false;
        return true;
    }
}
