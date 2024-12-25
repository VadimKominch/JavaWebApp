package by.epam.learn.vadimkominch.service;

import java.util.List;

public class LanguageService {
    private final List<String> availableLangs;

    private String choosen;

    public LanguageService() {
        availableLangs = List.of("Ru","En", "By");

        choosen = "Ru";
    }

    public String getChoosen() {
        return choosen;
    }

    public void setChoosen(String choosenCandidate) {
        boolean isValid = false;
        for (String lang: availableLangs) {
            if(lang.equals(choosenCandidate)) {
                isValid = true;
            }
        }
        if(isValid) {
            choosen = choosenCandidate;
        }
    }

    public List<String> getAvailableLangs() {
        return availableLangs;
    }

    private static class Holder {
        private static final LanguageService INSTANCE = new LanguageService();
    }

    public static LanguageService getInstance() {
        return LanguageService.Holder.INSTANCE;
    }
}
