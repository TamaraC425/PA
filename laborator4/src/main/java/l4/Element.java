package l4;

public class Element {
    private Resident resident;
    private Hospital hospital;

    public Element() {
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return '(' +
                "resident=" + resident +
                ", hospital=" + hospital +
                ')';
    }
}
