package hr.tnebes.lovecalculator.services.impl;

import hr.tnebes.lovecalculator.services.LoveCalculatorService;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LoveCalculatorServiceImpl implements LoveCalculatorService {

    @Override
    public int getLovePercent(final String name1, final String name2) {
        if (!validateNames(name1, name2)) {
            return -1;
        }
        final String combinedNames = name1.trim().toLowerCase(Locale.ROOT) + name2.trim().toLowerCase(Locale.ROOT);
        final String letterArrayValues = calculateLetterArrayValues(combinedNames);
        return recursivelyCalculateLovePercent(letterArrayValues);
    }

    private boolean validateNames(final String name1, final String name2) {
        return name1 != null && !name1.isEmpty() && name2 != null && !name2.isEmpty();
    }

    private String calculateLetterArrayValues(final String combinedNames) {
        return Stream.of(combinedNames.split(""))
                .map(letter -> (int) (Stream.of(combinedNames.split(""))
                        .filter(letter::equals)
                        .count()))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private int recursivelyCalculateLovePercent(final String letterValues) {
        if (letterValues.length() <= 2) {
            return Integer.parseInt(letterValues);
        }

        StringBuilder newLetterValues = new StringBuilder();
        final String[] letterArrayValues = letterValues.split("");
        for (int i = 0, j = letterArrayValues.length - 1; i <= j; i++, j--) {
            if (i == j) {
                newLetterValues.append(letterArrayValues[i]);
                break;
            }
            newLetterValues.append(Integer.parseInt(letterArrayValues[i]) + Integer.parseInt(letterArrayValues[j]));
        }

        return recursivelyCalculateLovePercent(newLetterValues.toString());
    }

}