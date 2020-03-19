package l4;

import java.util.*;
import java.util.stream.Collectors;

public class Matching {
    private List<Resident> residents = new ArrayList<>();
    private List<Hospital> hospitals = new ArrayList<>();
    private Map<Resident, List<Hospital>> residentPrefMap = new HashMap<>();
    private Map<Hospital, List<Resident>> hospitalPreMap = new TreeMap<>();
    private List<Element> pairs = new ArrayList<>();

    public Matching(List<Resident> residents, List<Hospital> hospitals, Map<Resident, List<Hospital>> residentPrefMap, Map<Hospital, List<Resident>> hospitalPreMap) {
        this.residents = residents;
        this.hospitals = hospitals;
        this.residentPrefMap = residentPrefMap;
        this.hospitalPreMap = hospitalPreMap;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public Map<Resident, List<Hospital>> getResidentPrefMap() {
        return residentPrefMap;
    }

    public void setResidentPrefMap(Map<Resident, List<Hospital>> residentPrefMap) {
        this.residentPrefMap = residentPrefMap;
    }

    public Map<Hospital, List<Resident>> getHospitalPreMap() {
        return hospitalPreMap;
    }

    public void setHospitalPreMap(Map<Hospital, List<Resident>> hospitalPreMap) {
        this.hospitalPreMap = hospitalPreMap;
    }

    public void addElement(Element e) {
        pairs.add(e);
    }

    public void solution() {
        for (Resident resident : residents) {
            List<Hospital> residentPref = new ArrayList<>();
            residentPref = residentPrefMap.get(resident);
            int findResident = 0;
            if (residentPref.size() != 0)
                for (Hospital hospital : residentPref) {
                    if (hospital.getCapacity() > 0) {
                        List<Resident> hospitalPref = new ArrayList<>();
                        hospitalPref = hospitalPreMap.get(hospital);
                        if (hospitalPref.size() != 0) {
                            for (Resident r : hospitalPref)
                                if (resident == r) {
                                    findResident = 1;
                                    break;
                                }
                        }
                        if (findResident == 1) {
                            Element element = new Element();
                            element.setHospital(hospital);
                            element.setResident(resident);
                            addElement(element);
                            int aux = hospital.getCapacity() - 1;
                            hospital.setCapacity(aux);
                            break;
                        }
                    }
                }
        }
    }

    public void printResult() {
        solution();
        for (Element e : pairs)
            System.out.println(e);

    }

    public void verifyStableMatching() {
        solution();
        int temp = 0;
        for (Element element : pairs) {
            Hospital hospital = new Hospital();
            hospital = element.getHospital();
            Resident resident = new Resident();
            resident = element.getResident();
            List<Hospital> residentChoices = new ArrayList<>();
            residentChoices = residentPrefMap.get(resident);
            List<Resident> hospitalChoices = new ArrayList<>();
            hospitalChoices = hospitalPreMap.get(hospital);
            if (residentChoices.get(0) != hospital && hospitalChoices.get(0) != resident) {
                temp++;
            }
        }
        if (temp != 0)
            System.out.println("The matching produced by algorithm is not stable.");
        else
            System.out.println("The matching produced by algorithm is stable.");
    }

}





