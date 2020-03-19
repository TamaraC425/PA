package l4;

import com.github.javafaker.Faker;

import java.util.*;

public class Problem {
    private List<Resident> residents = new ArrayList<>();
    private List<Hospital> hospitals = new ArrayList<>();
    private Map<Resident, List<Hospital>> residentPrefMap = new HashMap<>();
    private Map<Hospital, List<Resident>> hospitalPreMap = new TreeMap<>();

    public Problem() {
    }

    public Problem(List<Resident> residents, List<Hospital> hospitals, Map<Resident, List<Hospital>> residentPrefMap, Map<Hospital, List<Resident>> hospitalPreMap) {
        this.residents = residents;
        this.hospitals = hospitals;
        this.residentPrefMap = residentPrefMap;
        this.hospitalPreMap = hospitalPreMap;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
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

    public void generateRandom(int n) {
        for (int i = 0; i < n; i++) {
            Faker fake = new Faker();
            String name = fake.name().fullName();
            Resident r = new Resident("Resident " + name);
            residents.add(r);
        }
        System.out.println("Lista de rezidenti generata random :");
        System.out.println(residents);
        for (int i = 0; i < n; i++) {
            Faker fake = new Faker();
            String name = fake.name().lastName();
            int capacity = (int) (Math.random() * (n / 2) + 1);
            Hospital h = new Hospital("Hospital " + name, capacity);
            hospitals.add(h);
        }
        System.out.println("Lista de spitale generate random :");
        for (Hospital h : hospitals)
            System.out.println(h.getName() + ' ' + h.getCapacity());
        ///adaugam preferintele pentru fiecare rezident
        for (int i = 0; i < n; i++) {
            int[] added = new int[n];
            List<Hospital> hospital = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                added[j] = 0;
            }
            int nrHospital = (int) (Math.random() * (n - 1) + 2);
            for (int l = 0; l < nrHospital; l++) {
                int k = (int) (Math.random() * n);
                while (added[k] == 1) {
                    k = (int) (Math.random() * n);
                }
                added[k]++;
                hospital.add(hospitals.get(k));
            }
            residentPrefMap.put(residents.get(i), hospital);
        }
        for (Map.Entry<Resident, List<Hospital>> entry : residentPrefMap.entrySet())
            System.out.println(entry.getKey() + ":" + "(" + entry.getValue() + ")");
        //adaugam preferintele pentru fiecare spital

        for (int i = 0; i < n; i++) {
            int[] added = new int[n];
            List<Resident> resident = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                added[j] = 0;
            }
            int nrResident = (int) (Math.random() * (n - 1) + 2);
            for (int l = 0; l < nrResident; l++) {
                int k = (int) (Math.random() * n);
                while (added[k] == 1) {
                    k = (int) (Math.random() * n);
                }
                added[k]++;
                resident.add(residents.get(k));
            }
            hospitalPreMap.put(hospitals.get(i), resident);
        }
        for (Map.Entry<Hospital, List<Resident>> entry : hospitalPreMap.entrySet())
            System.out.println(entry.getKey() + ":" + "(" + entry.getValue() + ")");


    }
}
