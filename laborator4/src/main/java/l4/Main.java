package l4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
        int[] capacitate = new int[3];
        capacitate[0] = 1;
        capacitate[1] = capacitate[2] = 2;
        var h = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i, capacitate[i])).toArray(Hospital[]::new);
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));
        List<Resident> newSortedList = residentList.stream().sorted(Comparator.comparing(Resident::getName)).collect(Collectors.toList());
        System.out.println(newSortedList.toString());
        Set<Hospital> hospitalSet = new TreeSet<>();
        hospitalSet.add(h[0]);
        hospitalSet.add(h[1]);
        hospitalSet.add(h[2]);
        for (Hospital hospital : hospitalSet)
            System.out.print(hospital + ",");
        System.out.println();

        Map<Resident, List<Hospital>> residentPreferenceMap = new HashMap<>();
        //preferinte rezidenti
        residentPreferenceMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        residentPreferenceMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        residentPreferenceMap.put(r[2], Arrays.asList(h[0], h[1]));
        residentPreferenceMap.put(r[3], Arrays.asList(h[0], h[2]));

        for (Map.Entry<Resident, List<Hospital>> entry : residentPreferenceMap.entrySet())
            System.out.println(entry.getKey() + ":" + "(" + entry.getValue() + ")");
        //preference hospital
        Map<Hospital, List<Resident>> hospitalPreMap = new TreeMap<>();
        hospitalPreMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hospitalPreMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hospitalPreMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));
        for (Map.Entry<Hospital, List<Resident>> entry : hospitalPreMap.entrySet())
            System.out.println(entry.getKey() + ":" + "(" + entry.getValue() + ")");
        //
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result = residentList.stream().filter(res -> residentPreferenceMap.get(res).containsAll(target)).collect(Collectors.toList());
        System.out.println("Residents who find acceptable H0 and H2 : " + result);
        System.out.println("Hospitals that have R0 as their top preference : ");
        hospitalSet.stream().filter(res -> hospitalPreMap.get(res).indexOf(residentList.get(0)) == 0).forEach(System.out::println);
        ///optional
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalList.addAll(Arrays.asList(h));
        Matching m = new Matching(residentList, hospitalList, residentPreferenceMap, hospitalPreMap);
        m.printResult();
        Problem p = new Problem();
        p.generateRandom(4);
        Matching m1 = new Matching(p.getResidents(), p.getHospitals(), p.getResidentPrefMap(), p.getHospitalPreMap());
        m1.printResult();
        m1.verifyStableMatching();

    }

}

