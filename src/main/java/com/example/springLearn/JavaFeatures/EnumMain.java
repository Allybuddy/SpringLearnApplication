package com.example.springLearn.JavaFeatures;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.springLearn.JavaFeatures.EnumTest.SAMSUNG;

@Slf4j
public class EnumMain {

    public static void main(String[] args) {

        // 1) values() - get all enum constants
        EnumTest[] enumm = EnumTest.values();
        log.info("values(): {}", Arrays.toString(enumm));

        // 2) valueOf(String) - strict lookup (throws if invalid)
        try {
            EnumTest apple = EnumTest.valueOf("APPLE");
            log.info("valueOf(\"APPLE\") => {} (rank={})", apple, apple.getRank());
        } catch (IllegalArgumentException ex) {
            log.info("APPLE not found via valueOf");
        }

        // 3) safe valueOf using helper
        /*log.info("valueOfSafe(\"XYZ\") => {}", EnumTest.valueOfSafe("XYZ"));
        log.info("valueOfSafe(\"SAMSUNG\") => {}", EnumTest.valueOfSafe("SAMSUNG").orElse(null));

        // 4) lookup by rank (fromRank)
        log.info("fromRank(2) => {}", EnumTest.fromRank(2).orElse(null));
        log.info("fromRank(99) => {}", EnumTest.fromRank(99).orElse(null));*/

        // 5) switch on enum
        EnumTest current = EnumTest.POCO;
        switch (current) {
            case SAMSUNG -> log.info("Switched: it's SAMSUNG");
            case POCO -> log.info("Switched: it's POCO");
            case APPLE -> log.info("Switched: it's APPLE");
            case SONY -> log.info("Switched: it's SONY");
            default -> log.info("Unknown");
        }

        // 6) EnumSet examples
        EnumSet<EnumTest> all = EnumSet.allOf(EnumTest.class);
        EnumSet<EnumTest> some = EnumSet.of(EnumTest.APPLE, EnumTest.SONY);
        EnumSet<EnumTest> range = EnumSet.range(EnumTest.SAMSUNG, EnumTest.APPLE);
        log.info("EnumSet all: {}", all);
        log.info("EnumSet some: {}", some);
        log.info("EnumSet range(SAMSUNG..APPLE): {}", range);

        // 7) EnumMap example
        EnumMap<EnumTest, String> map = new EnumMap<>(EnumTest.class);
        for (EnumTest e : EnumTest.values()) {
            map.put(e, "Rank-" + e.getRank());
        }
        log.info("EnumMap: {}", map);

        // 8) Streams & sorting by rank
        List<EnumTest> sortedByRank = Arrays.stream(EnumTest.values())
                .sorted(Comparator.comparingInt(EnumTest::getRank))
                .collect(Collectors.toList());
        log.info("sortedByRank: {}", sortedByRank);

        // 9) ordinal, name, toString, compareTo
        for (EnumTest t : EnumTest.values()) {
            log.info("name={} ordinal={} toString={} compareTo(SAMSUNG)={}",
                    t.name(), t.ordinal(), t.toString(), t.compareTo(SAMSUNG));
        }

        // 10) using Optional result from helpers
        /*EnumTest.valueOfSafe("APPLE").ifPresent(a -> log.info("valueOfSafe present: {}", a));
        EnumTest.fromRank(1).ifPresent(a -> log.info("fromRank present: {}", a));*/

    }
}
