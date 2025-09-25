package br.edu.utfpr;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SalesReader {

    private final List<Sale> sales;

    public SalesReader(String salesFile) {

        final var dataStream = ClassLoader.getSystemResourceAsStream(salesFile);

        if (dataStream == null) {
            throw new IllegalStateException("File not found or is empty");
        }

        final var builder = new CsvToBeanBuilder<Sale>(new InputStreamReader(dataStream, StandardCharsets.UTF_8));

        sales = builder
                .withType(Sale.class)
                .withSeparator(';')
                .build()
                .parse();
    }

    public BigDecimal totalOfCompletedSales() {
        return sales.stream()
                .filter(Sale::isCompleted)
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalOfCancelledSales() {
        return sales.stream()
                .filter(Sale::isCancelled)
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Optional<Sale> mostRecentCompletedSale() {
        return sales.stream()
                .filter(Sale::isCompleted)
                .max(Comparator.comparing(Sale::getSaleDate));
    }

    public long daysBetweenFirstAndLastCancelledSale() {
        Optional<LocalDate> first = sales.stream()
                .filter(Sale::isCancelled)
                .map(Sale::getSaleDate)
                .min(Comparator.naturalOrder());

        Optional<LocalDate> last = sales.stream()
                .filter(Sale::isCancelled)
                .map(Sale::getSaleDate)
                .max(Comparator.naturalOrder());

        return  first.flatMap(start ->
                last.map(end -> ChronoUnit.DAYS.between(start, end))).get();
    }

    public long totalCompletedSalesBySeller(String sellerName) {
        LocalDate startDate = LocalDate.of(2012, 5, 12);
        LocalDate endDate = LocalDate.of(2012, 7, 29);

        return sales.stream()
                .filter(Sale::isCompleted)
                .filter(sale -> sellerName.equals(sale.getSeller()))
                .filter(sale -> {
                    LocalDate date = sale.getSaleDate();
                    return date != null && !date.isBefore(startDate) && !date.isAfter(endDate);
                }).count();
    }

    public long countAllSalesByManager(String managerName) {
        return sales.stream()
                .filter(sale -> managerName.equals(sale.getManager()))
                .count();
    }

    public BigDecimal totalSalesByStatusAndMonth(Sale.Status status, Month... months) {
        return sales.stream()
                .filter(sale -> sale.getStatus().equals(status))
                .filter(sale -> sale.getEstate().equals("PR"))
                .filter(sale -> Arrays.stream(months)
                        .anyMatch(month -> month.equals(sale.getSaleDate().getMonth())))
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, Long> countCompletedSalesByDepartment() {
        return sales.stream()
                .filter(Sale::isCompleted)
                .collect(Collectors.groupingBy(
                        Sale::getDepartment,
                        Collectors.counting()
                ));
    }

    public Map<Integer, Map<String, Long>> countCompletedSalesByPaymentMethodAndGroupingByYear() {
        return sales.stream()
                .filter(Sale::isCompleted)
                .collect(Collectors.groupingBy(
                        sale -> sale.getSaleDate().getYear(),
                        Collectors.groupingBy(
                                Sale::getPaymentMethod,
                                Collectors.counting()
                        )
                ));
    }

    public Map<Integer, BigDecimal> totalSalesByYear() {
        return sales.stream()
                .filter(Sale::isCompleted)
                .collect(Collectors.groupingBy(
                        sale -> sale.getSaleDate().getYear(),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Sale::getValue,
                                BigDecimal::add
                        )
                ));
    }

    public Optional<String> getManagerWithMostCancellationsBetween2013And2014() {
        LocalDate start = LocalDate.of(2013, 1, 1);
        LocalDate end = LocalDate.of(2014, 1, 1);

        return sales.stream()
                .filter(Sale::isCancelled)
                .filter(sale -> {
                    LocalDate date = sale.getSaleDate();
                    return date != null && !date.isBefore(start) && !date.isAfter(end);
                })
                .collect(Collectors.groupingBy(
                        Sale::getManager,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }


    public Map<String, BigDecimal> top3BestSellers() {
        return sales.stream()
                .filter(Sale::isCompleted)
                .collect(Collectors.groupingBy(
                        Sale::getSeller,
                        Collectors.reducing(BigDecimal.ZERO, Sale::getValue, BigDecimal::add)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
