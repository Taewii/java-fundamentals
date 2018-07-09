package p03_Mankind;

public class Student extends Human {
    private String facNumber;

    Student(String firstName, String lastName, String facNumber) {
        super(firstName, lastName);
        this.setFacNumber(facNumber);
    }

    private String getFacNumber() {
        return facNumber;
    }

    private void setFacNumber(String facNumber) {
        if (facNumber.length() > 5 && facNumber.length() < 10) {
            this.facNumber = facNumber;
        } else {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(super.getFirstName()).append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName()).append(System.lineSeparator())
                .append("Faculty number: ").append(this.getFacNumber()).append(System.lineSeparator());

        return sb.toString();
    }
}
