package ru.netology.type;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class ProgressiveTaxTypeTests {

    ProgressiveTaxType sut;

    @BeforeEach
    public void init() {
        System.out.println("ProgressiveTaxType test started");
        sut = new ProgressiveTaxType();
    }

    @BeforeAll
    public static void started() {
        System.out.println("ProgressiveTaxType tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("ProgressiveTaxType test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("ProgressiveTaxType tests completed");
    }

    @Test
    public void testCalculateTaxFor_AmountBelowZero() {
        // given:
        BigDecimal expected = new BigDecimal("-0.10000");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("-1.000"));
        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalculateTaxFor_ZeroAmount() {
        // given:
        BigDecimal expected = new BigDecimal("0.00");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("0"));
        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalculateTaxFor_AmountOverTaxBracket() {
        // given:
        BigDecimal expected = new BigDecimal("15000.0000");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("100000.00"));
        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalculateTaxFor_AmountEqualsTaxBracket() {
        // given:
        BigDecimal expected = new BigDecimal("9999.999999999990");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("99999.9999999999"));
        // then:
        Assertions.assertEquals(expected, result);
    }
}
