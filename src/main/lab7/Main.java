public static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
    return new Student(
            st.getNumarMatricol(),
            st.getPrenume(),
            st.getNume(),
            nouaFormatieDeStudiu,
            st.getNota()
    );
}

public static java.util.Set<Student> imparteInDouaFormatii(java.util.Set<Student> studenti, String formatia1, String formatia2) {
    java.util.Set<Student> rezultat = new java.util.HashSet<>();
    int jumatate = (studenti.size() + 1) / 2;
    int contor = 0;

    for (Student s : studenti) {
        if (contor < jumatate) {
            rezultat.add(schimbaFormatia(s, formatia1));
        } else {
            rezultat.add(schimbaFormatia(s, formatia2));
        }
        contor++;
    }
    return rezultat;
}