package com.example.marksanalytics.service;

import com.example.marksanalytics.model.Marks;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

@Service
public class AnalyticsService {

    public String analytics(List<Marks> list) {
        var sr = situation(list, 0);
        StringBuilder sb = new StringBuilder("Средний балл: " + sr + " <br />\n");
        list.sort(Comparator.comparing(x -> 5 + x.getMark() * x.getWeight() / (x.getWeight() + 1), Comparator.naturalOrder()));
        for (Marks mark: list){
                    var str = mark.toString();
                    if (mark.getMark() == 2) {
                        mark.setMark(3);
                        sb.append(str).append(" ").append(situation(list, sr));
                        mark.setMark(4);
                        sb.append(" ").append(situation(list, sr));
                        mark.setMark(5);
                        sb.append(" ").append(situation(list, sr)).append(" <br />\n");
                        mark.setMark(2);
                    } else if (mark.getMark() == 3) {
                        sb.append(str).append(" - ");
                        mark.setMark(4);
                        sb.append(situation(list, sr));
                        mark.setMark(5);
                        sb.append(" ").append(situation(list, sr)).append(" <br />\n");
                        mark.setMark(3);
                    } else if (mark.getMark() == 4) {
                        mark.setMark(5);
                        sb.append(str).append(" - - ").append(situation(list, sr)).append(" <br />\n");
                        mark.setMark(4);
                    }
                }
        return sb.toString();
    }

    public double situation(List<Marks> marks, double sr) {
        int count = 0;
        int fact = 0;
        for (Marks mark: marks) {
            count += mark.getWeight();
            fact += mark.getMark() * mark.getWeight();
        }
        return new BigDecimal(fact).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).add(new BigDecimal(-1 * sr)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
