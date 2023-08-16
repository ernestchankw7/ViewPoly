package sg.edu.rp.c346.id22026341.viewpoly;

public class Poly {
    private int year;
    private String type_of_study;
    private int enrolment;

    public Poly(int year, String type_of_study, int enrolment) {
        this.year = year;
        this.type_of_study = type_of_study;
        this.enrolment = enrolment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType_of_study() {
        return type_of_study;
    }

    public void setType_of_study(String type_of_study) {
        this.type_of_study = type_of_study;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    @Override
    public String toString() {
        return "Poly{" +
                "year=" + year +
                ", type_of_study='" + type_of_study + '\'' +
                ", enrolment=" + enrolment +
                '}';
    }
}
